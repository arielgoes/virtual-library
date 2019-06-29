package Interfaces;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class iBusca extends JFrame{
	private static final long serialVersionUID = 1L;

	public JLabel label;
	public JTextField field;
	public JButton nome;
	public JButton autor;
	public JButton categoria;
	public JButton cancel;
	
	public iBusca() {
		setTitle("Livraria Virtual - Busca");
		setSize(700, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		label = new JLabel("Parâmetro da Busca: ");
		field = new JTextField();
		nome = new JButton("Buscar Por Nome");
		autor = new JButton("Buscar Por Autor");
		categoria = new JButton("Buscar Por Categoria");
		cancel = new JButton("Cancelar");
		
		Container content = getContentPane();
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelBtn();
			}
			
		});
	}
	
	public void cancelBtn() {
		setVisible(false);
		dispose();
	}
}
