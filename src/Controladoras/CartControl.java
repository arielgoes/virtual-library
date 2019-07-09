package Controladoras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import Entidades.Cliente;
import Entidades.Livro;
import Interfaces.iCart;
import Interfaces.iMessage;

public class CartControl {
	
	Cliente cliente;
	
	public CartControl(Cliente clienteAtual) {
		this.cliente = clienteAtual;
	}
	
	public void visualizarCarrinho() {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ArrayList<Livro> livros = cliente.getCarrinho().getLivroPedido().getLivros();
				
				iCart cart = new iCart(livros);
				cart.voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cart.setVisible(false);
						cart.dispose();
					}
					
				});
				
				cart.adicionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							int row = cart.table.getSelectedRow();
							String isbn = (String)cart.table.getValueAt(row, 0);
							
							for(Livro l: livros) {
								if(l.getIsbn().equalsIgnoreCase(isbn)) {
									if(l.getEstoque() >= 1) {										
										livros.add(l);
										l.retirarEstoque(1);
										break;
									}else {
										new iMessage("Não há mais unidades desse livro em estoque!");
										break;
									}
								}
							}
							cart.attTotal(livros);
							cart.atualizarTable(livros);
						}catch(ArrayIndexOutOfBoundsException exception) {
							new iMessage("Nenhum livro selecionado! Primeiro selecione o livro.");
						}
					}
					
				});
				
				cart.remover.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							int row = cart.table.getSelectedRow();
							String isbn = (String)cart.table.getValueAt(row, 0);
							
							for(Livro l: livros) {
								if(l.getIsbn().equalsIgnoreCase(isbn)) {
									livros.remove(l);
									l.addEstoque(1);
									break;
								}
							}
							cart.attTotal(livros);
							cart.atualizarTable(livros);
						}catch(ArrayIndexOutOfBoundsException exception) {
							new iMessage("Nenhum livro selecionado! Primeiro selecione o livro.");
						}
					}
					
				});
				
				cart.finalizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new iMessage("NÃO IMPLEMENTADO AINDA!");
						
					}
					
				});
			}
			
		});
	}
}
