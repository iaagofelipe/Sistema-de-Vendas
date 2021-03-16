package entities;


import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Long getID() {
        return ID;
    }
}
