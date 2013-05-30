package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Drivers.Manager;
import Schema.DataBase;

public class DataBaseManager extends JFrame {

	public static DataBase db;
	public static Manager manager=null;
	public static ToolBarre toolBar = new ToolBarre();
	public static DataBaseExplorer databaseExplorer = new DataBaseExplorer();
	public static QueryEditor queryEditor =new QueryEditor();
	public static QueryResults queryResults =new QueryResults();
	
	public DataBaseManager() {
		this.setTitle("Open DBM 1.0");
		this.setExtendedState(this.MAXIMIZED_BOTH); // plien ecran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(getToolkit().getImage("images/icon.png"));
		this.setJMenuBar(new Menu());
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		this.getContentPane().add(databaseExplorer, BorderLayout.WEST);
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(queryEditor, BorderLayout.CENTER);
		pan.add(queryResults, BorderLayout.SOUTH);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		this.setVisible(true);

	}

}
