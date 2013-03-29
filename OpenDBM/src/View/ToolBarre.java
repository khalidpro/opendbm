package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarre extends JToolBar{

	JButton nouveau=new JButton(new ImageIcon("images/file_new.png"));
	JButton enregistre=new JButton(new ImageIcon("images/save.png"));
	
	public ToolBarre()
	{
		this.add(nouveau);
		this.add(enregistre);
		
	}
}
