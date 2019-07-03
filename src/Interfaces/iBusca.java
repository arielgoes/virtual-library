package Interfaces;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class iBusca extends JFrame{
	private static final long serialVersionUID = 1L;
	String[][] dados;
	
	
	public JLabel label;
	public JTextField field;
	public JButton busca;
	public JButton cancel;
	public JComboBox<String> cbox;
	
	public iBusca() {
		setTitle("Livraria Virtual - Busca");
		setSize(600, 210);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		label = new JLabel("Parâmetro da Busca: ");
		field = new JTextField();
		field.setColumns(20);
		busca = new JButton("Buscar");
		cancel = new JButton("Cancelar");
		String[] tipos = {"Título", "Autor", "Categoria", "Editora"};
		cbox = new JComboBox<String>(tipos);
		
		Container content = getContentPane();
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		
		add(label);
		add(field);
		add(cancel);
		add(cbox);
		add(busca);
		
		layout.putConstraint(SpringLayout.WEST, (Component)label, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)label, 25, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)field, 31, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, (Component)field, 25, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)cbox, 25, SpringLayout.EAST, field);
		layout.putConstraint(SpringLayout.NORTH, (Component)cbox, 25, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)cancel, 50, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)cancel, 25, SpringLayout.SOUTH, label);
		
		layout.putConstraint(SpringLayout.WEST, (Component)busca, 100, SpringLayout.EAST, cancel);
		layout.putConstraint(SpringLayout.NORTH, (Component)busca, 25, SpringLayout.SOUTH, label);
		
		
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
