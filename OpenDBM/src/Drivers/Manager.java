package Drivers;

import java.util.ArrayList;

import Schema.Column;
import Schema.DataBase;
import Schema.Row;
import Schema.Table;

public class Manager {
	private IDriver driver;

	public Manager(IDriver driver) {
		this.driver = driver;
	}

	public IDriver getDriver() {
		return driver;
	}

	public void setDriver(IDriver driver) {
		this.driver = driver;
	}

	public DataBase getSchema() {
		DataBase db = new DataBase(driver.getDatabaseName());
		driver.connection();
		for (Table tb : this.driver.getTables()) {
			db.addTable(tb);
			for (Column c : this.driver.getColumns(tb)) {
				tb.addColumns(c);
			}
		}
		driver.disconnect();
		return db;
	}
	public ArrayList<Row> getResultat(String query)
	{
		driver.connection();
		ArrayList<Row> r=this.driver.getResultat(query);
			
		driver.disconnect();
		return r;
	}
}
