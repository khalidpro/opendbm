package Schema;

import java.util.ArrayList;

public class DataBase {
	private String name;
	private ArrayList<Table> tables = new ArrayList<Table>();

	public DataBase(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void addTable(Table table) {
		this.tables.add(table);
	}

	public String toString() {
		return this.name;
	}

}
