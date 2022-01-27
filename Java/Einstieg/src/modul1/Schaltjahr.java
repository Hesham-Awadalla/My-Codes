package modul1;
import java.util.Scanner;

public class Schaltjahr { // Aufgabe 2

	public static void main(String[] args) {

		System.out.println("Bitte geben Sie eine Jahreszahl >= 1582 (Beginn des Gregorianischen Kalenders) ein:");
		Scanner sc = new Scanner(System.in);
		int Jahr = sc.nextInt();

		if ((Jahr % 4 == 0 && Jahr % 100 != 0) || (Jahr % 100 == 0 && Jahr % 400 == 0)) {
		//oder if (Jahr % 400 == 0 || Jahr % 4 == 0 && Jahr % 100 != 0)
		//&& (stärker) wird vor || ausgeführt (wie * vor + -)
			System.out.println("Es handelt sich um ein Schaltjahr.");
		} else {
			System.out.println("Es handelt sich um kein Schaltjahr.");
		}
	}
}
