package entities;


import javax.persistence.*;

@Entity
@Table(name = "clientes")
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		System.out.println("");
		return  "Código: " + this.ID.toString()+
				"\nNome: " + this.nome + 
				"\nCPF: "+ this.cpf +
				"\nEndereço: " + this.endereco +
				"\nTelefone: " + this.telefone;

	}
}
