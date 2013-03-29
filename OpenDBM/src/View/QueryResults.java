package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;

public class QueryResults extends JPanel{
	
	JTable datagrid=new JTable(10,10);
	public QueryResults()
	{
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(100,300));
		this.setBorder(BorderFactory.createTitledBorder("Resultat de la requete"));
		this.add(datagrid,BorderLayout.CENTER);
	}
}
