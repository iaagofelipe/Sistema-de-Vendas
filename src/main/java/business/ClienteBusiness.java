package business;

import java.util.Scanner;

import DAO.ClienteDAO;
import antlr.collections.List;
import entities.Cliente;

public class ClienteBusiness implements Business<Cliente>{

	public static Scanner scan  = new Scanner(System.in);
	public static ClienteDAO clienteDAO = new ClienteDAO();

	@Override
	public void salvar() {
		System.out.println("/---INSERIR CLIENTE---/");
		Cliente cliente = new Cliente();

		try {
			scan.nextLine();
			System.out.print("Nome:");
			cliente.setNome(scan.nextLine());
			System.out.print("CPF:");
			cliente.setCpf(scan.nextLine());
			System.out.print("Telefone:");
			cliente.setTelefone(scan.nextLine());
			System.out.print("Endereço:");
			cliente.setEndereco(scan.nextLine());

			clienteDAO.save(cliente);
		} catch(Exception e) {
			throw new RuntimeException("Não foi possivel salvar um cliente." + e);
		}

	}

	@Override
	public void editar() {
		System.out.println("/--- EDITAR CLIENTE---/");
		Cliente cliente = new Cliente();

		scan.nextLine();
		System.out.print("Insira o código do Cliente para editar:");
		String codigo = scan.nextLine();

		cliente = clienteDAO.findById(Long.parseLong(codigo));
		if(cliente != null) {
			System.out.println("Cliente:");
			System.out.print(cliente.toString());
			System.out.println("\nQual campo deseja editar?");
			System.out.println("1- Nome");
			System.out.println("2- CPF");
			System.out.println("3- Endereço");
			System.out.println("4- Número de telefone:");
			System.out.println("5- Todos");

			int op = Integer.parseInt(scan.nextLine());
			switch(op) {
			case 1:
				System.out.print("Nome:");
				cliente.setNome(scan.nextLine());
				break;
			case 2:
				System.out.print("CPF:");
				cliente.setCpf(scan.nextLine());
				break;
			case 3:
				System.out.print("Endereço:");
				cliente.setEndereco(scan.nextLine());
				break;
			case 4:
				System.out.print("Telefone:");
				cliente.setTelefone(scan.nextLine());
				break;
			case 5:
				scan.nextLine();
				System.out.print("Nome:");
				cliente.setNome(scan.nextLine());
				System.out.print("CPF:");
				cliente.setCpf(scan.nextLine());
				System.out.print("Telefone:");
				cliente.setTelefone(scan.nextLine());
				System.out.print("Endereço:");
				cliente.setEndereco(scan.nextLine());
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			clienteDAO.update(cliente);
		}else {
			System.out.println("Cliente não encontrado");
		}
	}

	@Override
	public void excluir() {

		System.out.println("/--- EXCLUIR CLIENTE --- /");
		System.out.print("Insira o código do Cliente para excuir: ");
		scan.nextLine();
		String codigo = scan.nextLine();

		if(codigo != null && codigo != "")
			clienteDAO.delete(Long.parseLong(codigo));
		else
			System.out.println("Código inválido!");

	}

	@Override
	public void menu() {
		System.out.println("Insira uma das opções abaixo:");
		System.out.println(" 1- Inserir cliente;");
		System.out.println(" 2- Listar clientes;");
		System.out.println(" 3- Alterar cliente.");
		System.out.println(" 4- Excluir cliente.");

		int op = scan.nextInt();

		switch(op) {
		case 1:
			this.salvar();
			break;
		case 2:
			for(Cliente cliente : clienteDAO.getList()) {
				System.out.println(cliente.toString());
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
