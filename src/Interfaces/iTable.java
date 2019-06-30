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
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class iTable extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public JLabel label;
	public JTextField field;
	public JButton nome;
	public JButton autor;
	public JButton categoria;
	
	JTable table;
	JButton maisInfo;
	JButton addCarrinho;
	JButton cancel;
	
	public iTable(ArrayList<Livro> livros) {
		setSize(500, 275);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Livraria Virtual - Resultados da Busca");
		setLocationRelativeTo(null);
		
		List<List<String>> data = new ArrayList<List<String>>();
		String[] colunas = {"ISBN", "Título", "Autor", "Cacteogria", "Preço"};
		
		for(Livro l: livros) {
			List<String> row = new ArrayList<String>();
			row.add(l.getIsbn());
			row.add(l.getTitulo());
			row.add(l.getAutores().get(0).getnomeAutor());
			row.add(l.showCategoriaName());
			row.add("" + l.getPreco());
			data.add(row);
		}
		
		String[][] dados = toMatrix(data, livros.size(), colunas.length);
		
		label = new JLabel("Parâmetro da Busca: ");
		field = new JTextField();
		nome = new JButton("Buscar Por Nome");
		autor = new JButton("Buscar Por Autor");
		categoria = new JButton("Buscar Por Categoria");
		table = new JTable(dados, colunas);
		cancel = new JButton("Cancelar");
		maisInfo = new JButton("Mais Info");
		addCarrinho = new JButton("Adicionar ao Carrinho");
		
		
		Container content = getContentPane();
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		Dimension d = new Dimension(450, 150);
		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(d);
		add(sp);
		
		add(cancel);
		add(maisInfo);
		add(addCarrinho);
		
		layout.putConstraint(SpringLayout.WEST, (Component)sp, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)sp, 25, SpringLayout.SOUTH, addCarrinho);
		
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
		
		maisInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int row = table.getSelectedRow();
					String isbn = (String) table.getValueAt(row, 0);
					for(Livro l: livros) {
						if(l.getIsbn().equals(isbn)) {
							new iMaisInfo(l);
						}
					}
				}catch(ArrayIndexOutOfBoundsException exception) {
					new iMessage("Nenhum livro selecionado! Primeiro selecione o livro.");
				}
			}
			
		});
		
		
	}
	
	public String[][] toMatrix(List<List<String>> data, int rows, int columns){
		String[][] dados = new String[rows][5];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				dados[i][j] = data.get(i).get(j);
			}
		}
		
		return dados;
	}
	
	public void  cancelBtn() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void maisInfoBtn(Livro l) {
		new iMaisInfo(l);
	}
	
}
