package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

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
		// Ouvrir =======================================
		ouvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String path = "";
				FileFilter sql = new FiltreSimple("Fichiers SQL", ".sql");
				FileFilter xml = new FiltreSimple("Fichiers XML", ".xml");
				FileFilter txt = new FiltreSimple("Fichiers Texte", ".txt");
				JFileChooser dialogue = new JFileChooser();
				dialogue.addChoosableFileFilter(xml);
				dialogue.addChoosableFileFilter(txt);
				dialogue.addChoosableFileFilter(sql);
				dialogue.showOpenDialog(null);

				path = dialogue.getSelectedFile().toString();

				FileInputStream fis;
				BufferedInputStream bis;
				FileChannel fc;

				try {

					fis = new FileInputStream(new File(path));
					// On récupère le canal
					fc = fis.getChannel();
					// On en déduit la taille
					int size = (int) fc.size();
					// On crée un buffer correspondant à la taille du fichier
					ByteBuffer bBuff = ByteBuffer.allocate(size);
					// Démarrage de la lecture
					fc.read(bBuff);
					// On prépare à la lecture avec l'appel à flip
					bBuff.flip();
					// Puisque nous avons utilisé un buffer de byte afin de
					// récupérer les données
					// Nous pouvons utiliser un tableau de byte
					// La méthode array retourne un tableau de byte
					String str = new String(bBuff.array(), "UTF-8");

					DataBaseManager.queryEditor.editeur.setText(str);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

	}
}
