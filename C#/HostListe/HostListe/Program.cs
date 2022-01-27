using System;
using System.IO;

namespace HostListe
{
    class Program
    {
        static void GenerateHostListe()
        {
            //Zugriff auf Datei 'Rechnerliste.csv' erstellen
            string dateinameRechnerliste = @"Rechnerliste.csv";
            FileStream fileStreamRechnerliste = new FileStream(dateinameRechnerliste, FileMode.Open);
            StreamReader streamReader = new StreamReader(fileStreamRechnerliste);

            //Datei 'Hostliste.csv' erstellen:

            //"Append": Wenn die Datei (z.B. HostlListe") noch nicht erstellt worden ist, dann wird sie erstellt,
            //und immer dazu hinzugefügt (Append).
            string dateinameHostliste = "Hostliste.txt";  //Warum funktioniert aber nicht mit CSV??
            FileStream fileStreamHostliste = new FileStream(dateinameHostliste, FileMode.Append);
            StreamWriter streamWriter = new StreamWriter(fileStreamHostliste);


            //Deklaration der Variablen
            string zeile;
            string[] zeilenkomponente;
            string mac;
            string raumnummer;
            string rechnernummer;
            string adressbereich = "10.16.";
            string MacIP;

            //Mit Schleife jede Adresse umwandeln
            while (!streamReader.EndOfStream)
            {
                // Zeile für Zeile einlesen
                zeile = streamReader.ReadLine();

                //Zeilenkomponenten speichern
                zeilenkomponente = zeile.Split(';');
                mac = zeilenkomponente[0];
                raumnummer = zeilenkomponente[1];
                rechnernummer = zeilenkomponente[2];

                //MacIP bilden
                MacIP = mac + ";" + adressbereich + raumnummer +"."+ rechnernummer + ";";

                //MacIP in Datei schreiben
                streamWriter.WriteLine(MacIP);              
            }

            //StreamReader schließen
            streamReader.Close();
            fileStreamRechnerliste.Close();

            //StreamWriter schließen
            //Erst streamWriter schließen bevor fileStream geschlossen wird, da die Datei sonst nicht gespeichert wird!
            streamWriter.Close();
            fileStreamHostliste.Close();          

            Console.WriteLine("Datei erfolgreich beschrieben");
        }

        static void Main(string[] args)
        {
            GenerateHostListe();
            Console.ReadKey();
        }

    }
}
