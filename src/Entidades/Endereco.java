package Entidades;
public class Endereco {
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private String estado;
	private String pais;
	
	public Endereco(String rua, String numero, String complemento, String bairro, 
			String cidade, String cep, String estado, String pais) {
		

		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.pais = pais;
	}
	
	
	//sets
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	//gets
	
	public String getRua() {
		return this.rua;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public String getComplemento() {
		return this.complemento;
	}
	
	public String getBairro() {
		return this.bairro;
	}
	
	public String getCidade() {
		return this.cidade;
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	
	public void showEndereco() {
		System.out.println("Rua: " + this.rua);
		System.out.println("Numero: " + this.numero);
		System.out.println("Bairro: " + this.bairro);
		System.out.println("Cidade: " + this.cidade);
	}
	
}