import java.awt.Component;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class iMain extends JFrame{
	
	public JLabel label;
	public JButton login;
	public JButton busca;
	public JButton pedidos;
	public JButton carrinho;
	public JButton compra;
	
	public iMain() {
		setSize(200, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Livraria Virtual");
		
		Container content = getContentPane();
		
		SpringLayout layout = new SpringLayout();
		
		setLayout(layout);
		
		
		label = new JLabel("Escolha uma Opção");
		login = new JButton("Realizar Login");
		busca = new JButton("Realizar Busca");
		pedidos = new JButton("Vizualizar Pedidos");
		carrinho = new JButton("Vizualizar Carrinho");
		compra = new JButton("Finalizar Compra");
		
		add(label);
		add(login);
		add(busca);
		add(pedidos);
		add(carrinho);
		add(compra);
		
		busca.setEnabled(false);
		pedidos.setEnabled(false);
		carrinho.setEnabled(false);
		compra.setEnabled(false);
		
		layout.putConstraint(SpringLayout.WEST, (Component)label, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)label, 25, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)login, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)login, 25, SpringLayout.SOUTH, label);
		
		layout.putConstraint(SpringLayout.WEST, (Component)busca, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)busca, 25, SpringLayout.SOUTH, login);
		
		layout.putConstraint(SpringLayout.WEST, (Component)pedidos, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)pedidos, 25, SpringLayout.SOUTH, busca);
		
		layout.putConstraint(SpringLayout.WEST, (Component)carrinho, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)carrinho, 25, SpringLayout.SOUTH, pedidos);
		
		layout.putConstraint(SpringLayout.WEST, (Component)compra, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)compra, 25, SpringLayout.SOUTH, carrinho);
		
	}
}
