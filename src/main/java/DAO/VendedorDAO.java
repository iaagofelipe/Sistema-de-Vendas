package DAO;

import conexao.ConnectionFactory;
import entities.Cliente;
import entities.Vendedor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class VendedorDAO implements DAO<Vendedor> {

    private final EntityManager entityManager = new ConnectionFactory().getConnection();

    @Override
    public Vendedor save(Vendedor vendedor) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(vendedor);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return vendedor;
    }

    @Override
    public List getList() {
        Query query = this.entityManager.createQuery("SELECT * FROM vendedor");
        return query.getResultList();
    }

    @Override
    public Vendedor update(Vendedor vendedor) {
        Vendedor vendedorUp = null;
        try {
            this.entityManager.getTransaction().begin();
            if (vendedor.getID() == null) {
                this.entityManager.persist(vendedor);
            } else {
                vendedorUp = this.entityManager.merge(vendedor);
            }
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return vendedorUp;
    }

    @Override
    public Vendedor delete(Long id) {
        Vendedor vendedor = null;
        try {
            vendedor = entityManager.find(Vendedor.class, id);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(vendedor);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return vendedor;
    }

    @Override
    public Vendedor findById(Long id) {
        Vendedor vendedor = null;
        try {
            vendedor = entityManager.find(Vendedor.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar por id" + e);
        }
        return vendedor;
    }
}
