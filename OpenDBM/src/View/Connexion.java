package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
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
		this.setSize(350, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Connexion");
		
		////////////////////////////////////////////////////////////////////////////
		
		JPanel pan=new JPanel();
		pan.setPreferredSize(new Dimension(50,50));
		pan.add(type);
		pan.add(liste_db);
		this.getContentPane().add(pan,BorderLayout.NORTH);
		
		Dimension d=new Dimension(120, 28);
		
		lblServer.setPreferredSize(d);
		lblPort.setPreferredSize(d);
		lblUser.setPreferredSize(d);
		lblPassword.setPreferredSize(d);
		
		Dimension d2=new Dimension(200, 28);
		server.setPreferredSize(d2);
		port.setPreferredSize(d2);
		user.setPreferredSize(d2);
		password.setPreferredSize(d2);
		
		Box b0=Box.createVerticalBox();
		
		Box b1=Box.createHorizontalBox();
		b1.add(lblServer);
		b1.add(server);

		Box b2=Box.createHorizontalBox();
		b2.add(lblPort);
		b2.add(port);
		
		Box b3=Box.createHorizontalBox();
		b3.add(lblUser);
		b3.add(user);
		
		Box b4=Box.createHorizontalBox();
		b4.add(lblPassword);
		b4.add(password);
		
		b0.add(b1);
		b0.add(b2);
		b0.add(b3);
		b0.add(b4);
		
		panMySQL.add(b0);
		panMySQL.setBorder(BorderFactory.createTitledBorder("MySQL"));
		
		this.getContentPane().add(panMySQL,BorderLayout.CENTER);
		this.getContentPane().add(con,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
}
