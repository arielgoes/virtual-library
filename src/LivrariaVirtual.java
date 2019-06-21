import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	public static void main(String args[]) throws FileNotFoundException, ParseException {
		
		//load Editoras
		loadEditoras(editoras);
		System.out.println(editoras.get(2).getNome());
		
		//test autores
		loadAutores(autores);
		
		/*for(Autor a: autores) {
			a.showAutor();
		}*/
		
		loadLivros(livros, editoras);
		System.out.println(livros.get(49).getIsbn());
		
		//adicionando os livros em autores...
		addLivrosToAutores(livros, autores);
		
		/*for(int i = 0; i < autores.size(); i++) {
			autores.get(i).showLivros();
		}*/
		
		
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
	
	
	public static void loadEditoras(ArrayList<Editora> editoraArray) throws FileNotFoundException{
		ArrayList<Endereco> enderecoEditora = new ArrayList<Endereco>();
		String pathEditoras = "/home/ariel/git/livraria-virtual/scriptsPython/editoras.txt";
		BufferedReader br = new BufferedReader(new FileReader(pathEditoras));
		
		String pathEnderecos = "/home/ariel/git/livraria-virtual/scriptsPython/enderecosEditoras.txt";
		BufferedReader br2 = new BufferedReader(new FileReader(pathEnderecos));
		
		//ler enderecos das editoras
		try {
			String st2;
			while((st2 = br2.readLine()) != null) {
				String[] split2 = st2.split(";");
				String rua = split2[0];
				String numero = split2[1];
				String complemento = split2[2];
				String bairro = split2[3];
				String cidade = split2[4];
				String cep = split2[5];
				String estado = split2[6];
				String pais = split2[7];
				
				Endereco enderecoEd = new Endereco(rua, numero, complemento, bairro, cidade, cep, estado, pais);
				enderecoEditora.add(enderecoEd);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		//ler editoras
		int i = 0;
		try {
			String st;
			while((st = br.readLine()) != null) {
				
				String[] split = st.split(";");
				String nome = split[0];
				Endereco endereco = enderecoEditora.get(i);
				String telefone = split[2];
				String cnpj = split[3];
				i++;
				
				Editora editora = new Editora(nome, endereco, telefone, cnpj);
				editoraArray.add(editora);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void loadAutores(ArrayList<Autor> autores) throws FileNotFoundException, ParseException{
		String pathAutores = "/home/ariel/git/livraria-virtual/scriptsPython/autores.txt";
		BufferedReader br = new BufferedReader(new FileReader(pathAutores));
		
		try {
			String st;
			String nomesAutores = null;
			while((st = br.readLine()) != null) {
				
				String[] split = st.split(";");
				String nomeAutor = split[0];
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(split[1]);
				Date dataNascimento = date;
				date = new SimpleDateFormat("dd/MM/yyyy").parse(split[2]);
				Date dataMorte = date;
				String localNascimento = split[3];
				String localMorte = split[4];
				String bibliografia = split[5];
				
				if(nomeAutor.equals(nomesAutores)) {
					continue;
				}
				
				Autor autor = new Autor(nomeAutor, dataNascimento, dataMorte, localNascimento, localMorte, bibliografia);
				autores.add(autor);
				nomesAutores = nomeAutor;
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Categoria fromString(String text) {
        for (Categoria c : Categoria.values()) {
            if (c.equals(text)) {
                return c;
            }
        }
        return null;
    }
	
	
	public static void loadLivros(ArrayList<Livro> livros, ArrayList<Editora> editoras) throws FileNotFoundException, ParseException {
		String pathLivros = "/home/ariel/git/livraria-virtual/scriptsPython/livros.txt"; 
		BufferedReader br = new BufferedReader(new FileReader(pathLivros));
		
		try {
			String st;
			while((st = br.readLine()) != null) { //CORRIGIR...
				String split[] = st.split(";");
				String isbn = split[0];
				String titulo = split[1];
				String resumo = split[2];
				String material = split[3];
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(split[4]);
				Date dataPub = date;
				double preco = Double.parseDouble(split[5]);
				double precoCusto = Double.parseDouble(split[6]);
				
				Categoria categoria = fromString(split[7]);
				
				int i = 0;
				for(Editora e: editoras) {
					if(split[8].equals(e.getNome())) {
						break;
					}
					i++;
				}
				
				Livro livro = new Livro(isbn, titulo, resumo, material, dataPub, preco, precoCusto, categoria, editoras.get(i));
				livros.add(livro);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void addLivrosToAutores(ArrayList<Livro> livros, ArrayList<Autor> autores) {
		
		for(Autor a: autores) {
			for(Livro l: livros) {
				if(a.getnomeAutor().equals(l.getNomeAutor(a.getnomeAutor()))) {
					a.setLivroAutor(l);
				}
			}
		}
		
		
		
	}
	
	
}
