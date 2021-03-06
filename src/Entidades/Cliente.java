package Entidades;
import java.util.ArrayList;
import java.util.Scanner;

import Controladoras.MainControl;

public class Cliente {
	private String nome;
	private String idade;
	private String cpf;
	private String numeroTelefone;
	private String email;
	private String username;
	private String password;
	private ArrayList<String> enderecos;
	private ArrayList<Pedido> pedidos;
	
	public Cliente(String nome, String idade, String cpf, String email, String numeroTelefone, String username, String password) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.numeroTelefone = numeroTelefone;
		this.username = username;
		this.password = password;
		this.enderecos = new ArrayList<String>();
		this.pedidos = new ArrayList<Pedido>();
		this.pedidos.add(new Pedido(MainControl.numeroPedido++, this));
	}
	
	
	//sets
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//gets
	public String getNome() {
		return this.nome;
	}
	
	public String getIdade() {
		return this.idade;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getNumeroTelefone() {
		return this.numeroTelefone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	//funcoes
	public void addEndereco(String endereco) {
		enderecos.add(endereco);
	}
	
	public boolean delEnderecoCliente() {
		Scanner in = new Scanner(System.in);
		boolean executed = false;
		
		while(executed == false) {
			int id = 0;
			System.out.println("Exibindo endereços cadastrados...");
			for(String e: enderecos) {
				System.out.println("ID " + id + ": " + e);
			}
			System.out.println("Digite o ID do endereco a ser removido: ");
			System.out.println("Caso deseje sair, digite -1");
			int input = in.nextInt();
			in.hasNextLine();
			if(input == -1) {
				in.close();
				return false;
			}
			try {
				enderecos.remove(input);
				executed = true;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Opcao invalida. Tente novamente...");
				continue;
			}
		}
		in.close();
		return true;
	}
	
	public String newEndereco() {
		Scanner in = new Scanner(System.in);
		System.out.println("Digite a rua:");
		String rua = in.nextLine();
		System.out.println("Digite o numero:");
		String numero = in.nextLine();
		System.out.println("Digite o complemento:");
		String complemento = in.nextLine();
		System.out.println("Digite o bairro:");
		String bairro = in.nextLine();
		System.out.println("Digite a cidade:");
		String cidade = in.nextLine();
		System.out.println("Digite o cep:");
		String cep = in.nextLine();
		System.out.println("Digite o estado:");
		String estado = in.nextLine();
		System.out.println("Digite o país:");
		String pais = in.nextLine();
		String e = rua + ", " + numero + ", " + complemento + ", " + bairro + ", " + cidade + ", " + cep + ", " + estado + ", " + pais;
		this.addEndereco(e);
		in.close();
		return e;
	}
	
	public Pedido getCarrinho() {
		return pedidos.get(pedidos.size() - 1);
	}
	
}
