package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTree;

public class DataBaseExplorer extends JPanel{
	JTree exprorateur=new JTree();
	public DataBaseExplorer()
	{
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(250,500));
		this.setBorder(BorderFactory.createTitledBorder("Explorateur BD:"));
		exprorateur.setPreferredSize(new Dimension(240,500));
		this.add(exprorateur,BorderLayout.WEST);
		
	}
}
