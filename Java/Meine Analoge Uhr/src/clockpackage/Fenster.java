package clockpackage;

import javax.swing.JFrame;


public class Fenster extends JFrame
{	
	
	public Fenster()
	{		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Meine Analoge Uhr");
		add(new Uhr());
		setSize(435,460);
		setResizable(false);
		setLocationRelativeTo(null);

		setVisible(true);
	}
}
