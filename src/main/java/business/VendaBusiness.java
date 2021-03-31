package business;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.VendasDAO;
import DAO.Vendas_PedidosDAO;
import DAO.VendedorDAO;
import entities.*;

import java.util.Scanner;

public class VendaBusiness implements Business{
	public static Scanner scan = new Scanner(System.in);
	public static VendasDAO vendaDAO = new VendasDAO();
	public static ClienteDAO clienteDAO = new ClienteDAO();
	public static VendedorDAO vendedorDAO = new VendedorDAO();
	public static PedidoBusiness pedidoBusiness = new PedidoBusiness();
	public static Vendas_PedidosDAO vendasPedidoDAO = new Vendas_PedidosDAO();

	@Override
	public void salvar() {
		Venda venda = new Venda();
		System.out.println("Insira o código do cliente: ");
		Cliente cliente = clienteDAO.findById(scan.nextLong());
		if(cliente != null) {
			System.out.println("Cliente:\n" + cliente.toString());
			System.out.println("Insira o código do vendedor: ");
			Vendedor vendedor = vendedorDAO.findById(scan.nextLong());
			if(vendedor != null) {
				System.out.println("Vendedor:\n" + vendedor.toString());
				venda.setCliente(cliente);
				venda.setVendedores(vendedor);
				venda.setPrecoTotal((double) 0);
				Venda param = vendaDAO.save(venda);
				pedidoBusiness.menu(vendedor.getID(), cliente.getID(), param.getID());
			} else {
				System.out.println("Código inválido");
			}

		}else {
			System.out.println("Código inválido");
		}
	}

	@Override
	public void editar() {

	}

	@Override
	public void excluir() {
		System.out.println("/--- EXCLUIR VENDA---/");
		System.out.print("Insira o código da venda para excuir: ");
		scan.nextLine();
		String codigo = scan.nextLine();

		if (codigo != null && !codigo.isEmpty()) {
			for (VendasPedidos vp : vendasPedidoDAO.getList()) {
				if(vp.getVenda().getID().equals(Long.parseLong(codigo))) {
					vendasPedidoDAO.delete(vp.getID());
				}
			}
			vendaDAO.delete(Long.parseLong(codigo));
			System.out.println("Deletado com sucesso!");
		} else {
			System.out.println("Código inválido!");
		}

	}

	@Override
	public void menu() {
		System.out.println("Insira uma das opções abaixo:");
		System.out.println("1- Fazer um venda:");
//		System.out.println("2- Editar venda");
		System.out.println("2- Imprimir  vendas realizadas");
		System.out.println("3- Deletar vendas");

		int op = scan.nextInt();
		switch (op) {
		case 1:
			this.salvar();
			break;
		case 2:
			for(Venda venda: vendaDAO.getList()) {
				for(VendasPedidos vendaP: vendasPedidoDAO.getList()) {
					if(venda.getID().equals(vendaP.getVenda().getID())) {
						System.out.println(vendaP.toString());
					}
				}
			}
			break;
		case 3:
			this.excluir();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}

	}
}
