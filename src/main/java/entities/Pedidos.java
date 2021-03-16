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
}
