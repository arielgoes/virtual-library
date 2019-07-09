package Entidades;

import java.util.ArrayList;

public class LivroPedido {
	private ArrayList<Livro> livros;
	
	public LivroPedido() {
		this.livros = new ArrayList<Livro>();
	}

	public void addLivro(Livro livro, int quant) {
		for (int i = 0; i < quant; i++) {
			livros.add(livro);
		}
	}
	
	public ArrayList<Livro> getLivros() {
		return this.livros;
	}
	
	
}
