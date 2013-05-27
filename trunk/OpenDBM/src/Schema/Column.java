package Schema;

public class Column implements ISql {
	private String name;
	private String type;
	private boolean primaryKey = false;
	private boolean unique = false;
	private boolean notNull = false;
	private String foreignKey= "";

	public Column(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public boolean isNotNull() {
		return notNull;
	}

	public void setNotNull(boolean notNull) {
		this.notNull = notNull;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public String getSQL() {
		String str = "";
		str = this.name + " " + this.type;
		str = this.notNull ? str + " NOT NULL" : str;
		str = str + " ,";
		return str;
	}

}
