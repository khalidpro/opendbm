package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DataBaseManager extends JFrame {

	public DataBaseManager() {
		this.setTitle("Open DBM 1.0");
		this.setSize(getToolkit().getScreenSize()); // plien ecran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new Menu());
		this.getContentPane().add(new ToolBarre(),BorderLayout.NORTH);
		this.getContentPane().add(new DataBaseExplorer(),BorderLayout.WEST);
		JPanel pan=new JPanel();
		pan.setLayout(new BorderLayout());		
		pan.add(new QueryEditor(),BorderLayout.CENTER);
		pan.add(new QueryResults(),BorderLayout.SOUTH);
		this.getContentPane().add(pan,BorderLayout.CENTER);
		this.setVisible(true);
		
		//////////////////////////////////////////////////////////////////////////////////////////
		Connexion c=new Connexion();
	}
}
