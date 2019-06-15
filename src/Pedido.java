import java.util.Date;
import java.util.ArrayList;

public class Pedido {
	private String numeroPedido;
	private Endereco enderecoEntrega; //Classe 'Endereco'
	private Date dataPedido;
	private double valor;
	private Status status; //Classe 'Status'
	private Cliente cliente; //Classe 'Cliente'
	private ArrayList<Livro> livros;
	
	
	Pedido(String numeroPedido, Endereco enderecoEntrega, Date dataPedido, double valor){
		this.numeroPedido = numeroPedido;
		this.enderecoEntrega = enderecoEntrega;
		this.dataPedido = dataPedido;
		this.valor = valor;
		this.livros = new ArrayList<Livro>();
	}
	
	
	//sets
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
	
	void setStatus(Status status) {
		this.status = status;
	}
	
	void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	//gets
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
	
	Status getStatus() {
		return this.status;
	}
	
	Cliente getCliente() {
		return this.cliente;
	}
	
	
	//funçoes
	void addLivroPedido(Livro livro) {
		this.livros.add(livro);
	}
	
	
	boolean delLivroPedido(String nomeLivro) {
		for(Livro l: livros) {
			if(l.getTitulo().equals(nomeLivro)) {
				System.out.println("O livro " + nomeLivro + "foi excluído!");
				livros.remove(l);
				return true;
			}
		}
		
		System.out.println("O livro não foi encontrado e não pode ser removido!");
		return false;
	}
}
