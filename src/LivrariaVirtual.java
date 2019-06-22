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
	
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]) throws FileNotFoundException, ParseException {
		
		Controladora control = new Controladora();
		
		//load Editoras
		control.loadEditoras();
		
		//test autores
		control.loadAutores();
		
		control.loadLivros();
		
		//adicionando os livros em autores...
		control.addLivrosToAutores();

		for(Autor a: control.autores) {
			a.showLivros();
			System.out.println("\n");
		}
		
		control.logar();
	
	}
}
