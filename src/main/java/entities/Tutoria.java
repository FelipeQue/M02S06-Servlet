package entities;

import java.util.List;

public class Tutoria {

	private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private List<Pet> pets;
    
    public Tutoria() {
    	
    }
    
	public Tutoria(String nome, String endereco, String telefone, String email) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "*TUTORE* Id: " + id + ", Nome: " + nome + ", Endereço: " + endereco + ", Telefone: " + telefone + ", E-mail: "
				+ email + ", Pets: " + pets + ".";
	}
    
	
    
	
	
}
