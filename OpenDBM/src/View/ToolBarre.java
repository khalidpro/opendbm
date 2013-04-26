package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarre extends JToolBar {

	JButton nouveau = new JButton(new ImageIcon("images/file_new.png"));
	JButton enregistre = new JButton(new ImageIcon("images/save.png"));
	JButton connexion = new JButton(new ImageIcon("images/connect.png"));
	JButton sql = new JButton("SQL");
	JButton xml = new JButton("XML");

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
				DataBaseManager.queryEditor.editeur.setText(DataBaseManager.db.getSQL());
			}
		});
		this.add(xml);
	}
}
