import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String idade;
	private String cpf;
	private String numeroTelefone;
	private String email;
	private String username;
	private String password;
	private ArrayList<Endereco> enderecos;
	private int countEnderecos;
	
	
	public Cliente(String nome, String idade, String cpf, String email, String numeroTelefone) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.numeroTelefone = numeroTelefone;
		this.countEnderecos = 0;
	}
	
	
	//sets
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//gets
	public String getNome() {
		return this.nome;
	}
	
	public String getIdade() {
		return this.idade;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getNumeroTelefone() {
		return this.numeroTelefone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	//funcoes
	public void addEndereco(Endereco endereco) {
		enderecos.add(endereco);
		++this.countEnderecos;
	}
	
	void updateEnderecoID() {
		for(int i = countEnderecos - 1; i >= 0; i--) {
			if(enderecos.get(i).getEnderecoID() != i) {
				enderecos.get(i).setEnderecoID(i);
			}
		}
	}
	
	boolean delEnderecoCliente(int enderecoID) {
		
		if(enderecoID >= this.countEnderecos) {
			System.out.println("ERRO: Digite um ID de endereco válido!");
			return false;
		}
		for(Endereco e: enderecos) {
			if(e.getEnderecoID() == enderecoID) {
				System.out.println("O endereço com ID: " + enderecoID + "foi excluído!");
				enderecos.remove(e);
				return true;
			}
		}
		
		System.out.println("O endereço não foi encontrado e não pode ser removido!");
		return false;
	}
	
}
