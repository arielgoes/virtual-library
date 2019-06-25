package Entidades;
import java.util.Date;
import java.util.ArrayList;

public class Pedido {
	private int numeroPedido;
	private Endereco enderecoEntrega; //Classe 'Endereco'
	private Date dataPedido;
	private double valor;
	private Status status; //Classe 'Status'
	private Cliente cliente; //Classe 'Cliente'
	private ArrayList<Livro> livros;

	
	
	Pedido(int numeroPedido, Endereco enderecoEntrega, Date dataPedido, double valor, Status status, Cliente cliente){
		this.numeroPedido = numeroPedido;
		this.enderecoEntrega = enderecoEntrega;
		this.dataPedido = dataPedido;
		this.valor = valor;
		this.livros = new ArrayList<Livro>();
		this.status = status;
		this.cliente = cliente;
	}
	
	
	//sets
	void setStatus(Status status) {
		this.status = status;
	}
	
	
	//gets
	int getNumeroPedido() {
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
	
	Status getStatus() { //retorna o valor referente ao inteiro. Exemplo: SEGUNDA(1), Se '1', retorna 'SEGUNDA';
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
	
	int printStatusInteger() {
		return this.status.status;
	}
	
}
