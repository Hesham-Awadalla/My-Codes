package modul2;

import javax.swing.JOptionPane;

abstract class VernamChiffrriere
{
	private static String Klartext;
	private static String Schluesselwort;
	private static String Geheimtext;
	private static int ASCIIWert;
		
	public static String Chiffriere()
	
	{
		Klartext = JOptionPane.showInputDialog("Bitte den Klartext eingeben:");
		
		Schluesselwort = JOptionPane.showInputDialog("Bitte das Schl�sselwort eingeben:");
		
		Geheimtext = "";
		
		if (Klartext.length() == Schluesselwort.length())
			{
				for (int i = 0; i < Klartext.length(); i++)
					{
						ASCIIWert = ((int)Klartext.charAt(i) + (int)Schluesselwort.charAt(i))%256;
						Geheimtext += (char)ASCIIWert;
					}
			}
		
		return Geheimtext;
	}
	
}
