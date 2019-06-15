
public class Editora {
	private String nome;
	private Endereco endereco;
	private String telefone;
	private String cnpj;
	
	
	public Editora(String nome, Endereco endereco, String telefone, String cnpj){
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cnpj = cnpj;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}
	
}
