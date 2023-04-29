package modul2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

abstract class BracketTestTools
{
	private static String Eingabe;
	private static ArrayList<Character> Klammer;
	
	
	public static ArrayList<Character> Eingabe()
	
	{
		Eingabe = JOptionPane.showInputDialog("Dies ist ein Klammerungsprüfer:");
		
		Klammer = new ArrayList<Character>();
		
		for (int i = 0; i < Eingabe.length(); i++)
			{
				Klammer.add(Eingabe.charAt(i));
			}
		return Klammer;
	}
	
	
	public static void Klammerpruefer(ArrayList<Character> Klammer) throws InterruptedException  // >> wegen MessageDialog und break; !!
	{
		int count1 = 0, count2 = 0, count3 = 0;   // count1 für '()'  count2 für '{}'  count3 für '[]'
		
		ArrayList<Character> PositiveKlammern = new ArrayList<Character>();  // Das sind +ve Klammern '('  '{'  '['
		int found = 0;	//Hilfreich für den Fall der ungültigen Zeichen & wenn man direkt mit -ven Klammern anfängt!
		
		if (Eingabe.length() == 0)
			{
				JOptionPane.showMessageDialog(null, "Eingabefeld ist leer!");					
				found++;
			}
		
		for (int i = 0; i < Eingabe.length(); i++)
			{
				
				if (Klammer.get(i) != '(' && Klammer.get(i) != ')' && Klammer.get(i) != '{'
					&& Klammer.get(i) != '}' && Klammer.get(i) != '[' && Klammer.get(i) != ']')
					{
						JOptionPane.showMessageDialog(null, "Es sind keine gültigen Zeichen enthalten!");						
						found++;
						break;
					}
				else if (Klammer.get(i) == '(')
					{
						count1++;
						PositiveKlammern.add('(');
					}
				else if (Klammer.get(i) == '{')
					{
						count2++;
						PositiveKlammern.add('{');	
					}
				else if (Klammer.get(i) == '[')
					{
						count3++;
						PositiveKlammern.add('[');	
					}
				
				else if (PositiveKlammern.size() == 0)   //Um nicht ins Minus mit dem Size zu landen (sonst Fehlermeldung)!
					{
						JOptionPane.showMessageDialog(null, "Dies ist KEINE korrekte Klammerung!");
						found++;
						break;
					}
				
				else if (Klammer.get(i) == ')' && PositiveKlammern.get(PositiveKlammern.size()-1) == '(')
					{
						count1--;
						PositiveKlammern.remove(PositiveKlammern.size()-1);
					}
				else if (Klammer.get(i) == '}' && PositiveKlammern.get(PositiveKlammern.size()-1) == '{')
					{
						count2--;
						PositiveKlammern.remove(PositiveKlammern.size()-1);
					}
				else if (Klammer.get(i) == ']' && PositiveKlammern.get(PositiveKlammern.size()-1) == '[')
					{
						count3--;
						PositiveKlammern.remove(PositiveKlammern.size()-1);
					}
//				else if (count1 != 0  || count2 != 0 || count3 != 0)
//					{
//						JOptionPane.showMessageDialog(null, "Dies ist KEINE korrekte Klammerung!");
//						break;
//					}
//				else
//					{
//						JOptionPane.showMessageDialog(null, "Dies ist KEINE korrekte Klammerung!");
//						break;
//					}
			}
		
		if (found > 0)
			{
				System.exit(0);
			}
		else if (count1 != 0  || count2 != 0 || count3 != 0)
			{
				JOptionPane.showMessageDialog(null, "Dies ist KEINE korrekte Klammerung!");				
			}
		else if (count1 == 0 && count2 == 0 && count3 == 0)
			{
				JOptionPane.showMessageDialog(null, "Dies ist eine KORREKTE Klammerung");
			}
			
	}
}
