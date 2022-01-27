package modul1;
import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Person {
	
	private JTextArea textArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane();
	private String Vorname, Nachname, Ausgabe;
	private int Alter;
	private int x;  //Anzahl der Personen ( = PersArray.Length)
	Person[] PersArray;
	
	Scanner Eingabe;
	JFrame jf = new JFrame();

	public Person[] ArrayErzeugen() throws InterruptedException {

		x = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie die Anzahl der Personen ein!"));

		PersArray = new Person[x];
		for (int i=0; i < x; i++)	//oder i<PersArray.length
		{
			PersArray[i] = new Person();
			PersArray[i].Vorname = JOptionPane.showInputDialog("Wie ist der Vorname der "+(i+1)+". Person?");
			PersArray[i].Nachname = JOptionPane.showInputDialog("Und ihr Nachname?");
			PersArray[i].Alter = Integer.parseInt(JOptionPane.showInputDialog("Und wie alt ist er/sie?"));
			Thread.sleep(500);
		}
		return PersArray;
	}
	
	public void MaxAlter()
	{			
		int MaxAge = 0;
		int j = 0; //Zähler
		for (int i=0; i < x; i++)
		{
			if (PersArray[i].Alter > MaxAge)
			{
			MaxAge = PersArray[i].Alter;
			j = i;
			}
		}
		Ausgabe = "Die "+(j+1)+". Person Namens "+PersArray[j].Vorname+" "
				+PersArray[j].Nachname+" ist mit "+MaxAge+" Jahre alt am ältesten.";
		JOptionPane.showMessageDialog(null, Ausgabe, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String Auswahlmenu1()
	{
		
		String[] optionen = {"Vorname", "Nachname"};
		jf.setAlwaysOnTop(true);  //Setting JOptionPane always on top
        String wahl = (String) JOptionPane.showInputDialog(
                jf,
                "Möchten Sie nach Vor- oder Nachnamen suchen?",
                "Wählen Sie eine Option aus!",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionen,
                optionen[0]);
        return wahl;
	}
	
	public void Personensuche(String wahl1)
	{
		String Namegesucht = JOptionPane.showInputDialog("Bitte geben Sie dann einen "+wahl1+"n ein!");
		
		int f = 0;  //found Zähler
		for (int i = 0; i < x; i++)
		{
			if (wahl1 == "Vorname" && PersArray[i].Vorname.compareToIgnoreCase(Namegesucht) == 0)
			{	//.equalsIgnoreCase(Namegesucht) geht auch
				f = i + 1;  //Denn i fängt bei 0 an!
				break;
			}
			else if(wahl1 == "Nachname" && PersArray[i].Nachname.compareToIgnoreCase(Namegesucht) == 0)
			{
				f = i + 1;
				break;
			}
		}
		
		if (f > 0)
		{
			Ausgabe = "\nHier ist die gesuchte Person:\nVorname: "+PersArray[f-1].Vorname+"\nNachname: "
				+PersArray[f-1].Nachname+"\nAlter: "+PersArray[f-1].Alter+" Jahre alt";
			JOptionPane.showMessageDialog(null, Ausgabe, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			Ausgabe = "Es gibt keine Person mit dem "+wahl1+"n "+Namegesucht+" hinterlegt!";
			JOptionPane.showMessageDialog(null, Ausgabe, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public String Auswahlmenu2()
	{
		String[] optionen = {"Alter", "Vorname", "Nachname"};
		jf.setAlwaysOnTop(true);
        String wahl = (String) JOptionPane.showInputDialog(
                jf,
                "Wonach möchten Sie die Personen sortieren?",
                "Wählen Sie eine Option aus!",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionen,
                optionen[0]);
        return wahl;
	}
	
	public Person[] altersortieren()
	{
	
		Person speicher =  new Person();
		
		for (int z = x-1; z > 0; z--) 
		{
			for (int i = 0; i < z; i++)
			{  //i < z (i und z treffen sich dann)
				if(PersArray[i].Alter > PersArray[i+1].Alter)
				{
					speicher = PersArray[i+1];
					PersArray[i+1] = PersArray[i];
					PersArray[i] = speicher;
				}
			}
		}
		return PersArray;
	}
	
	public Person[] vornamensortieren()
	{		
		Person speicher =  new Person();
		
		for (int z = x-1; z > 0; z--)
		{
			for (int i = 0; i < z; i++)
			{
				if(PersArray[i+1].Vorname.compareToIgnoreCase(PersArray[i].Vorname) < 0)
				{
					speicher = PersArray[i+1];
					PersArray[i+1] = PersArray[i];
					PersArray[i] = speicher;
				}
			}
		}
		return PersArray;
	}
	
	public Person[] nachnamensortieren()
	{		
		Person speicher =  new Person();
		
		for (int z = x-1; z > 0; z--)
		{
			for (int i = 0; i < z; i++)
			{
				if(PersArray[i+1].Nachname.compareToIgnoreCase(PersArray[i].Nachname) < 0)
				{
					speicher = PersArray[i+1];
					PersArray[i+1] = PersArray[i];
					PersArray[i] = speicher;
				}
			}
		}
		return PersArray;
	}
	
	public void Bubblesort(String wahl2)
	{
		scrollPane.setPreferredSize(new Dimension(250, 500));
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true);
		
		if (wahl2 == "Alter")
		{
			altersortieren();
			textArea.append("Hier sind die Personen nach Alter aufsteigend sortiert:\n");
			for (int i = 0; i < x; i++)
			{
				Ausgabe = "\nVorname: "+PersArray[i].Vorname+"\nNachname: "
						+PersArray[i].Nachname+"\nAlter: "+PersArray[i].Alter+" Jahre alt";
				textArea.append(Ausgabe+"\n");
			}
			scrollPane = new JScrollPane(textArea);
			JOptionPane.showMessageDialog(null, scrollPane, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if (wahl2 == "Vorname")
		{
			vornamensortieren();
			textArea.append("Hier sind die Personen nach Vornamen alphabetisch aufsteigend sortiert:\n");
			for (int i = 0; i < x; i++)
			{
				Ausgabe = "\nVorname: "+PersArray[i].Vorname+"\nNachname: "
						+PersArray[i].Nachname+"\nAlter: "+PersArray[i].Alter+" Jahre alt";
				textArea.append(Ausgabe+"\n");
			}
			scrollPane = new JScrollPane(textArea);
			JOptionPane.showMessageDialog(null, scrollPane, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else
		{
			nachnamensortieren();
			textArea.append("Hier sind die Personen nach Nachnamen alphabetisch aufsteigend sortiert:\n");
			for (int i = 0; i < x; i++)
			{
			Ausgabe = "\nVorname: "+PersArray[i].Vorname+"\nNachname: "
					+PersArray[i].Nachname+"\nAlter: "+PersArray[i].Alter+" Jahre alt";
			textArea.append(Ausgabe+"\n");
			}
			scrollPane = new JScrollPane(textArea);
			JOptionPane.showMessageDialog(null, scrollPane, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
		}
	}	
	
	public static void main(String[] args) throws InterruptedException
	{		
		Person pers = new Person();
		pers.ArrayErzeugen();
		pers.MaxAlter();
		Thread.sleep(700);
		
		String wahl1 = pers.Auswahlmenu1();
		pers.Personensuche(wahl1);
		
		Thread.sleep(700);
		String wahl2 = pers.Auswahlmenu2();
		
		pers.Bubblesort(wahl2);
		System.exit(0);			
	}
}

