package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

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

import Drivers.MySQL;
import Schema.Column;
import Schema.DataBase;
import Schema.Table;

public class Connexion extends JFrame {

	String[] base = { "MySQL", "Oracle", "SQL Server", "Access" };
	JComboBox liste_db = new JComboBox(base);
	JLabel type = new JLabel("Type de base de donnée :");

	JButton con = new JButton("Connexion");
	JTextField txtPath = new JTextField("");
	
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

				}  else if (value == "Access") {
					panelAccess();
				}
				pack();
				validate();
			}
		});

		this.getContentPane().add(con, BorderLayout.SOUTH);
		// con.addActionListener(new ActionListener() {

		// public void actionPerformed(ActionEvent e) {
		// DataBase db = new DataBase(txtDatabase.getText());
		// MySQL m = new MySQL(db.getName());
		// m.connection();
		// for (Table tb : m.getTables()) {
		//
		// db.addTable(tb);
		// for (Column c : m.getColumns(tb)) {
		// tb.addColumns(c);
		// }
		// }
		// m.disconnect();
		// DataBaseManager.db = db;
		// DataBaseManager.databaseExplorer.CreateDatabaseTree(db);
		// dispose();
		// }
		// });

		this.pack();
		this.setVisible(true);
	}

	private void panelMySQL_Oracle() {
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

		
		JTextField txtUser = new JTextField("");
		JTextField txtPassword = new JTextField("");

		JLabel lblPath = new JLabel("Path :");
		JLabel lblUser = new JLabel("Utilisateur :");
		JLabel lblPassword = new JLabel("Mot de passe :");

		JButton btParcourir = new JButton("Parcourir");
		btParcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FileFilter mdb = new FiltreSimple("Fichiers Access 2003", ".mdb");
				FileFilter accdb = new FiltreSimple("Fichiers Access 2007/2010", ".accdb");
				JFileChooser dialogue = new JFileChooser();
				dialogue.addChoosableFileFilter(mdb);
				dialogue.addChoosableFileFilter(accdb);
				dialogue.showOpenDialog(null);
				txtPath.setText( dialogue.getSelectedFile().toString());
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

	// ///////////////////////////////////////Filter de la boite de
	// dialogue/////////////////////////////////////////////////////////////////////

	public class FiltreSimple extends FileFilter {
		// Description et extension acceptée par le filtre
		private String description;
		private String extension;

		// Constructeur à partir de la description et de l'extension acceptée
		public FiltreSimple(String description, String extension) {
			if (description == null || extension == null) {
				throw new NullPointerException(
						"La description (ou extension) ne peut être null.");
			}
			this.description = description;
			this.extension = extension;
		}

		public String getDescription() {
			return description;
		}

		public boolean accept(File arg0) {
			if (arg0.isDirectory()) {
				return true;
			}
			String nomFichier = arg0.getName().toLowerCase();

			return nomFichier.endsWith(extension);
		}
	}
}