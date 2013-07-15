package Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

import Schema.Column;
import Schema.Row;
import Schema.Table;

public class MySQL implements IDriver {

	private String server;
	private int port;
	private String user;
	private String passWord;
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String DataBaseName;

	public MySQL(String server, int port, String user, String pw,
			String dataBaseName) {
		this.server = server;
		this.port = port;
		this.user = user;
		this.passWord = pw;
		this.DataBaseName = dataBaseName;
	}

	public void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + this.server + ":" + this.port + "/"
					+ this.DataBaseName;
			this.con = DriverManager.getConnection(url, this.user,
					this.passWord);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (!this.con.isClosed())
				this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Table> getTables() {
		ArrayList<Table> tables = new ArrayList<Table>();
		try {
			this.stmt = this.con.createStatement();
			rs = this.stmt.executeQuery("SHOW TABLES");
			while (rs.next()) {
				tables.add(new Table(rs.getString(1)));
			}
			this.stmt.close();
			this.rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tables;
	}

	public ArrayList<Column> getColumns(Table table) {
		ArrayList<Column> columns = new ArrayList<Column>();
		try {
			String requete = "SELECT DISTINCT  k.CONSTRAINT_SCHEMA, k.CONSTRAINT_NAME, k.TABLE_NAME, k.COLUMN_NAME , k.REFERENCED_TABLE_SCHEMA, k.REFERENCED_TABLE_NAME, k.REFERENCED_COLUMN_NAME, c.CONSTRAINT_TYPE FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS k INNER JOIN INFORMATION_SCHEMA.TABLE_CONSTRAINTS AS c ON k.CONSTRAINT_SCHEMA = c.CONSTRAINT_SCHEMA AND k.CONSTRAINT_NAME = c.CONSTRAINT_NAME WHERE k.TABLE_NAME='"
					+ table.getName()
					+ "' and k.CONSTRAINT_SCHEMA='"
					+ this.DataBaseName + "';";

			this.stmt = this.con.createStatement();
			rs = this.stmt
					.executeQuery("SHOW COLUMNS FROM " + table.toString());
			while (rs.next()) {
				Column col = new Column(rs.getString(1), rs.getString(2));
				columns.add(col);
			}

			// *********************************************************************************
			rs = this.stmt.executeQuery(requete);
			while (rs.next()) {
				for (int i = 0; i < columns.size(); i++) {
					if (columns.get(i).getName()
							.equals(rs.getString("COLUMN_NAME"))) {
						if (rs.getString("CONSTRAINT_TYPE").equals("UNIQUE")) {
							columns.get(i).setUnique(true);
						} else if (rs.getString("CONSTRAINT_TYPE").equals(
								"PRIMARY KEY")) {
							columns.get(i).setPrimaryKey(true);
						} else if (rs.getString("CONSTRAINT_TYPE").equals(
								"FOREIGN KEY")) {
							columns.get(i)
									.setForeignKey(
											rs.getString("REFERENCED_TABLE_NAME")
													+ " ("
													+ rs.getString("REFERENCED_COLUMN_NAME")
													+ ")");
						} else {

						}
					}
				}

			}

			this.stmt.close();
			this.rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columns;
	}

	public String getDatabaseName() {
		return this.DataBaseName;
	}

	@Override
	public ArrayList<Row> getResultat(String query) {
		System.out.println(query);
		ArrayList<Row> rows = new ArrayList<Row>();
		try {
			this.stmt = this.con.createStatement();
			rs = this.stmt.executeQuery(query);
			while (rs.next()) {
				Row r = new Row();
				ResultSetMetaData rsMetaData = (ResultSetMetaData) rs
						.getMetaData();
				int numberOfColumns = rsMetaData.getColumnCount();
				for (int i = 1; i < numberOfColumns + 1; i++) {
					String columnName = rsMetaData.getColumnName(i);
					r.addField(columnName, rs.getString(i));
				}
				rows.add(r);
			}
			this.stmt.close();
			this.rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}

}
