import java.util.ArrayList;
import java.util.Date;

public class Livro {
	private String isbn;
	private String titulo;
	private String resumo;
	private String material;
	private double preco;
	private Date dataPub;
	private ArrayList<Autor> autores;
	private Categoria categoria;
	private Editora editora;

	//Dados de Conhecimento do Gerente do Sistema
	private double precoCusto;
	private double margemLucro;
	private int estoque = 0;
	//Fim dos Dados de Conhecimento do Gerente do Sistema
	
	public Livro(String isbn, String titulo, String resumo, String material, Date dataPub, double preco, double precoCusto, 
				Categoria cat, Editora editora) {
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.resumo = resumo;
		this.material = material;
		this.preco = preco;
		this.dataPub = dataPub;
		this.categoria = cat;
		this.autores = new ArrayList<Autor>();
		this.editora = editora;
		this.precoCusto = precoCusto;
		this.margemLucro = this.preco - this.precoCusto;
	}
	
	
	//sets
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
		this.margemLucro = this.preco - this.precoCusto;
	}
	
	public void setDataPub(Date dataPub) {
		this.dataPub = dataPub;
	}
	
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
		this.margemLucro = this.preco - this.precoCusto;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public boolean setAutor(ArrayList<Autor> autores, String nomeAutor) {
		for(Autor a: autores) {
			if(a.getnomeAutor().equals(nomeAutor)){
				this.autores.add(a);
				return true;
			}
		}
		return false;
	}
	
	
	//gets
	public String getIsbn() {
		return this.isbn;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getResumo() {
		return this.resumo;
	}
	
	public String getMaterial() {
		return this.material;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public Date dataPub() {
		return this.dataPub;
	}
	
	public double getPrecoCusto() {
		return this.precoCusto;
	}
	
	public double getMargemLucro() {
		return this.margemLucro;
	}
	
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	
	public Editora getEditora() {
		return this.editora;
	}
	
	public int getEstoque() {
		return this.estoque;
	}
	
	public String getNomeAutor(String nomeAutor) {
		for(Autor a:this.autores) {
			if(a.getnomeAutor().equals(nomeAutor)) {
				return nomeAutor;
			}
		}
		return null;
	}
	
	public void addEstoque(int quant) {
		this.estoque += quant;
	}
	
	public void retirarEstoque(int quant) {
		this.estoque += quant;
	}
	
	public void addAutorLivro(Autor a) {
		this.autores.add(a);
	}
	
	public boolean rmvAutorLivro(String nome) {
		for(Autor a: autores) {
			if(a.getnomeAutor().equals(nome)) {
				System.out.println("Removendo " + a.getnomeAutor() + " da lista de autores desse livro.");
				autores.remove(a);
				return true;
			}
		}
		System.out.println("Não foi possível encontrar o autor " + nome + ".");
		return false;
	}
	
	public void showAutores() {
		for(Autor a: autores) {
			a.showAutor();
		}
	}
	
	public void showLivro() {
		System.out.println("Titulo: " + this.titulo);
		System.out.println("ISBN: " + this.isbn);
		System.out.println("Material: " + this.material);
		System.out.println("Preco: " + this.preco);
	}
	
	
	int showCategoriaInteger() {
		return this.categoria.categoria;
	}
	
}
