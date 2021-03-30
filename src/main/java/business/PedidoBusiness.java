package business;

import DAO.PedidoDAO;
import DAO.ProdutosDAO;
import entities.Pedidos;
import entities.Produtos;

import java.util.List;
import java.util.Scanner;

public class PedidoBusiness {
	public static Scanner scan = new Scanner(System.in);
	public static Produtos produtos = new Produtos();
	public static Pedidos pedidos = new Pedidos();
	public static PedidoDAO pedidoDAO = new PedidoDAO();
	public static ProdutosDAO produtosDAO = new ProdutosDAO();

	public void fazerPedido() {
		imprimirProdutosDisponiveis();

		System.out.println("Digite o código do produto que deseja: ");
		Long codigoProduto = scan.nextLong();
		Produtos produtoEscolhido = produtosDAO.findById(codigoProduto);
		pedidos.setProdutos(produtoEscolhido);

		System.out.println("Digite a quantidade: ");
		int quantidadeProduto = scan.nextInt();

		if (quantidadeProduto > 0) {
			produtoEscolhido.setQuantidade(quantidadeProduto);
		}
		pedidoDAO.save(pedidos);
	}

	public void imprimirProdutosDisponiveis() {
		try {
			List<Produtos> produtosList= produtosDAO.getList();
			if (produtosList != null) {
				for (Produtos produtos : produtosList)
					System.out.println(produtos);
			}
		} catch (Exception e) {
			System.out.println("Não foi possível imprimir a lista de produtos.");
		}
	}

	public void imprimirPedidos() {
		try {
			List<Pedidos> pedidosList = pedidoDAO.getList();
			if (pedidosList != null && !pedidosList.isEmpty()) {
				for (Pedidos pedidos : pedidosList) {
					System.out.println(pedidos);
				}
			} else {
				System.out.println("Nenhum pedido realizado!");
			}
		} catch (Exception e) {
			throw  new RuntimeException("Não foi possivel imprimir a lista de pedidos" + e);
		}
	}

	public void editarPedido() {
		System.out.println("/--- EDITAR PEDIDO ---/");
		System.out.println("Pedidos existentes:");
		imprimirPedidos();
		scan.nextLine();
		System.out.println("Insira o código do pedido para editar: ");
		String codigo = scan.nextLine().trim();

		pedidos = pedidoDAO.findById(Long.parseLong(codigo));
		if (pedidos != null) {
			System.out.println("Pedido:");
			System.out.print(pedidos.toString());
			System.out.println("\nQual campo deseja editar?");
			System.out.println("1- Produto");
			System.out.println("2- Quantidade");
			System.out.println("3- Sair");

			int op = Integer.parseInt(scan.nextLine());
			switch (op) {
				case 1:
					System.out.println("Digite o código do produto: ");
					Long codigoProduto = scan.nextLong();
					Produtos produtoEscolhido = produtosDAO.findById(codigoProduto);
					pedidos.setProdutos(produtoEscolhido);
					break;
				case 2:
					System.out.println("Digite a quantidade: ");
					pedidos.getProdutos().setQuantidade(scan.nextInt());
					break;
				case 3:
					break;
				default:
					System.out.println("Opção Inválida!");
					break;
			}
		}
	}


	private void deletarPedido() {
		System.out.println("/--- EXCLUIR PEDIDO ---/");
		imprimirPedidos();
		System.out.print("Insira o código do pedido para excuir: ");
		scan.nextLine();
		String codigo = scan.nextLine();

		if (codigo != null && codigo != "") {
			pedidoDAO.delete(Long.parseLong(codigo));
			System.out.println("Deletado com sucesso!");
		} else {
			System.out.println("Código inválido!");
		}
	}

	public void menu() {
		System.out.println("Insira uma das opções abaixo:");
		System.out.println("1- Fazer um pedido:");
		System.out.println("2- Editar pedido");
		System.out.println("3- Imprimir pedidos realizados");
		System.out.println("4- Deletar pedido");

		int op = scan.nextInt();
		switch (op) {
			case 1:
				fazerPedido();
				break;
			case 2:
				editarPedido();
				break;
			case 3:
				imprimirPedidos();
				break;
			case 4:
				deletarPedido();
				break;
			default:
				System.out.println("Opção inválida!");
				break;
		}
	}
}
