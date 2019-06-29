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
	private ArrayList<LivroPedido> livros;
	@SuppressWarnings("unused")
	private boolean finalizado;

	
	
	Pedido(int numeroPedido, Cliente cliente){
		this.numeroPedido = numeroPedido;
		this.livros = new ArrayList<LivroPedido>();
		this.cliente = cliente;
		this.finalizado = false;
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
	public void addLivroPedido(LivroPedido livro) {
		this.livros.add(livro);
	}
	
	public void finalizarPedido(Endereco endereco) {
		this.dataPedido = new Date(System.currentTimeMillis());
		this.enderecoEntrega = endereco;
		this.finalizado = true;
		this.status = Status.AGUARDANDO_PAGAMENTO;
	}
	
	
	public boolean delLivroPedido(String nomeLivro) {
		for(LivroPedido l: livros) {
			if(l.getLivro().getTitulo().equals(nomeLivro)) {
				System.out.println("O livro " + nomeLivro + "foi excluído!");
				livros.remove(l);
				return true;
			}
		}
		
		System.out.println("O livro não foi encontrado e não pode ser removido!");
		return false;
	}
	
	public int printStatusInteger() {
		return this.status.status;
	}
	
	public void atualizaValor() {
		double atual = 0.0;
		
		for(LivroPedido l: livros) {
			atual += l.getValorTotal();
		}
		
		this.valor = atual;
	}
	
}
