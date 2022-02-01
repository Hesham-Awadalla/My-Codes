import java.util.Arrays;
import java.util.Scanner;

public class Linearefunktionen {

	// Meine eigene Funktion/Methode:
	public static String meinefunktion(String var) {
			
		return("Hello World "+var);
		}
	
	public static void main(String[] args) {
		String ausgabe = meinefunktion("Hello");
		System.out.println(ausgabe);
		
	/*Aufgabenstellung:
	In dieser Aufgabe soll ein Programm geschrieben werden, welches verschiedene Rechenoperationen durchf�hrt, die man mit linearen Funktionen so anstellen kann.
	Versucht einzelne Funktionalit�ten eures Programms in sinnvolle Methoden auszulagern.

	Eine lineare Funktion ist wie folgt definiert: y = m*x + n
	1. Sei m=2 und n=-5 gegeben. Schreibe ein Programm, welches die Funktionswerte von x = 0, 1, 2, ..., 20 in einem Array speichert.
	2. Erweitere dein Programm so, dass gez�hlt werden kann wie viele Funktionswerte gr��er 0 sind
	3. Nun soll man den Graphen an der y-Achse beliebig verschieben k�nnen. Schreibe ein Programm, welches das Array und somit alle Funktionswerte von 0 bis 20 aktualisiert.
	4. Desweiteren soll das Programm die Fl�che zwischen dem Graphen und der x-Achse berechnen und ausgeben k�nnen.
	5. Gegeben seien die vier Integer-Werte x1 und y1 sowie x2 und y2. Schreibe eine Methode, welche m und n bestimmt und in der Form y = m*x + n auf der Konsole ausgibt.
	 */
		
	System.out.println("y = m*x + n \n Bitte geben Sie m (der Steigung) und n (dem y-Achsenabschnitt) einen Wert!\n m = ?");
	try (Scanner input = new Scanner (System.in)) {
		float m = input.nextFloat();
		System.out.println("n = ?");
		float n = input.nextFloat();
		float y []= new float [21];
		int z = 0;  //Z�hler
		for (int x=0; x<=20; x++) {
			y[x] = m*x +n;
			if (y[x]>0) {
				z++;
			}
		}
		System.out.println("For 0<= x <=20 ist y = "+Arrays.toString(y));
		System.out.println("Es gibt also "+z+" positive Funktionswerte.");
		
		//Fl�che berechnen:
		System.out.println("\nUm die Fl�che zwischen dem Graphen und der x-Achse auszugeben, br�uchten wir den Xmin und Xmax:\nXmin = ?");
		float Xmin = input.nextFloat();
		System.out.println("Xmax = ?");
		float Xmax = input.nextFloat();
		
		float F = (Xmax*Xmax+n*Xmax)-(Xmin*Xmin+n*Xmin);  //Integration S y.dx  (y=2x-5) von 0 bis 20
		System.out.println("Die Fl�che zwischen dem Graphen und der x-Achse betr�gt "+F+" Fl�cheneinheit.");
		
		// m und n berechnen:
		System.out.println("\nGegeben seien die zwei Punkte (x1,y1) sowie (x2,y2).\nBsp.:\nx1 = ?");
		float x1 = input.nextFloat();
		System.out.println("y1 = ?");
		float y1 = input.nextFloat();
		System.out.println("x2 = ?");
		float x2 = input.nextFloat();
		System.out.println("y2 = ?");
		float y2 = input.nextFloat();
		
		m = (y2-y1)/(x2-x1);  //float statt int
		n = y1 - x1*(y2-y1)/(x2-x1);
		System.out.println("Also, die zwei Punkte sind ("+x1+","+y1+") und ("+x2+","+y2+").\nDann m (die Steigung) = (y2-y1)/(x2-x1) = "+m);
		System.out.println("Und n (der y-Achsenabschnitt) = y1 - x1*(y2-y1)/(x2-x1) = y2 - x2*(y2-y1)/(x2-x1) = "+n);
		System.out.println("Also, y = "+m+"x + "+n);
		}
	
	}

}
