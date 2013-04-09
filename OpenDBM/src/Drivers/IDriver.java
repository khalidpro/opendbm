package Drivers;

import java.util.ArrayList;
import Schema.Column;
import Schema.Table;

public interface IDriver {	
	public void connection();
	public void disconnect();
	public String getDatabaseName();
	public ArrayList<Table> getTables();
	public ArrayList<Column> getColumns(Table table);
}
