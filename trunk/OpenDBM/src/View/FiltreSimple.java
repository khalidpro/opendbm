package View;

import java.io.File;

import javax.swing.filechooser.FileFilter;

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