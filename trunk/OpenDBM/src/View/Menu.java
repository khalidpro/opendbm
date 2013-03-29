package View;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
	
	// Menu fichier
	JMenu fichier = new JMenu("Fichier");

	JMenuItem ouvrir = new JMenuItem("Ouvrir");
	JMenuItem quitter = new JMenuItem("Quitter");
	JMenuItem enregistre = new JMenuItem("Enregistre");
	JMenuItem enregistreSous = new JMenuItem("Enregistre Sous");
	
	// Menu Edition
	JMenu edition = new JMenu("Edition");
	JMenu baseDeDonnee = new JMenu("Base de Donnée");
	JMenu aide = new JMenu("Aide");

	public Menu() {

		this.add(fichier);
		fichier.add(ouvrir);
		fichier.addSeparator();
		fichier.add(enregistre);
		fichier.add(enregistreSous);
		fichier.addSeparator();
		fichier.add(quitter);
		this.add(edition);
		this.add(baseDeDonnee);
		this.add(aide);

	}
}
