package business;

import DAO.VendedorDAO;
import entities.Vendedor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VendedorBusiness implements Business<Vendedor>{
	
	public static VendedorDAO vendedorDAO = new VendedorDAO();
	public static Scanner scan  = new Scanner(System.in);

	@Override
	public void salvar() {
		System.out.println("/---INSERIR VENDEDOR---/");
		Vendedor vendedor = new Vendedor();
		
		try {
			scan.nextLine();
			System.out.print("Nome:");
			vendedor.setNome(scan.nextLine());
			System.out.print("CPF:");
			vendedor.setCpf(scan.nextLine());
			System.out.print("Telefone:");
			vendedor.setTelefone(scan.nextLine());
			System.out.print("Data de nascimento:");
			String dataNascimento = scan.nextLine().trim();
			vendedor.setDataNascimento(this.convertData(dataNascimento));
			
			vendedorDAO.save(vendedor);
		} catch(Exception e) {
			throw new RuntimeException("Não foi possivel salvar um vendedor." + e);
		}		
	}

	@Override
	public void editar() {
		System.out.println("/--- EDITAR VENDEDOR---/");
		Vendedor vendedor = new Vendedor();

		scan.nextLine();
		System.out.print("Insira o código do Vendedor para editar:");
		String codigo = scan.nextLine();

		vendedor = vendedorDAO.findById(Long.parseLong(codigo));
		if(vendedor != null) {
			System.out.println("Vendedor:");
			System.out.print(vendedor.toString());
			System.out.println("\nQual campo deseja editar?");
			System.out.println("1- Nome");
			System.out.println("2- CPF");
			System.out.println("3- Data de Nascimento");
			System.out.println("4- Número de telefone");
			System.out.println("5- Todos");

			int op = Integer.parseInt(scan.nextLine());
			switch(op) {
			case 1:
				System.out.print("Nome:");
				vendedor.setNome(scan.nextLine());
				break;
			case 2:
				System.out.print("CPF:");
				vendedor.setCpf(scan.nextLine());
				break;
			case 3:
				System.out.print("Data de Nascimento:");
				try {
					vendedor.setDataNascimento(this.convertData(scan.nextLine().trim()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				break;
			case 4:
				System.out.print("Telefone:");
				vendedor.setTelefone(scan.nextLine());
				break;
			case 5:
				scan.nextLine();
				System.out.print("Nome:");
				vendedor.setNome(scan.nextLine());
				System.out.print("CPF:");
				vendedor.setCpf(scan.nextLine());
				System.out.print("Telefone:");
				vendedor.setTelefone(scan.nextLine());
				System.out.print("Data de nascimento:");
				String dataNascimento = scan.nextLine().trim();
				try {
					vendedor.setDataNascimento(this.convertData(dataNascimento));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			vendedorDAO.update(vendedor);
		}else {
			System.out.println("Cliente não encontrado");
		}		
	}

	@Override
	public void excluir() {
		System.out.println("/--- EXCLUIR VENDEDOR --- /");
		System.out.print("Insira o código do Vendedor para excuir: ");
		scan.nextLine();
		String codigo = scan.nextLine();

		if(codigo != null && !codigo.isEmpty())
			vendedorDAO.delete(Long.parseLong(codigo));
		else
			System.out.println("Código inválido!");
	}

	@Override
	public void menu() {
		System.out.println("Insira uma das opções abaixo:");
		System.out.println(" 1- Inserir vendedor;");
		System.out.println(" 2- Listar vendedores;");
		System.out.println(" 3- Alterar vendedor.");
		System.out.println(" 4- Excluir vendedor.");

		int op = scan.nextInt();

		switch (op) {
			case 1:
				salvar();
				break;
			case 2:
				imprimirVendedores();
				break;
			case 3:
				editar();
				break;
			case 4:
				excluir();
				break;
			default:
				break;
		}
	}

	public void imprimirVendedores() {
		try {
			List<Vendedor> vendedoresList = vendedorDAO.getList();
			if (vendedoresList != null && !vendedoresList.isEmpty()) {
				for (Vendedor vendedores : vendedoresList) {
					System.out.println(vendedores);
				}
			} else {
				System.out.println("Não há vendedores cadastrados");
			}
		} catch (Exception e) {
			throw new RuntimeException("Não foi possível imprimir a lista de vendedores.");
		}
	}
	
	private Date convertData(String dataP) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate data = LocalDate.of(
				Integer.parseInt(dataP.substring(6,10)), 
				Integer.parseInt(dataP.substring(3,5))	, 
				Integer.parseInt(dataP.substring(0,2)));
		return sdf.parse(data.toString());
	}

	public void closeDAOConnection() {
		vendedorDAO.close();
	}

}
