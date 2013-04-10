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
		this.setBorder(BorderFactory.createTitledBorder("Explorateur BD:"));
		this.style.setClosedIcon(new ImageIcon("images/table.png"));
		this.style.setOpenIcon(new ImageIcon("images/table.png"));
		this.style.setLeafIcon(new ImageIcon("images/field.png"));
		explorateur = new JTree();
		explorateur.setCellRenderer(this.style);
	}

	public void CreateDatabaseTree(DataBase database) {
		this.removeAll();
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
		explorateur.setModel(model);
		this.add(new JScrollPane(explorateur), BorderLayout.CENTER);
		model.reload(root);
		this.revalidate();

	}
}
