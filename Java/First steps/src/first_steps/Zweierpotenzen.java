package first_steps;

import java.util.Arrays;

public class Zweierpotenzen {

	public static void main(String[] args) {
	
		/* Aufgabe:
		Schreibt ein Programm, welches die ersten 20 Zweierpotenzen ausrechnet und in einem Array speichert.
		Versucht in einem zweiten Schritt nur zwei Schleifen zu benutzen:
		Eine, welche das Array mit Werten f�llt und eine Schleife, welche das Array testweise ausgibt.
		Geht es auch mit nur einer Schleife? */
			
	int [] zp = new int [20];
	
	for(int i=0; i<20; i++) {
		zp [i] = (int) Math.pow(2, i);
		}
	System.out.println("Die ersten 20 Zweierpotenzen sind: \n"+Arrays.toString(zp));
		
	}

}
