package entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private Double precoTotal;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)  
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)  
    private Vendedor vendedores;

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

	public Vendedor getVendedores() {
		return vendedores;
	}

	public void setVendedores(Vendedor vendedores) {
		this.vendedores = vendedores;
	}
    

}
