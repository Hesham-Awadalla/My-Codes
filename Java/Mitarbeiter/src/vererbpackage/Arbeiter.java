package vererbpackage;

import javax.swing.JOptionPane;

public class Arbeiter extends Mitarbeiter
{

	private float WochenStdZahl, Stundenlohn, Monatslohn;
	
	
	public Arbeiter() {}
	
	public Arbeiter(String vname, String nname, int persnr, float WStdZahl, float StdLohn)
	{
		super(vname, nname, persnr);
		WochenStdZahl = WStdZahl;
		Stundenlohn = StdLohn;
	}

	public float Wochenstundenzahl()
	{
		WochenStdZahl = Float.parseFloat(JOptionPane.showInputDialog("Bitte geben Sie die Wochenstundenzahl ein:"));
		return WochenStdZahl;
	}
	
	public float Stundenlohn()
	{
		Stundenlohn = Float.parseFloat(JOptionPane.showInputDialog("Bitte geben Sie den Stundenlohn ein:"));
		return Stundenlohn;
	}
	
	public float Monatslohn()
	{
		Monatslohn = 4 * WochenStdZahl * Stundenlohn;
		return Monatslohn;
	}
	
	public void Einlesen()
	{
		super.Einlesen();
		Wochenstundenzahl();
		Stundenlohn();
	}
	
	public String Ausgabe()
	{
		Monatslohn();
		Mitarbeitertyp = "Arbeiter";
		Append = "\nStundenlohn = "+Stundenlohn+" EUR\nWochenstundenzahl = "+WochenStdZahl+" Std.\\Woche\nBrutto-Monatslohn = "+Monatslohn+" EUR";
		super.Ausgabe();
		return Ausgabe;
	}
	
	public void showData()
	{		
		Ausgabe();
		super.showData();
	}
	
}
