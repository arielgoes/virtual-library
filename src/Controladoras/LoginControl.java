package Controladoras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import Entidades.Cliente;
import Interfaces.iLogin;
import Interfaces.iMessage;

public class LoginControl {
	
	public LoginControl() {
		
	}
	
	public void login() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				iLogin login = new iLogin();
				
				login.loginButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						final String username = login.getUsernameField();
						final String password = login.getPasswordField();
						if(MainControl.users.containsKey(username)) {
							if(MainControl.users.get(username).contentEquals(password)) {
								for(Cliente c: MainControl.clientes) {
									if(c.getUsername().equals(username) && c.getPassword().equals(password)) {
										new iMessage("Logado com sucesso como " + c.getNome() + ".");
										MainControl.cliente_atual = c;
										MainControl.main.busca.setEnabled(true);
										MainControl.main.carrinho.setEnabled(true);
										MainControl.main.pedidos.setEnabled(true);
										MainControl.main.compra.setEnabled(true);
										login.setVisible(false);
										login.dispose();
									}
								}
							}else {
								new iMessage("Nome de usuário ou senha incorretos.");
							}
						}else {
							new iMessage("Nome de usuário ou senha incorretos.");
						}
					}
					
				});
				
				login.registerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							realizarCadastro();
					}
					
				});
			}
		});
	}
	
	public void realizarCadastro() {
		RegisterControl rc = new RegisterControl();
		rc.registro();
	}
}
