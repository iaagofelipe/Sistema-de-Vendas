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
}

