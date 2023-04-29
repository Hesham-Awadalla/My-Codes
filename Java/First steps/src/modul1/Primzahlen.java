package modul1;
import java.util.Scanner;

public class Primzahlen { // Aufgabe 1

	public static void main(String[] args) {

		System.out.println("Bitte geben Sie eine Zahl ein:");
		Scanner sc = new Scanner(System.in);
		int Zahl = sc.nextInt();
		int test = 0;

		if (Zahl == 1) {
			System.out.println("Die Zahl 1 ist per Definition keine Primzahl.");
		} else if (Zahl == 2) {
			System.out.println("Die Zahl 2 ist die kleinste und einzige gerade Primzahl.");
		}

		for (int i = 2; i < Zahl; i++) {

			if (Zahl > 1 && Zahl % 2 != 0 && Zahl % i != 0) {
				test = 0;
			} else {
				test++; // also, keine Primzahl!
				System.out.println("Dies ist keine Primzahl.");
				break;
			}
		}
		if (test == 0 && Zahl != 1) {
			System.out.println("Dies ist eine Primzahl.");
		}
	}
}
