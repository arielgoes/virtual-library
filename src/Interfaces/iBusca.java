package Interfaces;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		add(label, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.NONE;
		add(cancel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(field, gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		add(nome, gc);
		
		gc.gridx = 2;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		add(autor, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.NONE;
		add(categoria, gc);
		
		
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
