package teste;

import java.util.Scanner;

import business.ClienteBusiness;
import business.PedidoBusiness;
import business.ProdutoBusiness;
import business.VendaBusiness;
import business.VendedorBusiness;

public class SistemaTeste {
	public static ClienteBusiness clienteBusiness = new ClienteBusiness();
	public static ProdutoBusiness produtoBusiness = new ProdutoBusiness();
	public static VendedorBusiness vendedorBusiness = new VendedorBusiness();
	public static PedidoBusiness pedidoBusiness = new PedidoBusiness();
	public static VendaBusiness vendaBusiness = new VendaBusiness();
	public static Scanner scan  = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Iniciando...");
		int op;
		while (true) {

			System.out.println("/--------- SISTEMA DE VENDAS DE PRODUTOS------/");
			System.out.println("1- Vendas");
			System.out.println("2- Produtos");
			System.out.println("3- Clientes");
			System.out.println("4- Vendedores");
			System.out.println("0- Sair");
			System.out.println("Digite o módulo que deseja acessar: ");
			op = scan.nextInt();

			switch(op) {
				case 0:
					closeConnectionAndExit();
					break;
				case 1:
					vendaBusiness.menu();
					break;
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

	public static void closeConnectionAndExit() {
		produtoBusiness.closeDAOConnection();
		vendedorBusiness.closeDAOConnection();
		clienteBusiness.closeDAOConnection();
		pedidoBusiness.closeDAOConnection();
		vendaBusiness.closeDAOConnection();

		System.exit(0);
	}
}
