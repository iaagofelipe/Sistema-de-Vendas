package entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Double precoTotal;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Vendedor vendedores;

    public Vendas() {
    }

    public Vendas(Double precoTotal) {
        this.precoTotal = precoTotal;
    }


    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getID() {
        return ID;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

}
