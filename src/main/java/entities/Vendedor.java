package entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String nome;
    private String cpf;
    private String telefone;
    private Date dataNascimento;


    public Vendedor() {
    }

    public Vendedor(String nome, String cpf, String telefone, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Long getID() {
        return ID;
    }
}
