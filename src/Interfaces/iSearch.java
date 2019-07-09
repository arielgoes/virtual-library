package Interfaces;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Controladoras.MainControl;
import Entidades.Livro;

public class iSearch extends JFrame{
	private static final long serialVersionUID = 1L;
	public String[][] dados;
	public String[] colunas = {"ISBN", "Título", "Autor", "Cacteogria", "Preço"};
	public Container content;
	public SpringLayout layout;
	public Livro livroAtual;
	public int copias;
	
	public JScrollPane sp;
	public JLabel label;
	public JTextField field;
	public JButton busca;
	public JButton cancel;
	public JComboBox<String> cbox;
	
	public JTable table;
	public JButton addCarrinho;
	public JButton maisInfo;
	
	public iSearch(ArrayList<Livro> livros) {
		setTitle("Livraria Virtual - Busca");
		setSize(600, 390);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		
		label = new JLabel("Parâmetro da Busca: ");
		field = new JTextField();
		field.setColumns(20);
		busca = new JButton("Buscar");
		cancel = new JButton("Voltar");
		String[] tipos = {"Título", "Autor", "Categoria", "Editora"};
		cbox = new JComboBox<String>(tipos);
		
		dados = toMatrix(livros);
		table = new JTable(dados, colunas);
		maisInfo = new JButton("Mais Info");
		addCarrinho = new JButton("Adicionar ao Carrinho");
		
		content = getContentPane();
		layout = new SpringLayout();
		setLayout(layout);
		Dimension d = new Dimension(450, 150);
		sp = new JScrollPane(table);
		sp.setPreferredSize(d);
		
		add(label);
		add(field);
		add(cancel);
		add(cbox);
		add(busca);
		add(sp);
		add(maisInfo);
		add(addCarrinho);
		
		layout.putConstraint(SpringLayout.WEST, (Component)label, 25, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)label, 35, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)field, 31, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, (Component)field, 35, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)cbox, 25, SpringLayout.EAST, field);
		layout.putConstraint(SpringLayout.NORTH, (Component)cbox, 35, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)cancel, 50, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)cancel, 300, SpringLayout.NORTH, content);
		
		layout.putConstraint(SpringLayout.WEST, (Component)busca, 25, SpringLayout.EAST, field);
		layout.putConstraint(SpringLayout.NORTH, (Component)busca, 25, SpringLayout.SOUTH, cbox);
		
		layout.putConstraint(SpringLayout.WEST, (Component)sp, 100, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)sp, 25, SpringLayout.SOUTH, busca);

		layout.putConstraint(SpringLayout.WEST, (Component)maisInfo, 125, SpringLayout.EAST, cancel);
		layout.putConstraint(SpringLayout.NORTH, (Component)maisInfo, 300, SpringLayout.NORTH, content);

		layout.putConstraint(SpringLayout.WEST, (Component)addCarrinho, 25, SpringLayout.EAST, maisInfo);
		layout.putConstraint(SpringLayout.NORTH, (Component)addCarrinho, 300, SpringLayout.NORTH, content);
		
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
							new iMoreInfo(l);
						}
					}
				}catch(ArrayIndexOutOfBoundsException exception) {
					new iMessage("Nenhum livro selecionado! Primeiro selecione o livro.");
				}
			}
			
		});
		
		addCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeLivro;
				String isbn;
				try {
					int row = table.getSelectedRow();
					nomeLivro = (String) table.getValueAt(row, 1);
					isbn = (String) table.getValueAt(row, 0);
					for(Livro l: livros) {
						if(l.getIsbn() == isbn) {
							livroAtual = l;
						}
					}
					iAddCart addCarrinho = new iAddCart(nomeLivro);
					
					addCarrinho.ok.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							copias = Integer.parseInt(addCarrinho.field.getText());
							if(livroAtual.getEstoque() >= copias) {								
								addAoCarrinho(copias);
								livroAtual.retirarEstoque(copias);
								addCarrinho.setVisible(false);
								addCarrinho.dispose();
								new iMessage(copias + " cópias do livro " + livroAtual.getTitulo() + " adcionadas ao carrinho!");
							}else {
								new iMessage("Temos apenas " + livroAtual.getEstoque() + " cópias desse livro em estoque");
							}
						}
						
					});
					
				}catch(ArrayIndexOutOfBoundsException exception) {
					new iMessage("Nenhum livro selecionado! Primeiro selecione o livro.");
				}
				
			}
			
		});
		
	}
	
	public void cancelBtn() {
		setVisible(false);
		dispose();
	}
	
	public String[][] toMatrix(ArrayList<Livro> livros) {
		List<List<String>> data = new ArrayList<List<String>>();
		for(Livro l: livros) {
			List<String> row = new ArrayList<String>();
			row.add(l.getIsbn());
			row.add(l.getTitulo());
			row.add(l.getAutores().get(0).getnomeAutor());
			row.add(l.getCategoria());
			row.add("" + l.getPreco());
			data.add(row);
		}
		int rows = livros.size();
		int columns = colunas.length;
		String[][] dados = new String[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				dados[i][j] = data.get(i).get(j);
			}
		}
		
		return dados;
	}
	
	public void atualizarTable(ArrayList<Livro> livros) {
		this.remove(table);
		this.remove(sp);
		this.revalidate();
		dados = toMatrix(livros);
		
		table = new JTable(dados, colunas);
		Dimension d = new Dimension(450, 150);
		sp = new JScrollPane(table);
		sp.setPreferredSize(d);
		this.add(sp);
		layout.putConstraint(SpringLayout.WEST, (Component)sp, 100, SpringLayout.WEST, content);
		layout.putConstraint(SpringLayout.NORTH, (Component)sp, 25, SpringLayout.SOUTH, busca);
		this.revalidate();
	}
	
	public void addAoCarrinho(int quant) {
		
		MainControl.cliente_atual.getCarrinho().getLivroPedido().addLivro(livroAtual, quant);
	}

	
}
