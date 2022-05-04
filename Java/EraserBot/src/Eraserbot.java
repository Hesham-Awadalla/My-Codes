/* DTO Eraserbot 1.3 by Hesham Mohamed Awadalla Osman
 * 
 * This is a Java based application that can be used to
 * search for and delete old documents
 * according to specific criteria.
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
