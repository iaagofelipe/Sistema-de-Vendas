package business;

import java.util.Scanner;

import DAO.ClienteDAO;
import entities.Cliente;

public class ClienteBusiness implements Business<Cliente>{
	public static Scanner scan  = new Scanner(System.in);
	public static ClienteDAO clienteDAO = new ClienteDAO();
	
	@Override
	public void salvar() {
       System.out.println("/---INSERIR CLIENTE---/");
       Cliente cliente = new Cliente();
       
       try {
       System.out.print("Nome:");
       cliente.setNome(scan.next());
       System.out.println("");
       System.out.print("CPF:");
       cliente.setCpf(scan.next());
       System.out.println("");
       System.out.print("Telefone:");
       cliente.setTelefone(scan.next());
       System.out.println("");
       System.out.println("Endereço:");
       cliente.setEndereco(scan.next());
       System.out.println("");
       
       clienteDAO.save(cliente);
       } catch(Exception e) {
			throw new RuntimeException("Não foi possivel salvar um produto." + e);
		}
       
	}

	@Override
	public void editar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menu() {
		System.out.println("Insira uma das opções abaixo:");
		System.out.println(" 1- Inserir cliente;");
		System.out.println(" 2- Listar clientes;");
		System.out.println(" 3- Alterar cliente.");
		
		int op = scan.nextInt();
		
		switch(op) {
		case 1:
			this.salvar();
			break;
		case 2:
			System.out.println("Mostrar");
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
