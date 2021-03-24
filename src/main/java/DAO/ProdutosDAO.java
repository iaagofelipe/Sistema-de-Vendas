package DAO;

import conexao.ConnectionFactory;
import entities.Produtos;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProdutosDAO implements DAO<Produtos>{

    private final EntityManager entityManager = new ConnectionFactory().getConnection();
    public Produtos produtosUP;

    @Override
    public Produtos save(Produtos produtos) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(produtos);
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possivel salvar" + e);
        }
        return produtos;
    }

    @Override
    public List<Produtos> getList() {
        Query query = this.entityManager.createQuery("SELECT p FROM Produtos as p");
        return query.getResultList();
    }

    @Override
    public Produtos update(Produtos produtos) {
        try {
            this.entityManager.getTransaction().begin();
            if (produtos.getID() == null) {
                this.entityManager.persist(produtos);
            } else {
                produtosUP = this.entityManager.merge(produtos);
            }
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possível atualizar" + e);
        }
        return produtosUP;
    }

    @Override
    public Produtos delete(Long ID) {
        try {
            produtosUP = entityManager.find(Produtos.class, ID);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(produtosUP);
            this.entityManager.getTransaction().commit();
            this.entityManager.close();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possível remover" + e);
        }
        return produtosUP;
    }

    @Override
    public Produtos findById(Long ID) {
        try {
            produtosUP = entityManager.find(Produtos.class, ID);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar por id" + e);
        }
        return produtosUP;
    }
}
