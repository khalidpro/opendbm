package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class DataBaseExplorer extends JPanel{
	JTree exprorateur=new JTree();
	private DefaultTreeCellRenderer treeModel = new  DefaultTreeCellRenderer();
	public DataBaseExplorer()
	{
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(250,500));
		this.setBorder(BorderFactory.createTitledBorder("Explorateur BD:"));
		
		this.treeModel.setClosedIcon(new ImageIcon("images/table.png"));
		this.treeModel.setOpenIcon(new ImageIcon("images/table.png"));
		this.treeModel.setLeafIcon(new ImageIcon("images/field.png"));
				 
		
		exprorateur.setCellRenderer(this.treeModel);
		
		exprorateur.setPreferredSize(new Dimension(240,500));
		this.add(exprorateur,BorderLayout.WEST);
		
	}
}
