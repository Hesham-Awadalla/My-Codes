package modul2;

import javax.swing.JOptionPane;

abstract class VernamChiffrriere
{
	private static String Klartext;
	private static String Schlüsselwort;
	private static String Geheimtext;
	private static int ASCIIWert;
		
	public static String Chiffriere()
	
	{
		Klartext = JOptionPane.showInputDialog("Bitte den Klartext eingeben:");
		
		Schlüsselwort = JOptionPane.showInputDialog("Bitte das Schlüsselwort eingeben:");
		
		Geheimtext = "";
		
		if (Klartext.length() == Schlüsselwort.length())
			{
				for (int i = 0; i < Klartext.length(); i++)
					{
						ASCIIWert = ((int)Klartext.charAt(i) + (int)Schlüsselwort.charAt(i))%256;
						Geheimtext += (char)ASCIIWert;
					}
			}
		
		return Geheimtext;
	}
	
}
