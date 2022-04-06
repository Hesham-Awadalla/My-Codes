using System;

namespace Alter
{
    class Program
    {
        
        static void Alter()
        {
            Console.WriteLine("Bitte geben Sie Ihren Alter ein:");         
            int alter = int.Parse(Console.ReadLine());

            Console.WriteLine("Alter umwandeln in?\n[1] Tage\n[2] Stunden\n[3] Sekunden");
            string eingabe = Console.ReadLine();

            int ergebnis;

            switch (eingabe)
            {
                case "1":
                    ergebnis = alter * 365;
                    Console.WriteLine("Alter in Tage = " + ergebnis + " Tage");
                    break;

                case "2":
                    ergebnis = alter * 365 * 24;
                    Console.WriteLine("Alter in Stunden = " + ergebnis + " Stunden");
                    break;

                case "3":
                    ergebnis = alter * 365 * 24 * 60 * 60;
                    Console.WriteLine("Alter in Sekunden = " + ergebnis + " Sekunden");
                    break;

                default:
                    Console.WriteLine("Falsche Eingabe!");
                    break;
            }

            
            }
        static void Main(string[] args)
        {
            Alter();
            Console.ReadKey();
        }
    }
}
