package DAO;

import conexao.ConnectionFactory;
import entities.Venda;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class VendaDAO implements DAO<Venda> {
    private final EntityManager entityManager = new ConnectionFactory().getConnection();
    public Venda vendaUP = null;

    @Override
    public Venda save(Venda venda) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(venda);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possivel salvar" + e);
        }
        return venda;
    }

    @Override
    public List<Venda> getList() {
        Query query = this.entityManager.createQuery("SELECT v FROM Venda as v");
        return query.getResultList();
    }

    @Override
    public Venda update(Venda venda) {
        try {
            this.entityManager.getTransaction().begin();
            if (venda.getID() == null) {
                this.entityManager.persist(venda);
            } else {
                vendaUP = this.entityManager.merge(venda);
            }
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possível atualizar");
        }
        return vendaUP;
    }

    @Override
    public Venda delete(Long id) {
        try {
            vendaUP = entityManager.find(Venda.class, id);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(vendaUP);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possível remover" + e);
        }
        return vendaUP;
    }

    @Override
    public Venda findById(Long id) {
        try {
            vendaUP = entityManager.find(Venda.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar por id" + e);
        }
        return vendaUP;
    }

    public void close() {
        entityManager.close();
    }
}
