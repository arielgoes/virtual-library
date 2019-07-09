package Controladoras;
import Interfaces.iMain;
import Interfaces.iMessage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Entidades.Autor;
import Entidades.Categoria;
import Entidades.Cliente;
import Entidades.Editora;
import Entidades.Livro;
import Entidades.Pedido;

public class MainControl extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	public static int numeroPedido = 0;
	public static iMain main;
	
	public static Scanner in = new Scanner(System.in);
	
	public static ArrayList<Editora> editoras = new ArrayList<Editora>();
	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Autor> autores = new ArrayList<Autor>();
	public static ArrayList<Livro> livros = new ArrayList<Livro>();
	public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public static Hashtable<String, String> users = new Hashtable<String, String>();
	public static Cliente cliente_atual;
	
	
	public static void main(String args[]){
		
		
		try {
			loadEditoras();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			loadAutores();
		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
		
		try {
			loadLivros();
		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
		
		addLivrosToAutores();
		
		SwingUtilities.invokeLater(new Runnable() {
	
			public void run() {
				
				main = new iMain();
				
				main.login.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						realizarLogin();
					}
				});
					
				main.busca.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						realizarPesquisa();
					}
				});
				
				main.pedidos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new iMessage("NÃO IMPLEMENTADO AINDA");
					}
				});
				
				main.carrinho.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						visualizarCarrinho();
					}
				});
				
				main.compra.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new iMessage("NÃO IMPLEMENTADO AINDA");
					}
				});
			}
		});
	}
	
	
	public static void loadEditoras() throws FileNotFoundException{
		ArrayList<String> enderecoEditora = new ArrayList<String>();
		String pathEditoras = ClassLoader.getSystemClassLoader().getResource(".").getPath() + "/Paths/editoras.txt";
		String DpathEditoras = null;
		try {
			DpathEditoras = URLDecoder.decode(pathEditoras, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			new iMessage("Erro!");
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new FileReader(DpathEditoras));
		
		
		String pathEnderecos = ClassLoader.getSystemClassLoader().getResource(".").getPath() + "/Paths/enderecosEditoras.txt";
		String DpathEnderecos = null;
		try {
			DpathEnderecos = URLDecoder.decode(pathEnderecos, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			new iMessage("Erro!");
			e1.printStackTrace();
		}
		BufferedReader br2 = new BufferedReader(new FileReader(DpathEnderecos));
		
		
		try {
			String enderecoEd;
			while((enderecoEd = br2.readLine()) != null) {
				enderecoEditora.add(enderecoEd);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		int i = 0;
		try {
			String st;
			while((st = br.readLine()) != null) {
				
				String[] split = st.split(";");
				String nome = split[0];
				String endereco = enderecoEditora.get(i);
				String telefone = split[2];
				String cnpj = split[3];
				i++;
				
				Editora editora = new Editora(nome, endereco, telefone, cnpj);
				editoras.add(editora);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void loadAutores() throws FileNotFoundException, ParseException{
		String pathAutores = ClassLoader.getSystemClassLoader().getResource(".").getPath() + "/Paths/autores.txt";
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
	
	
	public static void loadLivros() throws FileNotFoundException, ParseException {
		String pathLivros = ClassLoader.getSystemClassLoader().getResource(".").getPath() + "/Paths/livros.txt";
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
				livro.setAutor(getAutores(), nomeAutor);
				livros.add(livro);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void addLivrosToAutores() {
		
		for(Autor a: autores) {
			for(Livro l: livros) {
				if(a.getnomeAutor().equals(l.getNomeAutor(a.getnomeAutor()))) {
					a.setLivroAutor(l);
				}
			}
		}
	}
	
	public static ArrayList<Autor> getAutores(){
		return autores;
	}
	
	public static void realizarLogin() {
		LoginControl lc = new LoginControl();
		lc.login();
	}
	
	
	public static void realizarPesquisa() {
		SearchControl sc = new SearchControl(livros);
		sc.buscar();
	}
	
	public static void visualizarCarrinho() {
		CartControl cc = new CartControl(cliente_atual);
		cc.visualizarCarrinho();
	}
	
}
