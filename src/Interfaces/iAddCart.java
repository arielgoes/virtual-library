package Interfaces;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class iAddCart extends JFrame{

	private static final long serialVersionUID = 1L;
	public JLabel label;
	public JTextField field;
	public JButton ok;
	public JButton voltar;
	
	
	public iAddCart(String nomeLivro) {
		setTitle("Livraria Virtual - Adicionar ao Carrinho");
		setSize(500, 175);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		label = new JLabel("Quantas cópias do livro " + nomeLivro + " você deseja adicionar?");
		field = new JTextField();
		field.setColumns(3);
		ok = new JButton("Ok");
		ok.setPreferredSize(new Dimension(100, 30));
		voltar = new JButton("Voltar");
		voltar.setPreferredSize(new Dimension(100, 30));
		
		Container content = getContentPane();
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		add(label);
		add(field);
		add(voltar);
		add(ok);
		
		layout.putConstraint(SpringLayout.WEST, (Component)label, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)label, 35, SpringLayout.NORTH, content);
	
		layout.putConstraint(SpringLayout.WEST, (Component)field, 25, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, (Component)field, 35, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)voltar, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)voltar, 35, SpringLayout.SOUTH, field);
		
		layout.putConstraint(SpringLayout.WEST, (Component)ok, 25, SpringLayout.EAST, voltar);
		layout.putConstraint(SpringLayout.NORTH, (Component)ok, 35, SpringLayout.SOUTH, field);
		
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voltarBtn();
			}
			
		});;
	}
	
	public void voltarBtn() {
		this.setVisible(false);
		this.dispose();
	}
}
