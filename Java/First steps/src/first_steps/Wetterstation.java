package first_steps;

import java.util.Arrays;
import java.lang.StringBuilder;

public class Wetterstation {

	public static void main(String[] args) {
		
	/*Aufgabe
Eine Wetterstation hat f�r 14 Tage folgende Temperaturwerte aufgenommen.

Tag:         1  2  3  4  5  6  7  8  9 10 11 12 13 14
Temperatur: 12 14  9 12 15 16 15 15 11  8 13 13 15 12
1. Speichere die folgende Tabelle mit einem geeigneten Datentyp.
2. Schreibe ein Programm, welches die Durchschnittstemperatur (f�r die zwei Wochen) bestimmt.
3. Schreibe ein Programm, welches die maximale und minimale Temperatur ausgibt.
4. Schreibe ein Programm, welches die beiden aufeinanderfolgenden Tage angeben kann, an denen es den gr��ten Temperaturumschwung gab.
5. Schreibe ein Programm, welches die Tabelle sch�n tabellarisch auf der Konsole ausgibt. */

		
		//1. Aufgabe:		
		int [] t = {12,14,9,12,15,16,15,15,11,8,13,13,15,12,174747} ;
		
		//2. Aufgabe:
		float sum = 0;
		for (int i=0 ; i<t.length; i++) {
			sum += t[i];
		}
		
		float durch = sum/t.length;
		System.out.println("Die Durchschnittstemperatur f�r die 2 Wochen betr�gt "+durch+" Grad.");
		
		//3. Aufgabe:
		int max = t[0];
		int min = t[0];
		for (int i=0 ; i<t.length; i++) {
			if(t[i] > max) {
				max = t[i];
			}else if(t[i]<min){
				min = t[i];
			}
		}
		
		System.out.println("Die maximale Temperatur betr�gt "+max+" Grad.");
		System.out.println("Die minimale Temperatur betr�gt "+min+" Grad.");
		
		//4. Aufgabe:
		int [] umschwung = new int [t.length-1];
		
		System.out.println("Die absoluten Temperaturumschw�nge:");
		for (int i=0 ; i<t.length-1; i++) {
			umschwung [i] = Math.abs(t[i+1] - t[i]);
			//System.out.print(umschwung[i]+" "); //VORSICHT: print not println!! (Array in einer "Zeile" ausgeben)		
		}
		System.out.println(Arrays.toString(umschwung));
		
		int umax = umschwung[0];
		// int umin = umschwung [0];
		for (int i=0 ; i<umschwung.length; i++) {
			if (umschwung[i] > umax) {
				umax = Math.abs(umschwung[i]);
			} 
		}
		int temp = 0;  //tempor�re Var. als "Hilfsz�hler".
		int [] tage = new int [t.length];
		for (int i=0; i < umschwung.length; i++) {
			if (Math.abs(umschwung[i]) == umax) {
				tage[temp] = i;
				temp++;
			}
		}
		System.out.println(Arrays.toString(tage));
		
		System.out.print("\nDie beiden aufeinanderfolgenden Tage, an denen es den gr��ten Temperaturumschwung gab, sind jeweils ");
		for (int i=0; i<temp ; i++) {
			System.out.print("am "+(tage[i]+1)+". und "+(tage[i]+2)+". Tag "); 
		}
		
		//5. Aufgabe:
		System.out.println("\n ________________________");
		System.out.println("|    Tag     | Temperatur |");  // auch allgemeing�ltig machen
		
			int AnzahlTage = t.length;
			int StellenAnzahlTage = String.valueOf(AnzahlTage).length();
			int fuellzeichenTage = 0;
			int StellenAnzahlTemp = String.valueOf(max).length();
			int fuellzeichenTemp = 0;
			
			StringBuilder Ausgabe = new StringBuilder();
			for (int i=0 ; i<t.length; i++) {
				Ausgabe.setLength(0);   //leeren
				fuellzeichenTage = StellenAnzahlTage-String.valueOf(i+1).length();  // Achtung i+1 (z.B. Tag 10 hat i=9)
				fuellzeichenTemp = StellenAnzahlTemp-String.valueOf(t[i]).length();
				Ausgabe.append("|     ");
				
				//Tage
				for (int j = 0; j<fuellzeichenTage; j++) {
					Ausgabe.append(" ");
				}
				Ausgabe.append(String.valueOf(i+1));
				Ausgabe.append("     |     ");
				
				// Temp
				for (int j = 0; j<fuellzeichenTemp; j++) {
					Ausgabe.append(" ");
				}
				Ausgabe.append(String.valueOf(t[i]));
				Ausgabe.append("     |");
				System.out.println(Ausgabe);
			}
		
			
		System.out.println("|____________|____________|");  // auch allgemeing�ltig machen
	}
	
	/* Oder:
	System.out.println("\n_______________________");
	System.out.println("|    Tag   | Temperatur |");
		
	for (int i=0 ; i<t.length; i++) {
		if (i<9 && t[i] <= 9) {
	System.out.println("|     "+(i+1)+"           "+t[i]+"     |");}
		else if ( i>9 && t[i] > 9){
	System.out.println("|     "+(i+1)+"         "+t[i]+"     |");
		}else if ( i>9 && t[i] < 0){
	System.out.println("|     "+(i+1)+"         "+t[i]+"     |");
		}else {
	System.out.println("|     "+(i+1)+"          "+t[i]+"     |");
		}
	}
	System.out.println("|__________|____________|");
	*/

}
