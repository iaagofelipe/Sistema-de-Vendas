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

	public void escolherProduto() {
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
			ProdutosDAO produtosDAO = new ProdutosDAO();
			List<Produtos> produtosList= produtosDAO.getList();
			if (produtosList != null) {
				for (Produtos produtos : produtosList)
					System.out.println(produtos);
			}
		} catch (Exception e) {
			System.out.println("Não foi possível imprimir a lista de produtos.");
		}
	}

	public void editarPedido() {
		System.out.println("/--- EDITAR PEDIDO ---/");
		scan.nextLine();
		System.out.println("Insira o código do produto para editar: ");
		String codigo = scan.nextLine().trim();

		pedidos = pedidoDAO.findById(Long.parseLong(codigo));
		if (pedidos != null) {
			System.out.println("Pedido:");
			System.out.print(pedidos.toString());
			System.out.println("\nQual campo deseja editar?");
			System.out.println("1- Produto");
			System.out.println("2- Quantidade");

			int op = Integer.parseInt(scan.nextLine());
			switch (op) {
				
			}
		}
	}


}
