package entities;


import javax.persistence.*;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Double precoTotal;
    
    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Vendedor vendedor;

    public Venda() {
    }

    public Venda(Double precoTotal) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedores) {
        this.vendedor = vendedores;
    }
}
