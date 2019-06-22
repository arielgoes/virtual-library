import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class LivrariaVirtual extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int numeroPedido = 0;
	
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]){
		
		Controladora control = new Controladora();
		
		try {
			control.loadEditoras();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			control.loadAutores();
		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
		
		try {
			control.loadLivros();
		} catch (FileNotFoundException | ParseException e) {
			e.printStackTrace();
		}
		
		control.addLivrosToAutores();
		
		control.realizarLogin();
	
	}
}
