package Interfaces;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import Entidades.Livro;

public class iCart extends JFrame{
	private static final long serialVersionUID = 1L;
	public String[] colunas = {"ISBN", "Título", "Autor", "Cacteogria", "Preço", "Quant"};
	JScrollPane sp;
	SpringLayout layout;
	String[][] dados;
	Container content;
	
	public JLabel label;
	public JTable table;
	public JLabel total;
	public JTextField field;
	public JButton voltar;
	public JButton remover;
	public JButton adicionar;
	public JButton finalizar;
	
	
	public iCart(ArrayList<Livro> livros) {
		
		
		setTitle("Livraria Virtual - VisualizarCarrinho Carrinho");
		setSize(670, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		label = new JLabel("SEU CARRINHO");
		Font font = new Font("SansSerif", Font.BOLD, 20);
		label.setFont(font);
		dados = toMatrix(livros);
		table = new JTable(dados, colunas);
		table.setDefaultEditor(Object.class, null);
		total = new JLabel("Valor Carrinho");
		field = new JTextField();
		field.setColumns(6);
		this.attTotal(livros);
		field.setEditable(false);
		voltar = new JButton("Voltar");
		remover = new JButton("Remover");
		adicionar = new JButton("Adicionar");
		finalizar = new JButton("Finalizar Compra");
		
		content = getContentPane();
		layout = new SpringLayout();
		setLayout(layout);
		Dimension d = new Dimension(450, 150);
		sp = new JScrollPane((Component)table);
		sp.setPreferredSize(d);
		
		add(label);
		add(sp);
		add(voltar);
		add(total);
		add(field);
		add(remover);
		add(adicionar);
		add(finalizar);
		
		layout.putConstraint(SpringLayout.WEST, (Component)label, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)label, 35, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)sp, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)sp, 35, SpringLayout.SOUTH, label);
		
		layout.putConstraint(SpringLayout.WEST, (Component)adicionar, 500, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)adicionar, 35, SpringLayout.SOUTH, label);
		
		layout.putConstraint(SpringLayout.WEST, (Component)remover, 500, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)remover, 35, SpringLayout.SOUTH, adicionar);

		layout.putConstraint(SpringLayout.WEST, (Component)voltar, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)voltar, 275, SpringLayout.NORTH, content);
	
		layout.putConstraint(SpringLayout.WEST, (Component)total, 50, SpringLayout.EAST, voltar);
		layout.putConstraint(SpringLayout.NORTH, (Component)total, 275, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)field, 5, SpringLayout.EAST, total);
		layout.putConstraint(SpringLayout.NORTH, (Component)field, 275, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)finalizar, 25, SpringLayout.EAST, field);
		layout.putConstraint(SpringLayout.NORTH, (Component)finalizar, 275, SpringLayout.NORTH, content);
	}
	
	public String[][] toMatrix(ArrayList<Livro> livros) {
		List<List<String>> data = new ArrayList<List<String>>();
		
		for(Livro l: livros) {
			boolean existe = false;
			for(int i = 0; i < data.size()/colunas.length; i++) {
				if(data.get(i).get(0) == l.getIsbn()) {
					int quant = Integer.parseInt(data.get(i).get(5));
					quant+=1;
					data.get(i).remove(5);
					data.get(i).add("" + quant);
					existe = true;
					break;
				}
			}
			if(existe == false) {
				List<String> row = new ArrayList<String>();
				row.add(l.getIsbn());
				row.add(l.getTitulo());
				row.add(l.getAutores().get(0).getnomeAutor());
				row.add(l.getCategoria());
				row.add("" + l.getPreco());
				row.add("" + 1);
				data.add(row);				
			}
			existe = false;
		}
		int rows = data.size()/colunas.length;
		int columns = colunas.length;
		String[][] dados = new String[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				dados[i][j] = data.get(i).get(j);
			}
		}
		
		return dados;
	}
	
	
	public void voltarBtn() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void attTotal(ArrayList<Livro> livro) {
		double total = 0;
		for(Livro l: livro) {
			total += l.getPreco();
		}
		this.field.setText("R$ " + total);
	}
	
	public void atualizarTable(ArrayList<Livro> livros) {
		this.remove(table);
		this.remove(sp);
		this.revalidate();
		dados = toMatrix(livros);
		
		table = new JTable(dados, colunas);
		table.setDefaultEditor(Object.class, null);
		Dimension d = new Dimension(450, 150);
		sp = new JScrollPane(table);
		sp.setPreferredSize(d);
		this.add(sp);
		layout.putConstraint(SpringLayout.WEST, (Component)sp, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)sp, 35, SpringLayout.SOUTH, label);
		this.revalidate();
	}
	
	
}
