package View;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QueryEditor extends JPanel {
	JTextArea editeur = new JTextArea();
	JScrollPane scroll = new JScrollPane(editeur);

	public QueryEditor() {
		this.setLayout(new BorderLayout());
		Font font = new Font("Arial", 0, 14);
		editeur.setFont(font);
		this.setBorder(BorderFactory.createTitledBorder("Editeur de requête:"));
		this.add(scroll, BorderLayout.CENTER);

	}
}
