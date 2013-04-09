package Drivers;

import Schema.Column;
import Schema.DataBase;
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
		MySQL m = new MySQL(db.getName());
		m.connection();
		for (Table tb : this.driver.getTables()) {
			db.addTable(tb);
			for (Column c : this.driver.getColumns(tb)) {
				tb.addColumns(c);
			}
		}
		m.disconnect();
		return db;
	}
}
