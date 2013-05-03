package Drivers;

import java.util.ArrayList;

import Schema.Column;
import Schema.Row;
import Schema.Table;

public class Oracle implements IDriver{

	@Override
	public void connection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDatabaseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Table> getTables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Column> getColumns(Table table) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Row> getResultat(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
