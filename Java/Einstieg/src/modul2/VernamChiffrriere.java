package modul2;

import javax.swing.JOptionPane;

abstract class VernamChiffrriere
{
	private static String Klartext;
	private static String Schl�sselwort;
	private static String Geheimtext;
	private static int ASCIIWert;
		
	public static String Chiffriere()
	
	{
		Klartext = JOptionPane.showInputDialog("Bitte den Klartext eingeben:");
		
		Schl�sselwort = JOptionPane.showInputDialog("Bitte das Schl�sselwort eingeben:");
		
		Geheimtext = "";
		
		if (Klartext.length() == Schl�sselwort.length())
			{
				for (int i = 0; i < Klartext.length(); i++)
					{
						ASCIIWert = ((int)Klartext.charAt(i) + (int)Schl�sselwort.charAt(i))%256;
						Geheimtext += (char)ASCIIWert;
					}
			}
		
		return Geheimtext;
	}
	
}
