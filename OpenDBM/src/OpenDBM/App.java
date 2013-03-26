package OpenDBM;

import Drivers.MySQL;
import Schema.Column;
import Schema.Table;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MySQL m = new MySQL("cabinet");
		m.connection();
		for (Table tb : m.getTables()) {
			System.out.println(tb.toString());
			for (Column c : m.getColumns(tb)) {
				System.out.println("\t" + c.getName() + " : " + c.getType());
			}
		}
		m.disconnect();
	}

}