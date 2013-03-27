package View;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
	JMenu fichier=new JMenu("Fichier");
	
	JMenuItem quitter=new JMenuItem("Quitter");
	
	public Menu() {
		fichier.add(quitter);
		this.add(fichier);
	}
}
