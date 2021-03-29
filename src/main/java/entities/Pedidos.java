package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	private Integer quantidade;

	@ManyToOne
	private Produtos produtos;

	//    @OneToMany (cascade = CascadeType.ALL, mappedBy = "pedidos")
	//    private List<Produtos> produtosList;

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

	public void setID(Long ID) {
		this.ID = ID;
	}

//	public List<Produtos> getProdutosList() {
//		return produtosList;
//	}
//
//	public void setProdutosList(List<Produtos> produtosList) {
//		this.produtosList = produtosList;
//	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
