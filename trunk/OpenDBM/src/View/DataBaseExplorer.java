package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import Schema.Column;
import Schema.DataBase;
import Schema.Table;

public class DataBaseExplorer extends JPanel {

	private DefaultTreeCellRenderer treeModel = new DefaultTreeCellRenderer();
	private DefaultMutableTreeNode root;
	JTree exprorateur;

	public DataBaseExplorer() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(250, 500));
		this.setBorder(BorderFactory.createTitledBorder("Explorateur BD:"));

		this.treeModel.setClosedIcon(new ImageIcon("images/table.png"));
		this.treeModel.setOpenIcon(new ImageIcon("images/table.png"));
		this.treeModel.setLeafIcon(new ImageIcon("images/field.png"));

	}

	public void CreateDatabaseTree(DataBase database) {
		root = new DefaultMutableTreeNode(database.getName());
		for (Table table : database.getTables()) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(
					table.getName());
			root.add(node);
			for (Column colum : table.getColumns()) {
				DefaultMutableTreeNode subnode = new DefaultMutableTreeNode(
						colum.getName());
				node.add(subnode);
			}
		}
		exprorateur = new JTree(root);
		exprorateur.setRootVisible(false);
		exprorateur.setCellRenderer(this.treeModel);
		this.add(exprorateur, BorderLayout.WEST);

	}
}
