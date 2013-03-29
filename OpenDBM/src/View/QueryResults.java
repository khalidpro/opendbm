package View;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class QueryResults extends JPanel{

	public QueryResults()
	{
		this.setPreferredSize(new Dimension(100,300));
		this.setBorder(BorderFactory.createTitledBorder("Resultat de la requete"));
	}
}
