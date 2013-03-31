package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;


import Schema.Column;
import Schema.DataBase;
import Schema.Table;

public class DataBaseExplorer extends JPanel {

	private DefaultTreeCellRenderer style = new DefaultTreeCellRenderer();
	private DefaultTreeModel model;
	private DefaultMutableTreeNode root;
	JTree explorateur;

	public DataBaseExplorer() {
		this.setLayout(new BorderLayout());
		//this.setPreferredSize(new Dimension(250, 700));
		this.setBorder(BorderFactory.createTitledBorder("Explorateur BD:"));
		this.style.setClosedIcon(new ImageIcon("images/table.png"));
		this.style.setOpenIcon(new ImageIcon("images/table.png"));
		this.style.setLeafIcon(new ImageIcon("images/field.png"));
	}

	public void CreateDatabaseTree(DataBase database) {
		root = new DefaultMutableTreeNode(database.getName());
		for (Table table : database.getTables()) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(
					table.getName());
			System.out.println(table.getName());
			for (Column column : table.getColumns()) {
				DefaultMutableTreeNode subnode = new DefaultMutableTreeNode(
						column.getName());
				node.add(subnode);
			}
			root.add(node);
		}
		this.model = new DefaultTreeModel(root);
		explorateur = new JTree();
		explorateur.setModel(model);
		explorateur.setCellRenderer(this.style);
		model.reload();
		this.add(new JScrollPane(explorateur), BorderLayout.CENTER);
		model.reload();
		
	}
}
