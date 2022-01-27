package modul2;

import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Punkt
{
	private float x,y,Abstand;
	private Punkt[] Punktobjekten;
	private String Ausgabe;
	private JTextArea textArea = new JTextArea();
	private DecimalFormat df = new DecimalFormat("#.##");
	
	public Punkt()
	{
		
	}
	
	public Punkt(float xkoo, float ykoo)
	{
		x = xkoo;
		y = ykoo;
	}
	
	public float xkoord()
	{
		x = Float.parseFloat(JOptionPane.showInputDialog("Bitte geben Sie die x-Koordinate ein:").replace(",","."));
		return x;
	}
	
	public float ykoord()
	{
		y = Float.parseFloat(JOptionPane.showInputDialog("Bitte geben Sie die y-Koordinate ein:").replace(",","."));
		return y;
	}
	
	public void Abstand()
	{
		Abstand = (float)(Math.sqrt(x*x + y*y));
		Ausgabe = "Der Abstand des Punktes vom Koordinatenursprung = "+df.format(Abstand)+" Längeneinheit";
		JOptionPane.showMessageDialog(null, Ausgabe, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void Punktenfled()
	{
		Punktobjekten = new Punkt[100];
		float MaxAbstand = 0;
		int z = 0; //Zähler
		for (int i = 0; i < 100; i++)
		{
			Punktobjekten[i] = new Punkt();
			Punktobjekten[i].x = (int)(Math.random()*1000+1);
			Punktobjekten[i].y = (int)(Math.random()*1000+1);
			Punktobjekten[i].Abstand = (float)(Math.sqrt(Punktobjekten[i].x*Punktobjekten[i].x
												+Punktobjekten[i].y*Punktobjekten[i].y));
			
			if (Punktobjekten[i].Abstand > MaxAbstand)
			{
				MaxAbstand = Punktobjekten[i].Abstand;
				z = i;
			}
		}
		Ausgabe = "Die Koordinaten des Punktes mit dem größten Abstand vom Ursprung sind:\n\nDie x-Koordinate = "
			+Punktobjekten[z].x +"\nDie y-Koordinate = " + Punktobjekten[z].y+"\n\nDas können Sie gleich prüfen!";
		JOptionPane.showMessageDialog(null, Ausgabe, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void Bubblesort()
	{
		Punkt speicher = new Punkt();
		for (int j = 99; j > 0; j--)
		{
			for (int i = 0; i < j; i++)
			{
				if(Punktobjekten[i].Abstand > Punktobjekten[i+1].Abstand)
				{
					speicher = Punktobjekten[i+1];
					Punktobjekten[i+1] = Punktobjekten[i];
					Punktobjekten[i] = speicher;
				}
			}
		}
		
		for (int i = 0; i < 100; i++)	
		{
			Ausgabe = "\nDer "+(i+1)+". Punkt:\nDie x-Koordinate = "+ Punktobjekten[i].x +"\nDie y-Koordinate = "
					+Punktobjekten[i].y+"\nDer Abstand vom Ursprung = "+df.format(Punktobjekten[i].Abstand)+" Längeneinheit";
			textArea.append(Ausgabe+"\n");
		}		
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true);
		scrollPane.setPreferredSize(new Dimension(400, 500));
		JOptionPane.showMessageDialog(null, scrollPane, "Das Ergebnis", JOptionPane.INFORMATION_MESSAGE);
	}

}
