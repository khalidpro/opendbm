package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class DataBaseManager extends JFrame {

	public DataBaseManager() {
		this.setTitle("Open DBM 1.0");
		this.setSize(getToolkit().getScreenSize()); // plien ecran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new Menu());
		this.getContentPane().add(new ToolBarre(),BorderLayout.NORTH);
		this.getContentPane().add(new DataBaseExplorer(),BorderLayout.WEST);
		this.setVisible(true);
	}
}
