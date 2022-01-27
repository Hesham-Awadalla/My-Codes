using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace MaxTemp
{
    /// <summary>
    /// Interaktionslogik für MainWindow.xaml
    /// </summary>
    /// Maurice`s Code
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Diese Routine (EventHandler des Buttons Auswerten) liest die Werte
        /// zeilenweise aus der Datei temps.csv aus, merkt sich den höchsten Wert
        /// und gibt diesen auf der Oberfläche aus.
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void BtnAuswerten_Click(object sender, RoutedEventArgs e)
        {
            //Deklaration der Variablen
            string dateiname;
            float maxTemp;   //statt Double wegen Speichersparung!
            float minTemp;
            float Summe;
            float durchTemp;
            int Z;  //Hilfszähler
            string zeile;
            string[] zeilenKomponenten;
            string sensor;
            float temperatur;
            
            //Zugriff auf Datei erstellen.
            dateiname = @"temps.csv";
            StreamReader reader = new StreamReader(dateiname);   //FileStream läuft automatisch im Hintergrund

            //Anfangswert setzen (Initialisierung), um sinnvoll vergleichen zu können.
            maxTemp = float.MinValue;
            minTemp = float.MaxValue;
            Summe = 0;
            Z = 0;

            //In einer Schleife die Werte holen und auswerten. Den größten Wert "merken".
            while (!reader.EndOfStream)    //so ist allgemeingültiger
            {
                zeile = reader.ReadLine();
                zeilenKomponenten = zeile.Split(',');
                sensor = zeilenKomponenten[0];
                Z++;

                // Change the delimiter - (The default delimiter is based on your current CultureInfo)
                temperatur = float.Parse(zeilenKomponenten[2], System.Globalization.CultureInfo.InvariantCulture);

                Summe += temperatur;

                if ((sensor == "SB" || sensor == "SD") && temperatur > maxTemp)
                {
                    maxTemp = temperatur;
                }

                if ((sensor == "SB" || sensor == "SD") && temperatur < minTemp)
                {
                    minTemp = temperatur;
                }

            }
            
            durchTemp = Summe / Z;

            //Datei wieder freigeben.
            reader.Close();

            //Höchstwert auf Oberfläche ausgeben:
            lblAusgabe1.Content = maxTemp + " °C ist die höchste Raumtemperatur.";
            lblAusgabe2.Content = minTemp + " °C ist die niedrigste Raumtemperatur.";
            lblAusgabe3.Content = durchTemp + " °C ist die durchschnittliche (aller) Temperaturen.";

            //MessageBox.Show("Gleich kachelt das Programm...");
            //kommentieren Sie die Exception aus.
            //throw new Exception("peng");
        }
    }
}
