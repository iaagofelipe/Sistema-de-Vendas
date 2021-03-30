package teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ProdutosDAO;
import DAO.VendedorDAO;
import business.ClienteBusiness;
import business.ProdutoBusiness;
import business.VendedorBusiness;
import entities.Cliente;
import entities.Pedidos;
import entities.Produtos;
import entities.Vendedor;

public class SistemaTeste {
	public static VendedorDAO vendedorDAO = new VendedorDAO();
	public static PedidoDAO pedidoDAO = new PedidoDAO();
	public static ClienteBusiness clienteBusiness = new ClienteBusiness();
	public static ProdutoBusiness produtoBusiness = new ProdutoBusiness();
	public static VendedorBusiness vendedorBusiness = new VendedorBusiness();
	public static Scanner scan  = new Scanner(System.in);

	public static void main(String[] args) throws ParseException {

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
		case 2: 
			produtoBusiness.menu();
			break;
		case 3:
			clienteBusiness.menu();
			break;
		case 4: 
			vendedorBusiness.menu();
			break;
		default:
			System.out.println("Opção Inválida");
			break;
		}
	}	
}
