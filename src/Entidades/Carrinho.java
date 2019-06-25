package Entidades;
import java.util.ArrayList;

public class Carrinho {
	private ArrayList<Livro> livros;
	private double valorTotal;
	
	public Carrinho() {
		this.valorTotal = 0.00;
	}
	
	public void addValorTotal(double valor) {
		this.valorTotal += valor;
	}
	
	public void dcsValorTotal(double valor) {
		this.valorTotal -= valor;
	}
	
	public double getValorTotal() {
		return this.valorTotal;
	}
	
	public void addLivro(Livro l) {
		livros.add(l);
		this.addValorTotal(l.getPreco());
	}
	
	public void rmvLivro(Livro l) {
		livros.remove(l);
		this.dcsValorTotal(l.getPreco());
	}
	
	public void resetCarrinho() {
		this.valorTotal = 0.00;
		this.livros.clear();
	}
}
