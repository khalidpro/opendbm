package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;

import Schema.Row;

public class QueryResults extends JPanel {

	JTable datagrid=new JTable();

	public QueryResults() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(100, 300));
		this.setBorder(BorderFactory
				.createTitledBorder("Resultat de la requete"));
		this.add(datagrid, BorderLayout.CENTER);
	}

	public void setResults(ArrayList<Row> rows) {
		if (rows.size() > 0) {
			
			String[] entetes = new String [rows.get(0).getFieldsCount()];
			for (int i=0;i<entetes.length; i++)
			{
				entetes[i]=rows.get(0).getFieldName(i);
			}
			
			String[][] donnees =new String[rows.size()][rows.get(0).getFieldsCount()];
			
			for (int i=0;i<rows.size(); i++)
			{
				
				for (int j=0;j<rows.get(0).getFieldsCount(); j++)
				{
					donnees[i][j]=rows.get(i).getFieldValue(j);

				}
			}
			this.removeAll();
			 datagrid = new JTable( donnees,entetes);
			
			this.setLayout(new BorderLayout());
			this.setPreferredSize(new Dimension(100, 300));
			this.setBorder(BorderFactory
					.createTitledBorder("Resultat de la requete"));
			this.add(datagrid, BorderLayout.CENTER);
			this.revalidate();
		}
	}
}
