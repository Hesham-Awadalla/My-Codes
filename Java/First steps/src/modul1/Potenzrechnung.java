package modul1;
import java.util.Scanner;

public class Potenzrechnung { // Aufgabe 4

	public static void main(String[] args) {

		System.out.println("Bitte geben Sie eine positive Zahl (Basis) ein:");
		Scanner sc = new Scanner(System.in);
		int Basis = sc.nextInt();
		System.out.println("Bitte geben Sie einen positiven Exponenten ein:");
		int Exponent = sc.nextInt();

		long Potenz = (long) Math.pow(Basis, Exponent);
		//Beachte: Max. Ergebnis = 2^63 -1 (long!)  s. BigInteger!!
		System.out.println("Die Potenz = " + Potenz);
	}
}
