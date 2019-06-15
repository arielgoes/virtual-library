import java.util.Date;

public class Livro {
	private String isbn;
	private String titulo;
	private String resumo;
	private String material;
	private double preco;
	private Date dataPub;
	private double precoCusto;
	private double margemLucro;
	private int estoque = 0;
	
	public Livro(String isbn, String titulo, String resumo, String material, Date dataPub, double preco, double precoCusto) {
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.resumo = resumo;
		this.material = material;
		this.preco = preco;
		this.dataPub = dataPub;
		this.precoCusto = precoCusto;
		this.margemLucro = this.preco - this.precoCusto;
		
	}
	
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
	
}
