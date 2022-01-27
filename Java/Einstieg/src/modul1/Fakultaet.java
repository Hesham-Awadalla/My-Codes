package modul1;
import java.util.Scanner;

public class Fakultaet { // Aufgabe 3

	public static void main(String[] args) {

		System.out.println("Geben Sie bitte eine Zahl >1 ein: (Bitte beachten Sie dass 0! und 1! beide per Definition gleich 1 sind)");
		Scanner sc = new Scanner(System.in);
		int Zahl = sc.nextInt();
		long F = 1L;
		for (int i = 0; i < Zahl; i++) {
			F = F * (i + 1);
		}
		System.out.println(Zahl + "!= " + F);
		//funktioniert nur bis 2^63 -1 >> long
		
		// >69! (da meckert der Taschenrechner!)  s. (unsigned) BigInteger!
		// Warum funktioniert doch richtig mit 0 und 1? Denn die if-Bedingung wird abgebrochen!
	}
}
