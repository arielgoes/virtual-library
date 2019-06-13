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
	private int estoque;
	
	public Livro(String isbn, String titulo, String resumo, String material, Date dataPub) {
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.resumo = resumo;
		this.material = material;
		this.dataPub = dataPub;
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
	}
	
	public void setDataPub(Date dataPub) {
		this.dataPub = dataPub;
	}
}
