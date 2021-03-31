package DAO;

import conexao.ConnectionFactory;
import entities.Pedidos;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PedidoDAO implements DAO<Pedidos> {
	private final EntityManager entityManager = new ConnectionFactory().getConnection();
	public Pedidos pedidoUP = null;
	
	@Override
	public Pedidos save(Pedidos pedido) {
		  try {
	            this.entityManager.getTransaction().begin();
	            this.entityManager.persist(pedido);
	            this.entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            this.entityManager.getTransaction().rollback();
	            this.entityManager.close();
	            throw new RuntimeException("não foi possivel salvar" + e);
	        }
	        return pedido;
	}

	@Override
	public List<Pedidos> getList() {
		 Query query = this.entityManager.createQuery("SELECT p FROM Pedidos as p");
	     return query.getResultList();
	}

	@Override
	public Pedidos update(Pedidos pedido) {
		 try {
	            this.entityManager.getTransaction().begin();
	            if (pedido.getID() == null) {
	                this.entityManager.persist(pedido);
	            } else {
	            	pedidoUP = this.entityManager.merge(pedido);
	            }
	            this.entityManager.getTransaction().commit();
	        } catch (Exception e) {
	            this.entityManager.getTransaction().rollback();
	            this.entityManager.close();
	            throw new RuntimeException("não foi possível atualizar");
	        }
	        return pedidoUP;
	}

	@Override
	public Pedidos delete(Long id) {
		try {
			pedidoUP = entityManager.find(Pedidos.class, id);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(pedidoUP);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possível remover" + e);
        }
        return pedidoUP;
	}

	@Override
	public Pedidos findById(Long id) {
		try {
			pedidoUP = entityManager.find(Pedidos.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar por id" + e);
        }
        return pedidoUP;
	}

	public void close() {
		entityManager.close();
	}

}
