package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;


    @OneToMany (cascade = CascadeType.ALL, mappedBy = "pedidos")
    private List<Produtos> produtosList;

    public Pedidos() {
    }

    public Long getID() {
        return ID;
    }

    public List<Produtos> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(List<Produtos> produtosList) {
        this.produtosList = produtosList;
    }
}
