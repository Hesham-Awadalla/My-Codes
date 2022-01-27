package vererbpackage;

import javax.swing.JOptionPane;

public class Angestellter extends Mitarbeiter
{

	private float Monatsgehalt;
	
	public Angestellter() {}
	
	public Angestellter(String vname, String nname, int persnr, float Gehalt)
	{
		super(vname, nname, persnr);
		Monatsgehalt = Gehalt;
	}

	
	public float Monatsgehalt()
	{
		Monatsgehalt = Float.parseFloat(JOptionPane.showInputDialog("Bitte geben Sie das Monatsgehalt ein:"));
		
		return Monatsgehalt;
	}
	
	public void Einlesen()
	{
		super.Einlesen();
		Monatsgehalt();
	}
	
	public String Ausgabe()
	{
		Mitarbeitertyp = "Angestellter";
		Append = "\nBrutto-Monatsgehalt = "+Monatsgehalt+" EUR";
		super.Ausgabe();
		return Ausgabe;	
	}
	
	public void showData()
	{
		Ausgabe();
		super.showData();
	}
}
