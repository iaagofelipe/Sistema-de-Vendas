package DAO;

import conexao.ConnectionFactory;
import entities.Vendedor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class VendedorDAO implements DAO<Vendedor> {

    private final EntityManager entityManager = new ConnectionFactory().getConnection();
    public Vendedor vendedorUP = null;

    @Override
    public Vendedor save(Vendedor vendedor) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(vendedor);
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possivel salvar" + e);
        }
        return vendedor;
    }

    @Override
    public List<Vendedor> getList() {
        Query query = this.entityManager.createQuery("SELECT v FROM Vendedor as v");
        return query.getResultList();
    }

    @Override
    public Vendedor update(Vendedor vendedor) {
        try {
            this.entityManager.getTransaction().begin();
            if (vendedor.getID() == null) {
                this.entityManager.persist(vendedor);
            } else {
                vendedorUP = this.entityManager.merge(vendedor);
            }
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possível atualizar");
        }
        return vendedorUP;
    }

    @Override
    public Vendedor delete(Long id) {
        try {
            vendedorUP = entityManager.find(Vendedor.class, id);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(vendedorUP);
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possível remover" + e);
        }
        return vendedorUP;
    }

    @Override
    public Vendedor findById(Long id) {
        try {
            vendedorUP = entityManager.find(Vendedor.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar por id" + e);
        }
        return vendedorUP;
    }
}
