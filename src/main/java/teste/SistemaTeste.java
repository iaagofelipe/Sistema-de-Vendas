package teste;

import DAO.ClienteDAO;
import entities.Cliente;

public class SistemaTeste {
    public static void main(String[] args) {
        System.out.println("Iniciando...");

        Cliente cliente = new Cliente();
        cliente.setNome("Iago");
        cliente.setCpf("11111111111");
        cliente.setTelefone("85999999999");
        cliente.setEndereco("Rua das caixas daguas");

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.save(cliente);
    }
}
