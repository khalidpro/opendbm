package Drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Schema.Column;
import Schema.Table;

public class MySQL implements IDriver {

	private String server = "localhost";
	private int port = 3306;
	private String user = "root";
	private String passWord = "";
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String DataBaseName;

	public MySQL(String dataBaseName) {
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
			ResultSet rs = this.stmt.executeQuery(" SHOW TABLES");
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
			this.stmt = this.con.createStatement();
			ResultSet rs = this.stmt.executeQuery("SHOW COLUMNS FROM "
					+ table.toString());
			while (rs.next()) {
				columns.add(new Column(rs.getString(1), rs.getString(2)));
			}
			this.stmt.close();
			this.rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columns;
	}

}
