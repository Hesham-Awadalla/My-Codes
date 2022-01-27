package modul1;
import java.util.Random;
import java.util.Scanner;

public class Zahlenratespiel {  //Aufgabe 5

	public static void main(String[] args) throws InterruptedException {
	
	// Teile und herrsche Methode!! (Divide and Conquer Prinzip) zum Gewinnen (immer in der Mitte anfangen!):
	// 2(Vergleiche: richtig oder falsch)^4(Versuche) = 16 (Möglichkeiten > 15 also mit 4 Versuchen kann man immer gewinnen)
	// Bei n Zahlen log n (Basis 2) Vergleiche statt n Vergleiche!! 
	Random rand = new Random();
	int Zufallzahl = rand.nextInt(15) + 1;
	//Erzeugt eine Zufallzahl zwischen (0 - 14). Deswegen +1 > (1 - 15)
	//System.out.println(Zufallzahl);
	
	System.out.println("Raten Sie mal die geheime Zufallzahl zwischen 1 - 15! (Sie haben 4 Versuche!)");
	Scanner sc = new Scanner(System.in);
	
	for (int i = 1; i <= 4; i++) {
	Thread.sleep(1000);
	System.out.println("Der "+i+". Versuch:");
	int Eingabe = sc.nextInt();	
		if (Eingabe == Zufallzahl) {
			System.out.println("Sie haben gewonnen!");
			break;
			}else if (Eingabe >= Zufallzahl){
			System.out.println("Ihre Eingabe ist leider größer als die Zufallzahl!");	
			}else {
			System.out.println("Ihre Eingabe ist leider kleiner als die Zufallzahl!");
			}
		}
	}
}
