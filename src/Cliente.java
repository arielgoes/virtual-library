import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cliente {
	private String nome;
	private String idade;
	private String cpf;
	private String numeroTelefone;
	private String email;
	private String username;
	private String password;
	private ArrayList<Endereco> enderecos;
	private ArrayList<Pedido> pedidos;
	private Carrinho carrinho;
	
	public Cliente(String nome, String idade, String cpf, String email, String numeroTelefone) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.numeroTelefone = numeroTelefone;
		this.carrinho = new Carrinho();
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
	public void addEndereco(Endereco endereco) {
		enderecos.add(endereco);
	}
	
	public boolean delEnderecoCliente() {
		Scanner in = new Scanner(System.in);
		boolean executed = false;
		
		while(executed == false) {
			int id = 0;
			System.out.println("Exibindo endereços cadastrados...");
			for(Endereco e: enderecos) {
				System.out.println("ID " + id + ": ");
				e.showEndereco();
				System.out.println("\n");
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
	
	public void addPedido() {
		Scanner in = new Scanner(System.in);
		Endereco endereco;
		if(this.pedidos.size() == 1) {
			System.out.println("Deseja utilzar este endereço para entrega?\n 1- Sim\n2- Não");
			this.enderecos.get(0).showEndereco();
			int choice = in.nextInt();
			in.hasNextLine();
			if(choice == 1) {
				endereco = this.enderecos.get(0);
			}else {
				endereco = this.newEndereco();
			}
		}
		else {
			int id = 0;
			System.out.println("Digite o ID do endereço escolhido:");
			for(Endereco e: enderecos) {
				System.out.print("ID : " + id + ".");
				e.showEndereco();
				System.out.println();
			}
			int choice = in.nextInt();
			in.nextLine();
			endereco = enderecos.get(choice);
		}
		Date data = new Date(System.currentTimeMillis());
		Status status = Status.AGUARDANDO_PAGAMENTO;
		Pedido p = new Pedido(++LivrariaVirtual.numeroPedido, endereco, data, this.carrinho.getValorTotal(), status, this);
		this.carrinho.resetCarrinho();
	}
	
	public Endereco newEndereco() {
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
		Endereco e = new Endereco(rua, numero, complemento, bairro, cidade, cep, estado, pais);
		this.addEndereco(e);
		return e;
	}
	
}
