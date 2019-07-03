package Controladoras;

import Entidades.Editora;
import Entidades.Cliente;
import Entidades.Autor;
import Entidades.Livro;
import Entidades.Pedido;
import Entidades.Endereco;
import Entidades.Categoria;

import Interfaces.iLogin;
import Interfaces.iBusca;
import Interfaces.iMessage;
import Interfaces.iTable;
import Interfaces.iRegistro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Controladora {
	
	public ArrayList<Editora> editoras;
	public ArrayList<Cliente> clientes;
	public ArrayList<Autor> autores;
	public ArrayList<Livro> livros;
	public ArrayList<Pedido> pedidos;
	public Hashtable<String, String> users;
	public static Cliente cliente_atual;
	public Scanner in = new Scanner(System.in);
	
	public ArrayList<Livro> buscados = null;
	
	public Controladora() {
		editoras = new ArrayList<Editora>();
		clientes = new ArrayList<Cliente>();
		autores = new ArrayList<Autor>();
		livros = new ArrayList<Livro>();
		pedidos = new ArrayList<Pedido>();
		users = new Hashtable<String, String>();
	}
	
	
	public void loadEditoras() throws FileNotFoundException{
		ArrayList<Endereco> enderecoEditora = new ArrayList<Endereco>();
		String pathEditoras = Controladora.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/Paths/editoras.txt";
		String DpathEditoras = null;
		try {
			DpathEditoras = URLDecoder.decode(pathEditoras, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			new iMessage("Erro!");
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new FileReader(DpathEditoras));
		
		
		String pathEnderecos = Controladora.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/Paths/enderecosEditoras.txt";
		String DpathEnderecos = null;
		try {
			DpathEnderecos = URLDecoder.decode(pathEnderecos, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			new iMessage("Erro!");
			e1.printStackTrace();
		}
		BufferedReader br2 = new BufferedReader(new FileReader(DpathEnderecos));
		
		
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
				this.editoras.add(editora);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void loadAutores() throws FileNotFoundException, ParseException{
		String pathAutores = Controladora.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/Paths/autores.txt";
		String DpathAutores = null;
		try {
			DpathAutores = URLDecoder.decode(pathAutores, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			new iMessage("Erro!");
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new FileReader(DpathAutores));
		
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
	
	
	public void loadLivros() throws FileNotFoundException, ParseException {
		String pathLivros = Controladora.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/Paths/livros.txt";
		String DpathLivros = null;
		try {
			DpathLivros = URLDecoder.decode(pathLivros, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			new iMessage("Erro!");
			e1.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(new FileReader(DpathLivros));
		
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
				Categoria categoria = new Categoria(split[7]);
				
				int i = 0;
				for(Editora e: editoras) {
					if(split[8].equals(e.getNome())) {
						break;
					}
					i++;
				}
				
				
				Livro livro = new Livro(isbn, titulo, resumo, material, dataPub, preco, precoCusto, categoria, editoras.get(i));
				String nomeAutor = split[9];
				livro.setAutor(this.getAutores(), nomeAutor);
				livros.add(livro);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addLivrosToAutores() {
		
		for(Autor a: autores) {
			for(Livro l: livros) {
				if(a.getnomeAutor().equals(l.getNomeAutor(a.getnomeAutor()))) {
					a.setLivroAutor(l);
				}
			}
		}
	}
	
	public ArrayList<Autor> getAutores(){
		return this.autores;
	}
	
	
	
	
	public void realizarLogin() {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				iLogin login = new iLogin();
				
				login.loginButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						final String username = login.getUsernameField();
						final String password = login.getPasswordField();
						if(users.containsKey(username)) {
							if(users.get(username).contentEquals(password)) {
								for(Cliente c: clientes) {
									if(c.getUsername().equals(username) && c.getPassword().equals(password)) {
										new iMessage("Logado com sucesso como " + c.getNome() + ".");
										cliente_atual = c;
										login.setVisible(false);
										login.dispose();
									}
								}
							}else {
								new iMessage("Nome de usuário ou senha incorretos.");
							}
						}else {
							new iMessage("Nome de usuário ou senha incorretos.");
						}
					}
					
				});
				
				login.registerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							realizarCadastro();
					}
					
				});
			}
			
		});
	}
	
	public void realizarCadastro() {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				iRegistro registro = new iRegistro();
				registro.OkButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nome = registro.nameField.getText();
						String idade = registro.idadeField.getText();
						String cpf = registro.cpfField.getText();
						String email = registro.emailField.getText();
						String telefone = registro.telefoneField.getText();
						String username = registro.usernameField.getText();
						String password = registro.passwordField.getText();
						
						Cliente c = new Cliente(nome, idade, cpf, email, telefone, username, password);
						clientes.add(c);
						users.put(username, password);
						
						new iMessage("Registro Bem Sucedido");
						
						registro.setVisible(false);
						registro.dispose();	
					}
				});
				
				registro.CancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						registro.setVisible(false);
						registro.dispose();
					}		
				});
			}
		});
	}
	
	
	public void realizarPesquisa() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				iBusca busca = new iBusca();
				
				busca.busca.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(busca.cbox.getSelectedItem().equals("Título")) {
							buscados = buscarTitulo(busca.field.getText());
						}
						else if(busca.cbox.getSelectedItem().equals("Autor")){
							buscados = buscarAutor(busca.field.getText());
						}else if(busca.cbox.getSelectedItem().equals("Categoria")) {
							buscados = buscarCategoria(busca.field.getText());
						}else {
							buscados = buscarEditora(busca.field.getText());
						}
						new iTable(buscados);
					}
					
				});
				
			}
			
		});
	}
	
	public ArrayList<Livro> buscarTitulo(String strBusca){
		ArrayList<Livro> buscados = new ArrayList<Livro>();
		for(Livro l: livros) {
			if(l.getTitulo().contains(strBusca)) {
				buscados.add(l);
			}
		}
		return buscados;
	}
	
	public ArrayList<Livro> buscarAutor(String strBusca){
		ArrayList<Livro> buscados = new ArrayList<Livro>();
		for(Livro l: livros) {
			for(int i = 0; i < l.getAutores().size(); i++) {
				if(l.getAutores().get(i).getnomeAutor().contains(strBusca.toUpperCase())) {
					buscados.add(l);
				}
			}
		}
		return buscados;
	}
	
	public ArrayList<Livro> buscarCategoria(String strBusca){
		ArrayList<Livro> buscados = new ArrayList<Livro>();
		for(Livro l: livros) {
			if(l.getCategoria().contains(strBusca.toUpperCase())) {
				buscados.add(l);
			}
		}
		return buscados;
	}
	
	public ArrayList<Livro> buscarEditora(String strBusca){
		ArrayList<Livro> buscados = new ArrayList<Livro>();
		for(Livro l: livros) {
			if(l.getEditora().getNome().contains(strBusca.toUpperCase())) {
				buscados.add(l);
			}
		}
		return buscados;
	}
	
}
