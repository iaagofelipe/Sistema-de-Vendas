package entities;

import javax.persistence.Entity;
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
    
    @ManyToOne
    private Venda venda;
    
    @ManyToOne
    private Pedidos pedidos;

    public Long getID() {
        return ID;
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
}
