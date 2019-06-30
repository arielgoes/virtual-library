package Interfaces;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class iBusca extends JFrame{
	private static final long serialVersionUID = 1L;
	String[][] dados;
	
	
	public JLabel label;
	public JTextField field;
	public JButton nome;
	public JButton autor;
	public JButton categoria;
	public JButton cancel;
	public JButton editora;
	
	public iBusca() {
		setTitle("Livraria Virtual - Busca");
		setSize(600, 410);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		label = new JLabel("Parâmetro da Busca: ");
		field = new JTextField();
		field.setColumns(30);
		nome = new JButton("Buscar Por Nome");
		autor = new JButton("Buscar Por Autor");
		categoria = new JButton("Buscar Por Categoria");
		editora = new JButton("Buscar Por Editora");
		cancel = new JButton("Cancelar");
		
		
		Container content = getContentPane();
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		
		add(label);
		add(field);
		add(nome);
		add(autor);
		add(categoria);
		add(editora);
		add(cancel);
		
		layout.putConstraint(SpringLayout.WEST, (Component)label, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)label, 25, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)field, 31, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, (Component)field, 25, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)nome, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)nome, 25, SpringLayout.SOUTH, label);
		
		layout.putConstraint(SpringLayout.WEST, (Component)autor, 25, SpringLayout.EAST, nome);
		layout.putConstraint(SpringLayout.NORTH, (Component)autor, 25, SpringLayout.SOUTH, label);
		
		layout.putConstraint(SpringLayout.WEST, (Component)categoria, 25, SpringLayout.EAST, autor);
		layout.putConstraint(SpringLayout.NORTH, (Component)categoria, 25, SpringLayout.SOUTH, label);   
		
		layout.putConstraint(SpringLayout.WEST, (Component)editora, 90, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)editora, 25, SpringLayout.SOUTH, autor); 
		
		layout.putConstraint(SpringLayout.WEST, (Component)cancel, 50, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)cancel, 25, SpringLayout.SOUTH, editora);
		
		
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
