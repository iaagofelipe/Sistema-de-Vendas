package entities;



import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String nomeProduto;
    private String descricaoProduto;
    private Double preco;

    public Produtos(String nomeProduto, String descricaoProduto, Double preco) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
    }

    public Produtos() {
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

//    public Pedidos getPedidos() {
//        return pedidos;
//    }
//
//    public void setPedidos(Pedidos pedidos) {
//        this.pedidos = pedidos;
//    }

    public Long getID() {
        return ID;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}

