package Schema;

import java.util.ArrayList;

public class DataBase implements ISql{
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
	
	public String getSQL() {
		String str="";
		str=str+"-------------------------------------------\n";
		str=str+"-- Base de données: `"+ this.name+ "`\n";
		str=str+"-------------------------------------------\n\n";
		for(Table tab:this.tables)
		{
			str=str+tab.getSQL()+"\n";		
		}
		return str;
	}

}
