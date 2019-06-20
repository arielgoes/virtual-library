import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JFrame;

public class LivrariaVirtual extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int numeroPedido = 0;
	
	private static ArrayList<Editora> editoras = new ArrayList<Editora>();
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private static ArrayList<Autor> autores = new ArrayList<Autor>();
	private static ArrayList<Livro> livros = new ArrayList<Livro>();
	public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private static Hashtable<String, String> users = new Hashtable<String, String>();
	
	
	public static Cliente cliente_atual;
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		boolean running = false;
		boolean logged = false;
		
		
		while(running == false) {
			
			while(!logged) {
				System.out.println("Selecione a opção:\n1 - Realizar Login\n2 - Realizar Cadastro");
				int op = 0;
				if(in.hasNextLine()) {
					op = in.nextInt();
					in.nextLine();
				}
				
				if(op == 1) {
					if(realizarLogin()) {
						logged = true;
					}
				}else if(op == 2) {
					realizarCadastro();
				}else {
					System.out.println("Digite uma opção válida.");
					logged = false;
				}
			}
			
			System.out.println("Selecione uma das Opções:\n1 - ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			running = true;
		}
		in.close();
	}
	
	
	public static boolean realizarLogin() {
		boolean logged = false;
		
		while(logged == false) {
			System.out.println("Digite 0 para sair, ou 1 para continuar: ");
			int op = in.nextInt();
			in.nextLine();
			
			if(op == 1) {
				System.out.println("Digite o login:");
				String login = in.nextLine();
				System.out.println("Digite a senha:");
				String senha = in.nextLine();
				if(users.containsKey(login)) {
					if(users.contains(senha)) {
						for(Cliente c: clientes) {
							if(c.getUsername().equals(login) && c.getPassword().equals(senha)) {
								System.out.println("Logado com sucesso como " + c.getNome() + ".");
							}
							cliente_atual = c;
							logged = true;
						}
					}
				}else {
					System.out.println("Não foi possível realizar o login, usuário e/ou senha incorretos. Tenta Novamente.");
				}
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static void realizarCadastro() {
		System.out.println("Digite seu nome: ");
		String nome = in.nextLine();
		System.out.println("Digite sua idade: ");
		String idade = in.nextLine();
		System.out.println("Digite seu CPF: ");
		String cpf = in.nextLine();
		System.out.println("Digite seu email: ");
		String email = in.nextLine();
		System.out.println("Digite seu número de telefone: ");
		String numeroTelefone = in.nextLine();
		
		Cliente c = new Cliente(nome, idade, cpf, email, numeroTelefone);
		
		System.out.println("Digite seu Login: ");
		String login = in.nextLine();
		System.out.println("Digite sua Senha: ");
		String senha = in.nextLine();
		
		c.setUsername(login);
		c.setPassword(senha);
		
		clientes.add(c);
		users.put(c.getUsername(), c.getPassword());
	}
	
	
	public static void loadEditoras() throws FileNotFoundException{
		String pathEditoras = "/home/ariel/git/livraria-virtual/scriptsPython/editoras.txt";
		File file = new File(pathEditoras); 
		BufferedReader br = new BufferedReader(new FileReader(pathEditoras));
		
		try {
			String st;
			while( (st = br.readLine()) != null) {
				
				String[] split = st.split(";");
				String nome = split[0];
				Endereco endereco = split[1];
				String telefone = split[2];
				String cnpj = split[3];
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public static void loadLivros() throws FileNotFoundException {
		String pathLivros = "/home/ariel/git/livraria-virtual/scriptsPython";
		File file = new File(pathLivros); 
		BufferedReader br = new BufferedReader(new FileReader(pathLivros));
	}*/
	
	
	
}
