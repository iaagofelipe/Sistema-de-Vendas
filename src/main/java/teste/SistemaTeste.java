package teste;

import java.util.Scanner;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ProdutosDAO;
import DAO.VendedorDAO;
import business.ClienteBusiness;
import entities.Cliente;
import entities.Pedidos;
import entities.Produtos;
import entities.Vendedor;

public class SistemaTeste {
	public static ClienteDAO clienteDAO = new ClienteDAO();
	public static ProdutosDAO produtosDAO = new ProdutosDAO();
	public static VendedorDAO vendedorDAO = new VendedorDAO();
	public static PedidoDAO pedidoDAO = new PedidoDAO();
	public static ClienteBusiness clienteBusiness = new ClienteBusiness();
	public static Scanner scan  = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		System.out.println("/--------- SISTEMA DE VENDAS DE PRODUTOS------/");
	
//		System.out.println("1- Vendas");
//		System.out.println(" 1.2- Inserir venda;");
//		System.out.println(" 1.1- Listar vendas;");
//		System.out.println(" 1.2- Alterar venda;");
//		
//		System.out.println(" 1.3 Pedidos");
//		System.out.println(" 1.4- Inserir pedido;");
//		System.out.println(" 1.5- Listar pedido;");
//		System.out.println(" 1.6- Alterar pedido;");
//		
//		System.out.println("2- Produtos");
//		System.out.println(" 2.1- Inserir produto;");
//		System.out.println(" 2.2- Listar produtos;");
//		System.out.println(" 2.3- Alterar produtos.");
		
		System.out.println("3- Clientes");
		
		System.out.println("Qual módulo deseja usar?");
		int op = scan.nextInt();
		
		switch(op) {
		case 3:
			clienteBusiness.menu();
			break;
		default:
			System.out.println("Opção Inválida");
			break;
		}
//		System.out.println(" 3.1- Inserir cliente;");
//		System.out.println(" 3.2- Listar clientes;");
//		System.out.println(" 3.3- Alterar cliente.");
		
//		System.out.println("4- Vendedores");
//		System.out.println(" 4.1- Inserir vendedor;");
//		System.out.println(" 4.2- Listar vendedores;");
//		System.out.println(" 4.3- Alterar vendedor.");
//		
		
		
//		System.out.print("Insira um valor:");
//		String teste = ler.nextLine();
//		System.out.println(teste);
//		teste = ler.nextLine();
//		System.out.println(teste);
		
//		Cliente cliente = new Cliente();
//		cliente.setNome("Silva");
//		cliente.setCpf("55532111111");
//		cliente.setTelefone("85976549239");
//		cliente.setEndereco("Rua das caixas daguas");
//		
//		salvarCliente(cliente);
	}

	public static void salvarCliente(Cliente cliente) {
		try {
			clienteDAO.save(cliente);
		}catch(Exception e) {
			throw new RuntimeException("Não foi possivel salvar um cliente." + e);
		}
	}
	
	public static void salvarProduto(Produtos produto) {
		try {
			produtosDAO.save(produto);
		}catch(Exception e) {
			throw new RuntimeException("Não foi possivel salvar um produto." + e);
		}
	}
	
	public static void salvarVendedor(Vendedor vendedor) {
		try {
			vendedorDAO.save(vendedor);
		}catch(Exception e) {
			throw new RuntimeException("Não foi possivel salvar um vendedor." + e);
		}
	}
	
	public static void salvarPedido(Pedidos pedido) {
		try {
			pedidoDAO.save(pedido);
		}catch(Exception e) {
			throw new RuntimeException("Não foi possivel salvar um vendedor." + e);
		}
	}
	
	
	
	
}
