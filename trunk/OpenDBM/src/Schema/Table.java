package Schema;

import java.util.ArrayList;

public class Table implements ISql{
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

		String str="CREATE TABLE '"+this.name+"' (\n";
		for(Column col:this.columns)
		{
			str=str+"\t"+col.getSQL()+"\n";		
		}
		str=str+"); \n";
		return str;
	}

}
