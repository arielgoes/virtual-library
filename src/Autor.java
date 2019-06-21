import java.util.Date;
import java.util.ArrayList;

public class Autor {
	private String nomeAutor;
	private Date dataNascimento;
	private Date dataMorte;
	private String localNascimento;
	private String localMorte;
	private String bibliografia;
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public Autor(String nome, Date dataNascimento, Date dataMorte, String localNascimento, String localMorte, String bibliografia){
		this.nomeAutor = nome;
		this.dataNascimento = dataNascimento;
		this.dataMorte = dataMorte;
		this.localNascimento = localNascimento;
		this.localMorte = localMorte;
		this.bibliografia = bibliografia;
	}
	
	
	//sets
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}
	
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
	
	public void setLocalMorte(String localMorte) {
		this.setLocalMorte(localMorte);
	}
	
	public void setLivroAutor(Livro livro) {
		livros.add(livro);
	}
	
	
	//gets
	public String getnomeAutor() {
		return this.nomeAutor;
	}
	
	public Date getDataNascimento() {
		return this.dataNascimento;
	}
	
	public Date getDataMorte() {
		return this.dataMorte;
	}
	
	public String getLocalNascimento() {
		return this.localNascimento;
	}
	
	public String getLocalMorte() {
		return this.localMorte;
	}
	
	public String getBibliografia() {
		return this.bibliografia;
	}
	
	public boolean getLivroAutor(String titulo) throws NullPointerException{
		for(Livro l: livros) {
			if(l.getTitulo().equals(titulo)) {
				System.out.println("O livro " + titulo + "foi encontrado!");
				
				return true;
			}
		}
		
		System.out.println("O livro não foi encontrado!");
		return false;
	}
	
	
	//funcoes
	public void showAutor() {
		System.out.println("Nome: " + this.nomeAutor + ".");
		System.out.println("Data Nascimento: " + this.dataNascimento.toString() + ".");
		System.out.println("Local Nascimento: " + this.localNascimento + ".");
	}
	
	public void showLivros() throws NullPointerException{
		for(Livro l: this.livros) {
			System.out.println(l.getTitulo());
		}
	}

}
