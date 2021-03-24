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

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "vendas", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "vendas", fetch = FetchType.LAZY)
    private List<Vendedor> vendedorList;


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

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public List<Vendedor> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<Vendedor> vendedorList) {
        this.vendedorList = vendedorList;
    }
}
