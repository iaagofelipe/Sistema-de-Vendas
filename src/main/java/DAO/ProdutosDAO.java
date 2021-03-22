package DAO;

import conexao.ConnectionFactory;
import entities.Produtos;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProdutosDAO implements DAO<Produtos>{

    private final EntityManager entityManager = new ConnectionFactory().getConnection();

    @Override
    public Produtos save(Produtos produtos) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(produtos);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return produtos;
    }

    @Override
    public List<Produtos> getList() {
        Query query = this.entityManager.createQuery("SELECT * FROM produtos");
        return query.getResultList();
    }

    @Override
    public Produtos update(Produtos produtos) {
        Produtos produtosUp = null;
        try {
            this.entityManager.getTransaction().begin();
            if (produtos.getID() == null) {
                this.entityManager.persist(produtos);
            } else {
                produtosUp = this.entityManager.merge(produtos);
            }
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return produtosUp;
    }

    @Override
    public Produtos delete(Long ID) {
        Produtos produtos = null;
        try {
            produtos = entityManager.find(Produtos.class, ID);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(produtos);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return produtos;
    }

    @Override
    public Produtos findById(Long ID) {
        Produtos produtos = null;
        try {
            produtos = entityManager.find(Produtos.class, ID);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar por id" + e);
        }
        return produtos;
    }
}
