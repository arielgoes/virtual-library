package Interfaces;
import Controladoras.SpringUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SpringLayout;

public class iRegister extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public JLabel nameLabel;
	public JLabel idadeLabel;
	public JLabel cpfLabel;
	public JLabel emailLabel;
	public JLabel telefoneLabel;
	public JLabel usernameLabel;
	public JLabel passwordLabel;
	
	public JTextField nameField;
	public JTextField idadeField;
	public JTextField cpfField;
	public JTextField emailField;
	public JTextField telefoneField;
	public JTextField usernameField;
	public JTextField passwordField;
	
	public JButton OkButton;
	public JButton CancelButton;
	
	public iRegister() {
		setTitle("Livraria Virtual - Registro");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		nameField = new JTextField(20);
		idadeField = new JTextField(20);
		cpfField = new JTextField(20);
		emailField = new JTextField(20);
		telefoneField = new JTextField(20);
		usernameField = new JTextField(20);
		passwordField = new JPasswordField(20);
		
		nameLabel = new JLabel("Nome");
		idadeLabel = new JLabel("Idade");
		cpfLabel = new JLabel("CPF");
		emailLabel = new JLabel("E-mail");
		telefoneLabel = new JLabel("Telefone");
		usernameLabel = new JLabel("Nome de Usuário");
		passwordLabel = new JLabel("Senha");
		//String[] labels = {"Nome: ", "Idade: ", "CPF: ", "E-Mail: ", "Telefone: ", "Nome de Usuário: ", "Senha: "};
		
		OkButton = new JButton("Confirmar");
		CancelButton = new JButton("Cancelar");
		
		panel.add(nameLabel);
		nameLabel.setLabelFor(nameField);
		panel.add(nameField);
		
		panel.add(nameLabel);
		nameLabel.setLabelFor(nameField);
		panel.add(nameField);
		
		panel.add(idadeLabel);
		idadeLabel.setLabelFor(idadeField);
		panel.add(idadeField);
		
		panel.add(cpfLabel);
		cpfLabel.setLabelFor(cpfField);
		panel.add(cpfField);
		
		panel.add(emailLabel);
		emailLabel.setLabelFor(emailField);
		panel.add(emailField);
		
		panel.add(telefoneLabel);
		telefoneLabel.setLabelFor(telefoneField);
		panel.add(telefoneField);
		
		panel.add(usernameLabel);
		usernameLabel.setLabelFor(usernameField);
		panel.add(usernameField);
		
		panel.add(passwordLabel);
		passwordLabel.setLabelFor(passwordField);
		panel.add(passwordField);
		
		
		panel.add(CancelButton);
		panel.add(OkButton);
		
		panel.setLayout(new SpringLayout());
		
		 SpringUtilities.makeCompactGrid(panel, //parent
                 8, 2,
                 3, 3,  //initX, initY
                 1, 1); //xPad, yPad

	}
}
