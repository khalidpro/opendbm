package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connexion extends JFrame {

	String[] db = { "MySQL", "Oracle", "SQL Server", "Access" };
	JComboBox liste_db = new JComboBox(db);
	JLabel type = new JLabel("Type de base de donnée :");

	JTextField server = new JTextField("localhost");
	JTextField port = new JTextField("3306");
	JTextField user = new JTextField("root");
	JTextField password = new JTextField("");

	JLabel lblServer = new JLabel("Serveur :");
	JLabel lblPort = new JLabel("Port  :");
	JLabel lblUser = new JLabel("Utilisateur :");
	JLabel lblPassword = new JLabel("Mot de passe :");

	JButton con = new JButton("Connexion");

	JPanel panMySQL = new JPanel();
	JPanel panOracle = new JPanel();
	JPanel panSQLServer = new JPanel();
	JPanel panAccess = new JPanel();

	public Connexion() {
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Connesion");
		
		////////////////////////////////////////////////////////////////////////////
		
		JPanel pan=new JPanel();
		pan.add(type);
		pan.add(liste_db);
		this.getContentPane().add(pan,BorderLayout.NORTH);
		

//		Box b0=Box.createHorizontalBox();
//		
//		Box b1=Box.createVerticalBox();
//		Dimension d=new Dimension(100, 30);
//		
//		lblServer.setPreferredSize(d);
//		lblPort.setPreferredSize(d);
//		lblUser.setPreferredSize(d);
//		lblPassword.setPreferredSize(d);		
//		b1.add(lblServer);
//		b1.add(lblPort);
//		b1.add(lblUser);
//		b1.add(lblPassword);
//		
//		Box b2=Box.createVerticalBox();
//		Dimension d2=new Dimension(200, 30);
//		server.setPreferredSize(d2);
//		port.setPreferredSize(d2);
//		user.setPreferredSize(d2);
//		password.setPreferredSize(d2);
//		
//		b2.add(server);
//		b2.add(port);
//		b2.add(user);
//		b2.add(password);
//		
//		b0.add(b1);
//		b0.add(b2);
//		panMySQL.add(b0);
		
		this.getContentPane().add(panMySQL);
		
		this.setVisible(true);
	}
}
