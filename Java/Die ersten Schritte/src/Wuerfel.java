import java.util.Scanner;

public class Wuerfel {

	public static void main(String[] args) {
		
		System.out.println("Wie gross ist die Laenge (in cm)?");
		try (Scanner sc = new Scanner(System.in)) {
			int Laenge = sc.nextInt();
			double Flaeche = Laenge*Laenge*0.0001;
			double Volumen = Laenge*Laenge*Laenge*0.000001;
			System.out.println("Die Flaeche des Quadrats ist = "+Flaeche+" m2 \nDas Volumen des Wuerfels ist = "+Volumen+" m3");
		}
	}

}