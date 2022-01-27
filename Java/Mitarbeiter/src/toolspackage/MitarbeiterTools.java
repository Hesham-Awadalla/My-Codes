package toolspackage;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import vererbpackage.*;

public abstract class MitarbeiterTools
{
	static JFrame jf = new JFrame();
	static Mitarbeiter[] Mitarbeiterfeld;
	private static int x;
	
	private static JTextArea textArea = new JTextArea();
	
	public static String Eingabe()
	{		
		String[] optionen = {"Arbeiter", "Angestellter", "Manager"};
		jf.setAlwaysOnTop(true);  //Setting JOptionPane always on top
        String wahl = (String) JOptionPane.showInputDialog(
                jf,
                "Welche Art von Mitarbeiter möchten Sie erstellen?",
                "Wählen Sie eine Option aus!",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionen,
                optionen[0]);
        
        return wahl;
	}
	
	public static void Ausgabe(String wahl)
	{
		switch(wahl)
		{
			case "Arbeiter":
				Arbeiter arb = new Arbeiter();
				arb.Einlesen();
				arb.showData();
				break;
				
			case "Angestellter":
				Angestellter ang = new Angestellter();
				ang.Einlesen();
				ang.showData();
				break;
			
			case "Manager":
				Manager man = new Manager();
				man.Einlesen();
				man.showData();
				break;
				
		}
		
	}
	
	public static Mitarbeiter[] MitarbeiterfeldEingabe()
	{

		x = Integer.parseInt(JOptionPane.showInputDialog("Wie viele Mitarbeiter möchten Sie eingeben?"));

		Mitarbeiterfeld = new Mitarbeiter[x];
		
		for (int i=0; i < x; i++)
		{			
			switch(Eingabe())
			{
				case "Arbeiter":
					Mitarbeiterfeld[i] = new Arbeiter();
					Mitarbeiterfeld[i].Einlesen();
					break;
					
				case "Angestellter":
					Mitarbeiterfeld[i] = new Angestellter();
					Mitarbeiterfeld[i].Einlesen();
					break;
				
				case "Manager":
					Mitarbeiterfeld[i] = new Manager();
					Mitarbeiterfeld[i].Einlesen();
					break;
					
				//default wäre hier unnötig (wegen Eingabe() gibt es keine ungültige Eingabe)
			}
						
		}
		
		return Mitarbeiterfeld;
	}
	
	public static void MitarbeiterfeldAusgabe()
	
	{
		textArea.append("Hier sind die Mitarbeiterdaten:\n");
		
		for (int i=0; i < x; i++)
		{			
			textArea.append("\n"+Mitarbeiterfeld[i].Ausgabe()+"\n");
		}
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true);
		
		scrollPane.setPreferredSize(new Dimension(250, 400));
		JOptionPane.showMessageDialog(null, scrollPane, "Die Mitarbeiterdaten", JOptionPane.INFORMATION_MESSAGE);

		
//		Oder aber so, falls jeder Mitarbeiter eine besondere showData??() hat, z.B.:	
//		if (Mitarbeiterfeld[i] instanceof Arbeiter)
//		{
//			((Arbeiter)Mitarbeiterfeld[i]).showDataAr();
//		}
//		else if (Mitarbeiterfeld[i] instanceof Angestellter)
//		{
//			((Angestellter)Mitarbeiterfeld[i]).showDataAn();
//		}
//		else		//also (Mitarbeiterfeld[i] instanceof Manager)
//		{
//			((Manager)Mitarbeiterfeld[i]).showDataMan();
//		}
		
		
	}
	
}
