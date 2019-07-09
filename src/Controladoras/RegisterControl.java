package Controladoras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import Entidades.Cliente;
import Interfaces.iMessage;
import Interfaces.iRegister;

public class RegisterControl {
	
	public RegisterControl() {
		
	}
	
	public void registro() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				iRegister registro = new iRegister();
				registro.OkButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nome = registro.nameField.getText();
						String idade = registro.idadeField.getText();
						String cpf = registro.cpfField.getText();
						String email = registro.emailField.getText();
						String telefone = registro.telefoneField.getText();
						
						String username = registro.usernameField.getText();
						String password = registro.passwordField.getText();
						
						if(MainControl.users.contains(username)) {
							new iMessage("Username já está em uso, tente outro.");
						}else {
							Cliente c = new Cliente(nome, idade, cpf, email, telefone, username, password);
							MainControl.clientes.add(c);
							MainControl.users.put(username, password);
							new iMessage("Registro Bem Sucedido");
							registro.setVisible(false);
							registro.dispose();	
						}
					}
				});
				
				registro.CancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						registro.setVisible(false);
						registro.dispose();
						
					}		
				});
			}
		});
	}
}
