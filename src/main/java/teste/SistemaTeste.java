package teste;

import DAO.ClienteDAO;
import entities.Cliente;

public class SistemaTeste {
    public static void main(String[] args) {
        System.out.println("Iniciando...");

        Cliente cliente = new Cliente();
        cliente.setNome("Silva");
        cliente.setCpf("55532111111");
        cliente.setTelefone("85976549239");
        cliente.setEndereco("Rua das caixas daguas");

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.save(cliente);
    }
}
