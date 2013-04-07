package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame{

	public Splash()
	{
		this.setTitle("OpenDBM");
		this.setSize(600, 400);
		this.setResizable(false);
		this.setUndecorated(true); //  enlever la barre de titre 
		this.setLocationRelativeTo(null);
		this.setContentPane(new JLabel(new ImageIcon("images/background.png")));
		this.setVisible(true);
	}
}