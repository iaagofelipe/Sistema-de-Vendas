package DAO;

import conexao.ConnectionFactory;
import entities.Cliente;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.annotations.common.util.impl.Log;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

public class ClienteDAO implements DAO<Cliente> {

    //Conexão entre o banco e as classes
    private final EntityManager entityManager = new ConnectionFactory().getConnection();

    @Override
    public Cliente save(Cliente cliente) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(cliente);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return cliente;
    }

    @Override
    public List<Cliente> getList() {
        Query query = this.entityManager.createQuery("SELECT * FROM cliente");
        return query.getResultList();
    }

    @Override
    public Cliente update(Cliente cliente) {
        Cliente clienteUp = null;
        try {
            this.entityManager.getTransaction().begin();
            if (cliente.getID() == null) {
                this.entityManager.persist(cliente);
            } else {
                clienteUp = this.entityManager.merge(cliente);
            }
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return clienteUp;
    }

    @Override
    public Cliente delete(Long ID) {
        Cliente cliente = null;
        try {
            cliente = entityManager.find(Cliente.class, ID);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(cliente);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return cliente;
    }

    @Override
    public Cliente findById(Long ID) {
        Cliente cliente = null;
        try {
            cliente = entityManager.find(Cliente.class, ID);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar por id" + e);
        }
        return cliente;
    }
}
