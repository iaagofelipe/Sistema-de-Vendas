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

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "vendas")
    private List<Cliente> clienteList;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "vendas")
    private List<Vendedor> vendedorList;


    public Vendas() {
    }

    public Vendas(Double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
