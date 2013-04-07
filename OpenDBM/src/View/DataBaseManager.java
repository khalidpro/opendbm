package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Schema.DataBase;

public class DataBaseManager extends JFrame implements ActionListener {

	public static DataBase db;
	public static ToolBarre toolBar = new ToolBarre();
	public static DataBaseExplorer databaseExplorer = new DataBaseExplorer();

	public DataBaseManager() {
 
		this.setTitle("Open DBM 1.0");
		this.setSize(getToolkit().getScreenSize()); // plien ecran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new Menu());
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		this.getContentPane().add(databaseExplorer, BorderLayout.WEST);
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.add(new QueryEditor(), BorderLayout.CENTER);
		pan.add(new QueryResults(), BorderLayout.SOUTH);
		this.getContentPane().add(pan, BorderLayout.CENTER);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println(e.getSource());
	}
}