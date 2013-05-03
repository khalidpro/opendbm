package Schema;

import java.util.ArrayList;

public class Row {
	private ArrayList<Field> Fields = new ArrayList<Field>();

	public void addField(String name, String value) {
		Fields.add(new Field(name, value));
	}
	public int getFieldsCount()
	{
		return Fields.size();
	}
	class Field {
		private String name;
		private String value;

		public Field(String name, String value) {
			super();
			this.name = name;
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}
}
