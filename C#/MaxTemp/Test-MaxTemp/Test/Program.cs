using System;
using System.IO;
using System.Globalization;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {

            //Zugriff auf Datei erstellen: (StreamReader)
            string Dateiname = @"temps.csv";

            StreamReader reader = new StreamReader(Dateiname);

            // Zeile für Zeile einlesen:
            string Zeile;
            float MaxTemp = 0;
            int x = 1;
            float[] Temp = new float[x];

            for (int i = 0; i < x; i++)
                {
                while ((Zeile = reader.ReadLine()) != null)

                    if (Zeile.Substring(0, 2) == "SB" || Zeile.Substring(0, 2) == "SD")
                    {
                        x++;
                        Temp[i] = float.Parse(Zeile.Substring(23, 4), System.Globalization.CultureInfo.InvariantCulture);
                        // Change the delimiter (The default delimiter is based on your current CultureInfo)!

                        Console.WriteLine(Zeile.Substring(0, 2) + ": " + Temp[i]);

                        if (Temp[i] > MaxTemp)
                        {
                            MaxTemp = Temp[i];
                        }
                        
                    }

            }
            Console.WriteLine("Die Maximale Raumtemperatur beträgt: "+MaxTemp);
            

            //Anfangswert setzen, um sinnvoll vergleichen zu können.


            //In einer Schleife die Werte holen und auswerten. Den größten Wert "merken".
            //foreach? While? MaxWert?


            //Datei wieder freigeben.
            //FileStream Close?

            //Höchstwert auf Oberfläche ausgeben.

            //MessageBox.Show("Gleich kachelt das Programm...");
            //kommentieren Sie die Exception aus.
            //throw new Exception("peng");

            Console.ReadKey();  //Console.ReadLine() ??
        }
    }
}
