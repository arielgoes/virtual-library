import java.util.Date;

public class Pedido {
	private String numeroPedido;
	private Endereco enderecoEntrega;
	private Date dataPedido;
	private double valor;
	
	Pedido(String numeroPedido, Endereco enderecoEntrega, Date dataPedido, double valor){
		this.numeroPedido = numeroPedido;
		this.enderecoEntrega = enderecoEntrega;
		this.dataPedido = dataPedido;
		this.valor = valor;
	}
	
	void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
	void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	void setValor(double valor) {
		this.valor = valor;
	}
	
	String getNumeroPedido() {
		return this.numeroPedido;
	}
	
	Endereco getEnderecoEntrega() {
		return this.enderecoEntrega;
	}
	
	Date getDataPedido() {
		return this.dataPedido;
	}
	
	double getValor() {
		return this.valor;
	}
	
}
