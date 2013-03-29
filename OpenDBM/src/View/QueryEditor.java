package View;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class QueryEditor extends JPanel{
	JTextArea editeur=new JTextArea() ;
	JScrollPane scroll=new JScrollPane(editeur);
	
	public QueryEditor()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("Editeur de requête:"));
		this.add(scroll,BorderLayout.CENTER);
		
	}
}
