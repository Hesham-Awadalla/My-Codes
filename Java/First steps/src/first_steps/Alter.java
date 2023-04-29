package first_steps;

import java.util.Scanner;

public class Alter {

	public static void main(String[] args) {
		
		System.out.println("Heutiges Jahr?");
		Scanner sc = new Scanner(System.in);
		int Jahr = sc.nextInt();
		System.out.println("Und Ihr Geburtsjahr?");
		int Geburtsjahr = sc.nextInt();
		int Alter = Jahr - Geburtsjahr;
		System.out.println("Sie sind "+Alter+" Jahre alt");

	}

}