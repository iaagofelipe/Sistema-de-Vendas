package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexao.ConnectionFactory;
import entities.Venda;
import entities.VendasPedidos;

public class Vendas_PedidosDAO implements DAO<VendasPedidos>{
	private final EntityManager entityManager = new ConnectionFactory().getConnection();
	public VendasPedidos vendaPedidoUP;
	
	@Override
	public VendasPedidos save(VendasPedidos vendaPedido) {
		try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(vendaPedido);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.close();
            throw new RuntimeException("não foi possivel salvar" + e);
        }
        return vendaPedido;
	}

	@Override
	public List<VendasPedidos> getList() {
		Query query = this.entityManager.createQuery("SELECT vp FROM VendasPedidos as vp");
		return query.getResultList();
	}

	@Override
	public VendasPedidos update(VendasPedidos vendaPedido) {
		try {
			this.entityManager.getTransaction().begin();
			if (vendaPedido.getID() == null) {
				this.entityManager.persist(vendaPedido);
			} else {
				vendaPedidoUP = this.entityManager.merge(vendaPedido);
			}
			
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			this.entityManager.close();
			throw new RuntimeException("não foi possível atualizar" + e);
		}
		return vendaPedidoUP;
	}

	@Override
	public VendasPedidos delete(Long id) {
		try {
			vendaPedidoUP = entityManager.find(VendasPedidos.class, id);
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(vendaPedidoUP);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			this.entityManager.close();
			throw new RuntimeException("não foi possível remover" + e);
		}
		return vendaPedidoUP;
	}

	@Override
	public VendasPedidos findById(Long id) {
		try {
			vendaPedidoUP = entityManager.find(VendasPedidos.class, id);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar por id" + e);
		}
		return vendaPedidoUP;
	}
	
	public void close() {
        entityManager.close();
    }
	

}
