package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import conexao.ConnectionFactory;
import entities.Produtos;
import entities.Venda;
import entities.Vendedor;

public class VendasDAO implements DAO<Venda>{
	private final EntityManager entityManager = new ConnectionFactory().getConnection();
	public Venda vendaUP;

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
			throw new RuntimeException("não foi possível atualizar" + e);
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
