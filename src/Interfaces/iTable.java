package Interfaces;
import Entidades.Livro;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

public class iTable extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JTable table;
	JButton maisInfo;
	JButton addCarrinho;
	JButton cancel;
	
	public iTable(ArrayList<Livro> livros) {
		setSize(500, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Livraria Virtual - Resultados da Busca");
		setLocationRelativeTo(null);
		
		List<List<String>> data = new ArrayList<List<String>>();
		String[] colunas = {"ISBN", "Título", "Cacteogria", "Preço"};
		
		for(Livro l: livros) {
			List<String> row = new ArrayList<String>();
			row.add(l.getIsbn());
			row.add(l.getTitulo());
			row.add(l.showCategoriaName());
			row.add("" + l.getPreco());
			data.add(row);
		}
		
		String[][] dados = toMatrix(data, livros.size());
		
		table = new JTable(dados, colunas);
		table.setBounds(30, 40, 200, 300); 
		
		cancel = new JButton("Cancelar");
		maisInfo = new JButton("Mais Info");
		addCarrinho = new JButton("Adicionar ao Carrinho");
		
		Container content = getContentPane();
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		Dimension d = new Dimension(450, 100);
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(d);
		add(sp);
		
		sp.setSize(100, 50);
		add(cancel);
		add(maisInfo);
		add(addCarrinho);
		
		layout.putConstraint(SpringLayout.WEST, (Component)sp, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)sp, 25, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)cancel, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)cancel, 25, SpringLayout.SOUTH, sp);
		
		layout.putConstraint(SpringLayout.WEST, (Component)maisInfo, 25, SpringLayout.EAST, cancel);
		layout.putConstraint(SpringLayout.NORTH, (Component)maisInfo, 25, SpringLayout.SOUTH, sp);

		layout.putConstraint(SpringLayout.WEST, (Component)addCarrinho, 25, SpringLayout.EAST, maisInfo);
		layout.putConstraint(SpringLayout.NORTH, (Component)addCarrinho, 25, SpringLayout.SOUTH, sp);
	
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelBtn();
			}
		});
		
		
	}
	
	public String[][] toMatrix(List<List<String>> data, int rows){
		String[][] dados = new String[rows][4];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < 4; j++) {
				dados[i][j] = data.get(i).get(j);
			}
		}
		
		return dados;
	}
	
	public void  cancelBtn() {
		this.setVisible(false);
		this.dispose();
	}
	
}
