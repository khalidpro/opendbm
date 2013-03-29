package View;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class QueryEditor extends JPanel{
	JTextArea editeur=new JTextArea() {
	};
	
	public QueryEditor()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("Editeur de requête:"));
		this.add(editeur,BorderLayout.CENTER);
		
	}
}
