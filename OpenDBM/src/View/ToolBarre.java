package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.xml.crypto.Data;

import Schema.Row;

public class ToolBarre extends JToolBar {

	JButton nouveau = new JButton(new ImageIcon("images/file_new.png"));
	JButton enregistre = new JButton(new ImageIcon("images/save.png"));
	JButton connexion = new JButton(new ImageIcon("images/connect.png"));
	JButton executer = new JButton(new ImageIcon("images/executer.png"));
	JButton sql = new JButton("SQL");

	public ToolBarre() {
		this.add(connexion);
		this.add(nouveau);
		this.add(enregistre);

		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connexion c = new Connexion();
			}
		});

		this.add(sql);
		sql.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				DataBaseManager.queryEditor.editeur.setText(DataBaseManager.db
						.getSQL());
			}
		});

		this.add(executer);
		executer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DataBaseManager.queryResults.setResults(DataBaseManager.manager
						.getResultat(DataBaseManager.queryEditor
								.getEditeurText()));

			}
		});
	}
}
