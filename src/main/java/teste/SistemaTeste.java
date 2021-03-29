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
	public static ProdutosDAO produtosDAO = new ProdutosDAO();
	public static VendedorDAO vendedorDAO = new VendedorDAO();
	public static PedidoDAO pedidoDAO = new PedidoDAO();
	public static ClienteBusiness clienteBusiness = new ClienteBusiness();
	public static Scanner scan  = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		System.out.println("/--------- SISTEMA DE VENDAS DE PRODUTOS------/");
		System.out.println("1- Vendas");
		System.out.println("2- Produtos");
		System.out.println("3- Clientes");
		System.out.println("4- Vendedores");
		System.out.println("Qual módulo deseja usar?");
		int op = scan.nextInt();
		
		switch(op) {
		case 1: break;
		case 2: break;
		case 3:
			clienteBusiness.menu();
			break;
		case 4: break;
		default:
			System.out.println("Opção Inválida");
			break;
		}
	}	
}
