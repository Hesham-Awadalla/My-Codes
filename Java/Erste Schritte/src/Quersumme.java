import java.util.Arrays;
import java.util.Scanner;

public class Quersumme {

	/* 1. Aufgabe:
	Ein Programm zur Bestimmung der Quersumme einer nat�rlichen Zahl soll geschrieben werden.
	Schritt f�r Schritt soll dieses Programm um weitere Funktionen erweitert werden.

	1. Spalte die einzelnen Ziffern mittels Division und Modulo-Operation ab und addiere sie, um die Quersumme zu bestimmen.
	2. Gib alle Zahlen von 0 - 1000 aus, welche die Quersumme 15 haben.
	3. Gib alle Zahlen von 0 - 1000 aus, deren Quersumme ein Vielfaches von 7 ist.
	4. Welche Quersumme der Zahlen von 0 - 1000 kommt am h�ufigsten vor?
	(Tipp: �berlegt Euch, wie viel verschiedene Quersummen vorkommen k�nnen, erstellt ein Array dieser Gr��e und speichert 
	dort die Anzahl der Vorkomnisse)
	5. Die iterierte Quersumme wird auch Ziffernwurzel genannt (Abk. zw)
	Beispiel: 47 --> 4 + 7 = 11 --> 1 + 1 = 2, also zw(47)=2
	Schreibt ein Programm, welches die Ziffernwurzel f�r eine beliebige Zahl bestimmt.
	6. Das Querprodukt ist wie folgt definiert: 68 = 6 * 8 = 48. Es gibt Zahlen, bei denen die Summe aus Quersumme und 
	Querprodukt wieder die Zahl selbst ergibt Beispiel: 79 = 7 + 9 + 7*9 = 79. Gibt es weitere Zahlen zwischen 0 und 1000 
	mit dieser Eigenschaft? Wenn ja, welche ? */
	
	public static int[] ziff(int z) {		//public static method!!
		
		int n = String.valueOf(z).length();
		int[] result = new int [n];
		for (int i=0; i<n ; i++) {
			int Zpot = (int)Math.pow(10, n-i-1);	//Zehnerpotenzen
			result[i] = (z%(10*Zpot)-z%Zpot)/Zpot;
		}
			
		return result;
	}
    
    // Meine qs-Methode/Funktion:
	static int qs(int z) {		//static method!!
		
		int n = String.valueOf(z).length();   // n als Array = ziff(z)
		int result = 0;
		for (int i=0; i<n; i++) {   //statt n   n.length
			result += ziff(z)[i];   //result += n[i]
		}
		return result;
	}
	
	// Meine qp-Methode/Funktion:
	static int qp(int z) {			// probiere es mal mit n wie oben
		
		int n = String.valueOf(z).length();
		int result = 1;
		for (int i=0; i<n; i++) {
			result *= ziff(z)[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Bitte geben Sie irgendeine Zahl z ein:");
		try (Scanner input = new Scanner (System.in)) {
			int z = input.nextInt();
			System.out.println(Arrays.toString(ziff(z)));
			System.out.println("\nDie Quersumme der Zahl "+z+" = "+qs(z));
			
			//Die iterierte Quersumme (Ziffernwurzel):
			System.out.println("Die Ziffernwurzel der Zahl "+z+" = "+qs(qs(z)));
			System.out.println("Und das Querprodukt der Zahl "+z+" = "+qp(z));
		}
		
		System.out.println("\nDie Quersumme folgender Zahlen ist 15:");
		for (int i=0; i<1000; i++) {
			if (qs(i) == 15)
			System.out.print(i+" ");
		}
		System.out.println("\n\nUnd die Quersumme folgender Zahlen ist ein Vielfaches von 7:");
		for (int i=0; i<1000; i++) {
			if (qs(i)%7 == 0)
			System.out.print(i+" ");
		}
		
		int[] vorkomm = new int[qs(1000-1)+1];  // 9+9+9 + 0
		for (int i=0; i<1000; i++) {
			vorkomm[qs(i)]++;
			//System.out.println(Arrays.toString(vorkomm));
		}	
		System.out.println("\n\nAnzahl der VORKOMNISSE der Quersummen 0 bis 27 (9+9+9):");
		System.out.println(Arrays.toString(vorkomm));
		
		int maxvorkomm = vorkomm[0];
		for (int i=0; i<vorkomm.length; i++) {
			if (vorkomm[i]>maxvorkomm)
				maxvorkomm = vorkomm[i];
		}
		int zz = 0;  //Hilfsz�hler
		int[] maxqs = new int [vorkomm.length];
		for (int i=0; i<vorkomm.length; i++) {
			if (vorkomm[i] == maxvorkomm)
				maxqs[zz] = i;
				zz++;
		}
		System.out.println("\nAlso, von 0 - 1000 kommen folgende Quersummen am h�ufigsten vor:");
		for (int i=0; i<zz ; i++) {
			if (maxqs[i]!= 0) {		//so kann ich die 0en entfernen
				System.out.print(maxqs[i]+" ");
			}
		}
		System.out.println("\n\nBei diesen Zahlen ergibt die Summe aus Quersumme und Querprodukt wieder die Zahl selbst:");
		for (int i=10; i<1000; i++) {
			if (qs(i) + qp(i) == i)
			System.out.print(i+" ");
		}
		
	}

}
