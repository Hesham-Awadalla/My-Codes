/* DTO Eraserbot 1.3 by Hesham Mohamed Awadalla Osman
 * 
 * Dies ist eine in der Programmiersprache Java geschriebene Applikation, die verwendet werden kann,
 * um nach Dateien - nach bestimmten Kriterien (Dateityp/-alter)- zu suchen,
 * die entsprechend in den Papierkorb geschoben bzw. endgültig gelöscht werden sollen.
 * 
 */

import java.awt.EventQueue;

public class Eraserbot
{
	//Die Main-Methode
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					GUI frame = new GUI();
					frame.setVisible(true);				
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});	
		
	}

}
