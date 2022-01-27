package vererbpackage;

import javax.swing.JOptionPane;

public abstract class Mitarbeiter
{
	
	private String Vorname, Name;
	static String Ausgabe;
	private int PersonalNr;
	String Mitarbeitertyp;
	String Append;
	
	public Mitarbeiter() {}  //Leerer Konstruktor
	
	public Mitarbeiter(String vname, String nname, int persnr)
	{
		Vorname = vname;
		Name = nname;
		PersonalNr = persnr;
	}
	
	public String Vorname()
	{
		Vorname = JOptionPane.showInputDialog("Bitte geben Sie den Vornamen ein:");
		return Vorname;
	}
	
	public String Name()
	{
		Name = JOptionPane.showInputDialog("Bitte geben Sie den Namen ein:");
		return Name;
	}
	
	public int Personalnummer()
	{
		PersonalNr = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die Personalnummer ein:"));
		return PersonalNr;
	}
	
	public void Einlesen()
	{
		Vorname();
		Name();
		Personalnummer();
	}
	
	//Diese Funktion ist hilfreich fürs JScrollPane >> textArea.append(Mitarbeiterfeld[i].Ausgabe()
	//Für eine einfache Konsolenausgabe sollte aber die Funktion showData() ausreichen (mit Anpassung)
	public String Ausgabe()
	{	
		Ausgabe = "Funktion: "+Mitarbeitertyp+"\nVorname: "+Vorname+"\nNachname: "+Name+"\nPersonalnummer: "+PersonalNr+Append;
		return Ausgabe;
	}
	
	public void showData()
	{	
		//Ausgabe = Mitarbeitertyp+"\nVorname: "+Vorname+"\nNachname: "+Name+"\nPersonalnummer: "+PersonalNr+Append;		
		JOptionPane.showMessageDialog(null, Ausgabe, "Mitarbeiterdaten", JOptionPane.INFORMATION_MESSAGE);		
	}
	
}