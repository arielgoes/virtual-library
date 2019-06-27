package Interfaces;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import Entidades.Livro;

public class iMaisInfo extends JFrame {
	private static final long serialVersionUID = 1L;

	public JLabel isbn;
	public JLabel titulo;
	public JLabel categoria;
	public JLabel autores;
	public JLabel editora;
	public JLabel preco;
	public JLabel resumoL;
	public JTextArea resumo;
	public JButton voltar;
	
	public iMaisInfo(Livro l) {
		setTitle("Livraria Virtual - Informações de " + l.getTitulo());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 600);
		setVisible(true);
		
		isbn = new JLabel("ISBN: " + l.getIsbn());
		titulo = new JLabel("Título: " + l.getTitulo());
		categoria = new JLabel("Categoria: " + l.getCategoria().name());
		autores = new JLabel("Autores: " + l.getAutores().get(0).getnomeAutor());
		editora = new JLabel("Editora: " + l.getEditora().getNome());
		preco = new JLabel("Preço: " + l.getPreco());
		resumoL = new JLabel("Resumo: ");
		resumo = new JTextArea();
		resumo.setText(l.getResumo());
		resumo.setEditable(false);
		voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voltarBtn();
			}
			
		});
		
		Container content = getContentPane();
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		Dimension d = new Dimension(200, 200);
		JScrollPane sp = new JScrollPane(resumo);
		sp.setPreferredSize(d);
		
		add(isbn);
		add(titulo);
		add(categoria);
		add(autores);
		add(editora);
		add(preco);
		add(resumoL);
		add(sp);
		add(voltar);
		
		
		layout.putConstraint(SpringLayout.WEST, (Component)isbn, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)isbn, 25, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)titulo, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)titulo, 25, SpringLayout.SOUTH, isbn);
		
		layout.putConstraint(SpringLayout.WEST, (Component)categoria, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)categoria, 25, SpringLayout.SOUTH, titulo);

		layout.putConstraint(SpringLayout.WEST, (Component)autores, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)autores, 25, SpringLayout.SOUTH, categoria);
		
		layout.putConstraint(SpringLayout.WEST, (Component)editora, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)editora, 25, SpringLayout.SOUTH, autores);

		layout.putConstraint(SpringLayout.WEST, (Component)preco, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)preco, 25, SpringLayout.SOUTH, editora);
		
		layout.putConstraint(SpringLayout.WEST, (Component)resumoL, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)resumoL, 25, SpringLayout.SOUTH, preco);		

		layout.putConstraint(SpringLayout.WEST, (Component)sp, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)sp, 5, SpringLayout.SOUTH, resumoL);
		
		layout.putConstraint(SpringLayout.WEST, (Component)voltar, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)voltar, 25, SpringLayout.SOUTH, sp);
	}
	
	public void voltarBtn() {
		this.setVisible(false);
		this.dispose();
	}
}
