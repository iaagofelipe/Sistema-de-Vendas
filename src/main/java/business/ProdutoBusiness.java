package business;

import java.util.Scanner;

import DAO.ProdutosDAO;
import entities.Produtos;

public class ProdutoBusiness implements Business<Produtos>{
	
	public static Scanner scan  = new Scanner(System.in);
	public static ProdutosDAO produtosDAO = new ProdutosDAO();
			
	@Override
	public void salvar() {
		System.out.println("/---INSERIR PRODUTO---/");
		Produtos produto = new Produtos();

		try {
			scan.nextLine();
			System.out.print("Nome:");
			produto.setNomeProduto(scan.nextLine());
			System.out.print("Descrição:");
			produto.setDescricaoProduto(scan.nextLine());
			System.out.print("Preço: R$ ");
			produto.setPreco(scan.nextDouble());

			produtosDAO.save(produto);
		} catch(Exception e) {
			throw new RuntimeException("Não foi possivel salvar um produto." + e);
		}		
	}

	@Override
	public void editar() {
		System.out.println("/--- EDITAR PRODUTO---/");
		Produtos produto = new Produtos();

		scan.nextLine();
		System.out.print("Insira o código do Produto para editar:");
		String codigo = scan.nextLine().trim();

		produto = produtosDAO.findById(Long.parseLong(codigo));
		if(produto != null) {
			System.out.println("Produto:");
			System.out.print(produto.toString());
			System.out.println("\nQual campo deseja editar?");
			System.out.println("1- Nome");
			System.out.println("2- Descrição");
			System.out.println("3- Preço");
			System.out.println("4- Todos");

			int op = Integer.parseInt(scan.nextLine());
			switch(op) {
			case 1:
				System.out.print("Nome:");
				produto.setNomeProduto(scan.nextLine());
				break;
			case 2:
				System.out.print("Descrição:");
				produto.setDescricaoProduto(scan.nextLine());
				break;
			case 3:
				System.out.print("Preço: R$");
				produto.setPreco(scan.nextDouble());
				break;
			case 4:
				scan.nextLine();
				System.out.print("Nome:");
				produto.setNomeProduto(scan.nextLine());
				System.out.print("Descricao:");
				produto.setDescricaoProduto(scan.nextLine());
				System.out.print("Preço: R$ ");
				produto.setPreco(scan.nextDouble());
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			produtosDAO.update(produto);
		}else {
			System.out.println("Produto não encontrado");
		}		
	}

	@Override
	public void excluir() {
		System.out.println("/--- EXCLUIR PRODUTO --- /");
		System.out.print("Insira o código do Produto para excuir: ");
		scan.nextLine();
		String codigo = scan.nextLine();

		if(codigo != null && codigo != "")
			produtosDAO.delete(Long.parseLong(codigo));
		else
			System.out.println("Código inválido!");		
	}

	@Override
	public void menu() {
		System.out.println("Insira uma das opções abaixo:");
		System.out.println(" 1- Inserir produto;");
		System.out.println(" 2- Listar produtos;");
		System.out.println(" 3- Alterar produto;");
		System.out.println(" 4- Excluir produto.");

		int op = scan.nextInt();

		switch(op) {
		case 1:
			this.salvar();
			break;
		case 2:
			for(Produtos produto : produtosDAO.getList()) {
				System.out.println(produto.toString());
			}
			break;
		case 3:
			this.editar();
			break;
		case 4:
			this.excluir();
			break;
		default:
			break;
		}		
	}

}
