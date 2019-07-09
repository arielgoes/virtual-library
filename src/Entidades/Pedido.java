package Entidades;
import java.util.Date;

public class Pedido {
	private int numeroPedido;
	private String enderecoEntrega; //Classe 'Endereco'
	private Date dataPedido;
	private double valor;
	private Status status; //Classe 'Status'
	private Cliente cliente; //Classe 'Cliente'
	private LivroPedido livros;
	@SuppressWarnings("unused")
	private boolean finalizado;

	Pedido(int numeroPedido, Cliente cliente){
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.finalizado = false;
		this.livros = new LivroPedido();
	}
	
	
	//sets
	void setStatus(Status status) {
		this.status = status;
	}
	
	
	//gets
	int getNumeroPedido() {
		return this.numeroPedido;
	}
	
	String getEnderecoEntrega() {
		return this.enderecoEntrega;
	}
	
	Date getDataPedido() {
		return this.dataPedido;
	}
	
	double getValor() {
		return this.valor;
	}
	
	public Status getStatus() { //retorna o valor referente ao inteiro. Exemplo: SEGUNDA(1), Se '1', retorna 'SEGUNDA';
		return this.status;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public LivroPedido getLivroPedido() {
		return this.livros;
	}
	
	
	//funçoes
	
	public void finalizarPedido(String endereco) {
		this.dataPedido = new Date(System.currentTimeMillis());
		this.enderecoEntrega = endereco;
		this.finalizado = true;
		this.status = Status.AGUARDANDO_PAGAMENTO;
	}
	
	
	public int printStatusInteger() {
		return this.status.status;
	}
	
	public void atualizaValor() {
		double valor = 0.00;
		for(Livro l : livros.getLivros()) {
			valor += l.getPreco();
		}
		this.valor = valor;
	}
	
	
}
