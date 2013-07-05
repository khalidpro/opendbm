package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import Drivers.Access;
import Drivers.IDriver;
import Drivers.Manager;
import Drivers.MySQL;
import Drivers.Oracle;
import Drivers.SQLServer;
import Schema.Column;
import Schema.DataBase;
import Schema.Table;

public class Connexion extends JFrame {

	String[] base = { "MySQL", "Oracle", "SQL Server", "Access" };
	JComboBox liste_db = new JComboBox(base);
	JLabel type = new JLabel("Type de base de donnÃ©e :");

	JButton con = new JButton("Connexion");

	JTextField txtServer, txtPort, txtUser, txtPassword, txtDatabase, txtPath;

	JPanel panMySQL_Oracle = new JPanel();
	JPanel panOracle = new JPanel();
	JPanel panSQLServer = new JPanel();
	JPanel panAccess = new JPanel();
	JPanel panCenter = new JPanel();

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
		this.getContentPane().add(panCenter, BorderLayout.CENTER);
		panelMySQL_Oracle();
		liste_db.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String value = (String) liste_db.getSelectedItem();
				panCenter.removeAll();
				panMySQL_Oracle.removeAll();
				panAccess.removeAll();
				validate();
				if (value == "MySQL" || value == "Oracle") {
					panelMySQL_Oracle();
				} else if (value == "SQL Server") {

				} else if (value == "Access") {
					panelAccess();
				}
				pack();
				validate();
			}
		});

		this.getContentPane().add(con, BorderLayout.SOUTH);
		con.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = (String) liste_db.getSelectedItem();
				IDriver driver = null;
				if (value == "MySQL") {
					driver = new MySQL(txtServer.getText(), Integer
							.parseInt(txtPort.getText()), txtUser.getText(),
							txtPassword.getText(), txtDatabase.getText());
				} else if (value == "SQL Server") {
					driver = new SQLServer();
				} else if (value == "Access") {
					driver = new Access();
				} else if (value == "Oracle") {
					driver = new Oracle();
				}
				Manager m = new Manager(driver);
				DataBaseManager.db = m.getSchema();
				DataBaseManager.databaseExplorer
						.CreateDatabaseTree(DataBaseManager.db);
				dispose();
			}
		});

		this.pack();
		this.setVisible(true);
	}

	private void panelMySQL_Oracle() {
		txtServer = new JTextField("localhost");
		txtPort = new JTextField("3306");
		txtUser = new JTextField("root");
		txtPassword = new JTextField("");
		txtDatabase = new JTextField("test");

		JLabel lblServer = new JLabel("Serveur :");
		JLabel lblPort = new JLabel("Port  :");
		JLabel lblUser = new JLabel("Utilisateur :");
		JLabel lblPassword = new JLabel("Mot de passe :");
		JLabel lblDatabase = new JLabel("Base de donnÃ©e :");

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

		panMySQL_Oracle.add(b0);
		panMySQL_Oracle.setBorder(BorderFactory.createTitledBorder("MySQL"));
		this.panCenter.add(panMySQL_Oracle);
	}

	private void panelAccess() {
		txtPath = new JTextField("");
		txtUser = new JTextField("");
		txtPassword = new JTextField("");

		JLabel lblPath = new JLabel("Path :");
		JLabel lblUser = new JLabel("Utilisateur :");
		JLabel lblPassword = new JLabel("Mot de passe :");

		// Parcourir ==========================================
		JButton btParcourir = new JButton("Parcourir");
		btParcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FileFilter mdb = new FiltreSimple("Fichiers Access 2003",
						".mdb");
				FileFilter accdb = new FiltreSimple(
						"Fichiers Access 2007/2010", ".accdb");
				JFileChooser dialogue = new JFileChooser();
				dialogue.addChoosableFileFilter(mdb);
				dialogue.addChoosableFileFilter(accdb);
				dialogue.showOpenDialog(null);
				txtPath.setText(dialogue.getSelectedFile().toString());
			}
		});
		Dimension d = new Dimension(100, 28);

		lblPath.setPreferredSize(d);
		lblUser.setPreferredSize(d);
		lblPassword.setPreferredSize(d);

		Dimension d2 = new Dimension(200, 28);
		txtPath.setPreferredSize(new Dimension(140, 28));
		txtUser.setPreferredSize(d2);
		txtPassword.setPreferredSize(d2);
		Box b0 = Box.createVerticalBox();

		Box b1 = Box.createHorizontalBox();
		b1.add(lblPath);
		b1.add(txtPath);
		b1.add(btParcourir);

		Box b2 = Box.createHorizontalBox();
		b2.add(lblUser);
		b2.add(txtUser);

		Box b3 = Box.createHorizontalBox();
		b3.add(lblPassword);
		b3.add(txtPassword);

		b0.add(b1);
		b0.add(b2);
		b0.add(b3);

		panAccess.add(b0);
		panAccess.setBorder(BorderFactory.createTitledBorder("Ms Access"));
		this.panCenter.add(panAccess);
	}

}
