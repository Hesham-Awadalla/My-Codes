package hauptpackage;
import toolspackage.MitarbeiterTools;

public class MitarbeiterTest
{

	public static void main(String[] args) throws InterruptedException
	{
		
		MitarbeiterTools.Ausgabe(MitarbeiterTools.Eingabe());
		Thread.sleep(500);
		MitarbeiterTools.MitarbeiterfeldEingabe();
		MitarbeiterTools.MitarbeiterfeldAusgabe();
	}

}
