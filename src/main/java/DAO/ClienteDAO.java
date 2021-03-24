package DAO;

import conexao.ConnectionFactory;
import entities.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClienteDAO implements DAO<Cliente> {

    //Conexão entre o banco e as classes
    private final EntityManager entityManager = new ConnectionFactory().getConnection();
    public Cliente clienteUP = null;

    @Override
    public Cliente save(Cliente cliente) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(cliente);
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possivel salvar" + e);
        }
        return cliente;
    }

    @Override
    public List<Cliente> getList() {
        Query query = this.entityManager.createQuery("SELECT c FROM Cliente as c");
        return query.getResultList();
    }

    @Override
    public Cliente update(Cliente cliente) {
        try {
            this.entityManager.getTransaction().begin();
            if (cliente.getID() == null) {
                this.entityManager.persist(cliente);
            } else {
                clienteUP = this.entityManager.merge(cliente);
            }
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possível atualizar" + e);
        }
        return clienteUP;
    }

    @Override
    public Cliente delete(Long ID) {
        try {
            clienteUP = entityManager.find(Cliente.class, ID);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(clienteUP);
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possível remover" + e);
        }
        return clienteUP;
    }

    @Override
    public Cliente findById(Long ID) {
        try {
            clienteUP = entityManager.find(Cliente.class, ID);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar por id" + e);
        }
        return clienteUP;
    }
}
