package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarre extends JToolBar{

	JButton ouvrir=new JButton(new ImageIcon("images/open.png"));
	JButton enregistre=new JButton(new ImageIcon("images/save.png"));
	
	public ToolBarre()
	{
		this.add(ouvrir);
		this.add(enregistre);
		
	}
}
