package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Drivers.MySQL;
import Schema.Column;
import Schema.DataBase;
import Schema.Table;

public class Connexion extends JFrame {

	String[] base = { "MySQL", "Oracle", "SQL Server", "Access" };
	JComboBox liste_db = new JComboBox(base);
	JLabel type = new JLabel("Type de base de donnée :");

	JTextField txtServer = new JTextField("localhost");
	JTextField txtPort = new JTextField("3306");
	JTextField txtUser = new JTextField("root");
	JTextField txtPassword = new JTextField("");
	JTextField txtDatabase = new JTextField("cabinet");

	JLabel lblServer = new JLabel("Serveur :");
	JLabel lblPort = new JLabel("Port  :");
	JLabel lblUser = new JLabel("Utilisateur :");
	JLabel lblPassword = new JLabel("Mot de passe :");
	JLabel lblDatabase = new JLabel("Base de donnée :");

	JButton con = new JButton("Connexion");

	JPanel panMySQL = new JPanel();
	JPanel panOracle = new JPanel();
	JPanel panSQLServer = new JPanel();
	JPanel panAccess = new JPanel();

	public Connexion() {
		this.setSize(350, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Connexion");
		JPanel pan = new JPanel();
		pan.setPreferredSize(new Dimension(50, 50));
		pan.add(type);
		pan.add(liste_db);
		this.getContentPane().add(pan, BorderLayout.NORTH);
		this.panelMySQL();
		this.getContentPane().add(con, BorderLayout.SOUTH);

		con.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DataBase db = new DataBase(txtDatabase.getText());			
				MySQL m = new MySQL(db.getName());
				m.connection();
				for (Table tb : m.getTables()) {
					
					db.addTable(tb);
					for (Column c : m.getColumns(tb)) {
						tb.addColumns(c);
					}
				}
				m.disconnect();
				DataBaseManager.db = db;
				DataBaseManager.databaseExplorer.CreateDatabaseTree(db);
				dispose();
			}
		});

		this.setVisible(true);
	}

	private void panelMySQL() {
		Dimension d = new Dimension(140, 28);

		lblServer.setPreferredSize(d);
		lblPort.setPreferredSize(d);
		lblUser.setPreferredSize(d);
		lblPassword.setPreferredSize(d);
		lblDatabase.setPreferredSize(d);

		Dimension d2 = new Dimension(200, 28);
		txtServer.setPreferredSize(d2);
		txtPort.setPreferredSize(d2);
		txtUser.setPreferredSize(d2);
		txtPassword.setPreferredSize(d2);
		txtDatabase.setPreferredSize(d2);

		Box b0 = Box.createVerticalBox();

		Box b1 = Box.createHorizontalBox();
		b1.add(lblServer);
		b1.add(txtServer);

		Box b2 = Box.createHorizontalBox();
		b2.add(lblPort);
		b2.add(txtPort);

		Box b3 = Box.createHorizontalBox();
		b3.add(lblUser);
		b3.add(txtUser);

		Box b4 = Box.createHorizontalBox();
		b4.add(lblPassword);
		b4.add(txtPassword);

		Box b5 = Box.createHorizontalBox();
		b5.add(lblDatabase);
		b5.add(txtDatabase);

		b0.add(b1);
		b0.add(b2);
		b0.add(b3);
		b0.add(b4);
		b0.add(b5);

		panMySQL.add(b0);
		panMySQL.setBorder(BorderFactory.createTitledBorder("MySQL"));

		this.getContentPane().add(panMySQL, BorderLayout.CENTER);
	}
}
