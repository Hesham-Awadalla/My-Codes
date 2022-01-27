package vererbpackage;

import javax.swing.JOptionPane;

public class Manager extends Mitarbeiter
{

	private float Grundgehalt, ProzentProvision;
	
	public Manager() {}
	
	public Manager(String vname, String nname, int persnr, float GGehalt, float Provision)
	{
		super(vname, nname, persnr);
		Grundgehalt = GGehalt;
		ProzentProvision = Provision;
	}
	
	public float Grundgehalt()
	{
		Grundgehalt = Float.parseFloat(JOptionPane.showInputDialog("Bitte geben Sie das Grundgehalt ein:"));
		
		return Grundgehalt;
	}
	
	public float Provision()
	{
		ProzentProvision = Float.parseFloat(JOptionPane.showInputDialog("Bitte geben Sie die prozentuale Provision (abhängig vom Umsatz) ein:"));
		
		return ProzentProvision;
	}
	
	public void Einlesen()
	{
		super.Einlesen();
		Grundgehalt();
		Provision();
	}
	
	public String Ausgabe()
	{
		Mitarbeitertyp = "Manager";
		Append = "\nBrutto-Grundgehalt = "+Grundgehalt+" EUR\nProzentuale Provision = "+ProzentProvision+"%";
		super.Ausgabe();
		return Ausgabe;
	}
	
	public void showData()
	{
		Ausgabe();
		super.showData();
	}
}
