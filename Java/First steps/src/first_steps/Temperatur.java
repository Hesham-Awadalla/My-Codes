package first_steps;

import java.util.Scanner;

public class Temperatur {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie hoch ist die Temperatur in C?");
        int C = sc.nextInt();
        double F = C*1.8 + 32; 
        System.out.println("Die Temperatur in F betraegt "+F+" Fahrenheit");
    }
}