package Schema;

import java.util.ArrayList;

public class Table implements ISql {
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

	public String getSQL() {

		String str = "CREATE TABLE " + this.name + " (\n";
		String str_pk = "";
		for (Column col : this.columns) {
			str = str + "\t" + col.getSQL() + "\n";

			if (col.isPrimaryKey()) {
				str_pk = str_pk == "" ? col.getName() : str_pk + ", "
						+ col.getName();
				System.out.println(col.getName());
			}
		}
		str = str_pk == "" ? str : str + "\n\tCONSTRAINT pk_" + this.name
				+ "ID PRIMARY KEY (" + str_pk + ")";
		str = str + "\n); \n";
		return str;
	}

}
