package modul2;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Kreis
{
	private float Radius, Area, Umfang;
	private String Ausgabe;
	private DecimalFormat df = new DecimalFormat("#.##");
	
	public Kreis()  //Leerer Konstruktor
	{
		
	}
	
	public float Radius()
	{
		Radius = Float.parseFloat(JOptionPane.showInputDialog("Bitte geben Sie den Radius ein!").replace(",","."));
		return Radius;
	}
	
	public void Kreisflaeche()
	{
		Area = (float)(Math.PI * Radius * Radius);
		Ausgabe = "Die Kreisfläche = "+df.format(Area)+" Flächeneinheit";
		JOptionPane.showMessageDialog(null, Ausgabe, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void Kreisumfang()
	{
		Umfang = (float)(2 * Math.PI * Radius);
		Ausgabe = "Der Kreisumfang = "+df.format(Umfang)+" Längeneinheit";
		JOptionPane.showMessageDialog(null, Ausgabe, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
	}

}
