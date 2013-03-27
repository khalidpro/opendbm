package View;

import javax.swing.JFrame;

public class DataBaseManager extends JFrame {

	public DataBaseManager() {
		this.setTitle("Open DBM 1.0");
		this.setSize(getToolkit().getScreenSize()); // plien ecran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new Menu());
		this.setVisible(true);
	}
}
