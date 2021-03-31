package business;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.VendaDAO;
import DAO.VendedorDAO;
import entities.*;

import java.util.Scanner;

public class VendaBusiness{

	public static Scanner scan = new Scanner(System.in);
	public static PedidoDAO pedidoDAO = new PedidoDAO();
	public static PedidoBusiness pedidoBusiness = new PedidoBusiness();
	public static Pedidos pedido = new Pedidos();
	public static ClienteDAO clienteDAO = new ClienteDAO();
	public static Cliente cliente = new Cliente();
	public static ClienteBusiness clienteBusiness = new ClienteBusiness();
	public static Vendedor vendedor = new Vendedor();
	public static VendedorDAO vendedorDAO = new VendedorDAO();
	public static VendedorBusiness vendedorBusiness = new VendedorBusiness();
	public static Venda venda = new Venda();
	public static VendaDAO vendaDAO = new VendaDAO();

	public static VendasPedidos vendasPedidos = new VendasPedidos();

	public void registroVenda() {
		System.out.println("/--- REGISTRAR VENDA ---/");

		try {
			clienteBusiness.imprimirCliente();
			System.out.print("Qual o código do cliente?");
			Long codigoCliente = scan.nextLong();
			Cliente clienteCompra = clienteDAO.findById(codigoCliente);

			vendedorBusiness.imprimirVendedores();
			System.out.print("Qual código do vendedor que lhe atendeu? ");
			Long codigoVendedor = scan.nextLong();
			Vendedor vendedorEscolhido = vendedorDAO.findById(codigoVendedor);

			pedidoBusiness.imprimirPedidos();
			System.out.println("Qual o código do pedido?");
			Long codigoPedido = scan.nextLong();
			Pedidos pedidoFeito = pedidoDAO.findById(codigoPedido);

			if (pedidoFeito != null && vendedorEscolhido != null && clienteCompra != null) {
				venda.setVendedor(vendedorEscolhido);
				venda.setCliente(clienteCompra);
				vendasPedidos.setPedidos(pedidoFeito);
				vendaDAO.save(venda);
			}
		} catch (Exception e) {
			System.out.println("Não foi possivel registrar a venda!");
		}
	}

}
