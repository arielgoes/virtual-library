import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class iMessage extends JFrame{
	
	public JButton OkButton;
	public JLabel text;
	
	public iMessage(String txt) {
		setTitle("Mensagem");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 200);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		OkButton = new JButton("OK");
		text = new JLabel();
		text.setText(txt);
		
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		OkButton.setBounds(200, 80, 100, 50);
		text.setBounds(20, 40, 460, 40);
		
		panel.setLayout(null);
		
		panel.add(OkButton);
		panel.add(text);
			
	}

}
