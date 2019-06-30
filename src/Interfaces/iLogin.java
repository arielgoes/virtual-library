package Interfaces;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class iLogin extends JFrame{
	
	public JButton loginButton;
	public JButton registerButton;
	public JLabel usernameLabel;
	public JLabel passwordLabel;
	public JTextField usernameField;
	public JPasswordField passwordField;
	
	private static final long serialVersionUID = 1L;

	public iLogin() {
		setTitle("Livraria Virtual - Login");
		setVisible(true);
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		loginButton = new JButton("Login");
		registerButton = new JButton("Registro");
		usernameLabel = new JLabel("Usuário");
		passwordLabel = new JLabel("Senha");
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		add(usernameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(usernameField, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.NONE;
		add(passwordLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.fill = GridBagConstraints.HORIZONTAL;
		add(passwordField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.NONE;
		add(loginButton, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		gc.fill = GridBagConstraints.NONE;
		add(registerButton, gc);
	}
	
	public String getUsernameField() {
		return usernameField.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPasswordField() {
		return passwordField.getText();
	}
	
}
