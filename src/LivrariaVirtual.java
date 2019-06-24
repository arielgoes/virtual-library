import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class LivrariaVirtual extends JFrame {

	private static final long serialVersionUID = 1L;
	public static int numeroPedido = 0;
	public static Controladora control;
	
	
	public static Scanner in = new Scanner(System.in);
	public static boolean logged = false;
	
	public static void main(String args[]){
		
		control = new Controladora();
		
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
		
		SwingUtilities.invokeLater(new Runnable() {
	
			public void run() {
				
				iMain main = new iMain();
				
				main.login.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						control.realizarLogin();
						main.busca.setEnabled(true);
						main.pedidos.setEnabled(true);
						main.carrinho.setEnabled(true);
						main.compra.setEnabled(true);
					}
				});
					
				main.busca.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						control.realizarPesquisa();
					}
				});
				
				main.pedidos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new iMessage("NÃO IMPLEMENTADO AINDA");
					}
				});
				
				main.carrinho.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new iMessage("NÃO IMPLEMENTADO AINDA");
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
}
