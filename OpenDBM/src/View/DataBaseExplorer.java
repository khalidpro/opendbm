package View;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTree;

public class DataBaseExplorer extends JPanel{
	JTree exprorateur=new JTree();
	public DataBaseExplorer()
	{
		this.setBorder(BorderFactory.createTitledBorder("Explorateur de base de donnée :"));
		this.add(exprorateur);
	}
}
