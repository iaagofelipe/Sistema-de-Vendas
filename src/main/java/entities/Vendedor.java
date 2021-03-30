package entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vendedores")
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

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
	public String toString() {
		System.out.println("");
		return  "Código: " + this.ID.toString()+
				"\nNome: " + this.nome + 
				"\nCPF: "+ this.cpf +
				"\nData de Nascimento: " + this.dataNascimento +
				"\nTelefone: " + this.telefone;

	}
}
