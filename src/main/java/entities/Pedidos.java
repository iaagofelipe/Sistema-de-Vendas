package entities;

import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	private int quantidade;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Produtos produtos;
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setID(Long iD) {
		ID = iD;
	}

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
