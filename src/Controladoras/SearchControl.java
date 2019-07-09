package Controladoras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import Entidades.Livro;
import Interfaces.iSearch;

public class SearchControl {

	private ArrayList<Livro> livros;
	private ArrayList<Livro> buscados;
	
	public SearchControl(ArrayList<Livro> livros) {
		this.livros = livros;
		this.buscados = new ArrayList<Livro>();
	}
	
	public void buscar() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				iSearch busca = new iSearch(livros);
				
				busca.busca.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(busca.cbox.getSelectedItem().equals("Título")) {
							buscados = buscarTitulo(busca.field.getText());
						}
						else if(busca.cbox.getSelectedItem().equals("Autor")){
							buscados = buscarAutor(busca.field.getText());
						}else if(busca.cbox.getSelectedItem().equals("Categoria")) {
							buscados = buscarCategoria(busca.field.getText());
						}else {
							buscados = buscarEditora(busca.field.getText());
						}
						busca.atualizarTable(buscados);
					}
					
				});
				
			}
			
		});
	}
	
	public ArrayList<Livro> buscarTitulo(String strBusca){
		ArrayList<Livro> buscados = new ArrayList<Livro>();
		for(Livro l: livros) {
			if(l.getTitulo().contains(strBusca)) {
				buscados.add(l);
			}
		}
		return buscados;
	}
	
	public ArrayList<Livro> buscarAutor(String strBusca){
		ArrayList<Livro> buscados = new ArrayList<Livro>();
		for(Livro l: livros) {
			for(int i = 0; i < l.getAutores().size(); i++) {
				if(l.getAutores().get(i).getnomeAutor().contains(strBusca.toUpperCase())) {
					buscados.add(l);
				}
			}
		}
		return buscados;
	}
	
	public ArrayList<Livro> buscarCategoria(String strBusca){
		ArrayList<Livro> buscados = new ArrayList<Livro>();
		for(Livro l: livros) {
			if(l.getCategoria().contains(strBusca.toUpperCase())) {
				buscados.add(l);
			}
		}
		return buscados;
	}
	
	public ArrayList<Livro> buscarEditora(String strBusca){
		ArrayList<Livro> buscados = new ArrayList<Livro>();
		for(Livro l: livros) {
			if(l.getEditora().getNome().contains(strBusca.toUpperCase())) {
				buscados.add(l);
			}
		}
		return buscados;
	}
}
