package Entidades;

public class LivroPedido {
	private Livro livro;
	private int quant;
	private double valorTotal;
	
	public LivroPedido(Livro livro, int quant) {
		this.livro = livro;
		this.quant = quant;
		this.valorTotal = livro.getPreco() * quant;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
