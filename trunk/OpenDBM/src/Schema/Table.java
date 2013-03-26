package Schema;

import java.util.ArrayList;

public class Table {
	private String name;
	private ArrayList<Column> columns = new ArrayList<Column>();

	public Table(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Column> getColumns() {
		return columns;
	}

	public void addColumns(Column column) {
		this.columns.add(column);
	}

	public String toString() {
		return this.name;
	}

}
