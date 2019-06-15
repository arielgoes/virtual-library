import java.util.ArrayList;
public class Endereco {
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private String estado;
	private String pais;
	private ArrayList<Pedido> pedidos;
	private int countPedidos;
	private Cliente cliente;
	
	public Endereco(Cliente cliente, String rua, String numero, String complemento, String bairro, 
			String cidade, String cep, String estado, String pais) {
		
		this.cliente = cliente;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.pais = pais;
		this.countPedidos = 0;
	}
	
	
	//sets
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
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
	public boolean getCliente(Cliente cliente) {
		if(cliente.equals(this.cliente)) {
			return true;
		}
		
		return false;
	}
	
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
	
	public String getpais() {
		return this.pais;
	}
	
	public boolean getPedido(String numeroPedido) {
		for(Pedido p: pedidos) {
			if(p.getNumeroPedido().equals(numeroPedido)){
				System.out.println("Pedido " + p.getNumeroPedido() + " foi encontrado!");
				return true;
			}
		}
		
		return false;
	}
	
	//funcoes
	public void addPedido(Pedido pedido) {
		pedidos.add(pedido);
		++this.countPedidos;
	}
	
}
