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
			datagrid = new JTable(rows.get(0).getFieldsCount(), rows.size());
			
		}
	}
}
