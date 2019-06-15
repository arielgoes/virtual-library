
public class Cliente {
	private String nome;
	private String idade;
	private String cpf;
	private String numeroTelefone;
	private String email;
	private String username;
	private String password;
	
	
	public Cliente(String nome, String idade, String cpf, String email, String numeroTelefone) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.numeroTelefone = numeroTelefone;
	}
	
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
	
}
