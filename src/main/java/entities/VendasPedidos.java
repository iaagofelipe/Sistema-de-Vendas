package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendas_pedidos")
public class VendasPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    
    @ManyToOne(cascade = {CascadeType.MERGE}, fetch= FetchType.LAZY)
    private Venda venda;
    
    @ManyToOne(cascade = {CascadeType.MERGE },fetch= FetchType.LAZY)
    private Pedidos pedidos;

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
		ID = iD;
	}

	public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
    
    @Override
    public String toString() {
    	return "\nCódigo: "+ this.getID() +
    			"\nCódigo do Produto:" + this.getPedidos().getProdutos().getID()+
    			"\n Nome Produto: " + this.getPedidos().getProdutos().getNomeProduto()+
    			"\n Vendedor:" + this.getVenda().getVendedores().getNome()+
    			"\n Cliente: " + this.getVenda().getCliente().getNome()+
    			"\n Preço total: " + this.getVenda().getPrecoTotal();
    }
}
