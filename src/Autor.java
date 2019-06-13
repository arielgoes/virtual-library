import java.util.Date;

public class Autor {
	private String nomeAutor;
	private Date dataNascimento;
	private Date dataMorte;
	private String localNascimento;
	private String localMorte;
	private String bibliografia;
	
	public Autor(String nome, Date dataNascimento, String localNascimento, String bibliografia){
		this.nomeAutor = nome;
		this.dataNascimento = dataNascimento;
		this.localNascimento = localNascimento;
		this.bibliografia = bibliografia;
	}
	
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
}
