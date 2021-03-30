package entities;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;

	@ManyToOne
	private Produtos produtos;

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public Pedidos() {
	}

	public Long getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "Pedidos: " +
				"\nCódigo do pedido: " + ID.toString() +
				"\nNome do pedido: " + produtos.getNomeProduto();
	}
}
