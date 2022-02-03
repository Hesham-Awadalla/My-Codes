using Microsoft.Win32;
using System;
using System.Collections.Generic;
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

namespace Telefonbuch
{
    /// <summary>
    /// Interaktionslogik für MainWindow.xaml
    /// </summary>
    /// 
   
    // Was sollte unser Programm können?
    //1. Eine Liste mit Kontakten auf der GUI anzeigen
    //2. Einen Kontakt erstellen, bearbeiten, und löschen
    //3. Die Kontakte aus einer Txt- bzw. Excel-Datei importieren
    //4. Die Kontaktliste als z.B. csv-Datei exportieren
    //5. Suchfeld einbinden, wo Kontakte aus der importierten Datei gesucht werden können
    //6. Unser Programm mit einer DB verbinden

    //Welche Steuerelemente sind nötig?
    //Button: Erstellen => Dieser Button ermöglicht es einen neuen Kontakt zu erstellen
    //Button: Bearbeiten => Dieser Button ermöglicht das Bearbeiten von bereits erstellten Kontakten
    //Button: Löschen => Dieser Button ermöglicht das Löschen von bereits erstellten Kontakten
    //Button: Importieren
    //Button: Suchen
    //Button: Beenden
    //TextBox: Vorname => Benutzer kann hier beim erstellen eines neuen Kontaktes den Vornamen eintragen. Bei bereits erstelltem Kontakt, den Vornamen abrufen.
    //TextBox: Nachname => Benutzer kann hier beim erstellen eines neuen Kontaktes den Nachnamen eintragen. 
    //TextBox: TelefonNr => Benutzer kann hier beim erstellen eines neuen Kontaktes die Telefonnummer eintragen. Bei bereits erstelltem Kontakt, die Telefonnummer abrufen.
    //TextBox: E-Mail => Benutzer kann hier beim erstellen eines neuen Kontaktes die E-Mail-Adresse eintragen. Bei bereits erstelltem Kontakt, die E-Mail-Adresse abrufen.



    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        //Der Button importiert eine Kontaktliste, die der Nutzer über den Windows Explorer auswählt
        private void btnImport_Click(object sender, RoutedEventArgs e)
        {
            //Windows Explorer (FileChooser) - Um Datei (Telefonbuch) zu wählen
            OpenFileDialog fileDialog = new OpenFileDialog();
            fileDialog.ShowDialog();
            string Dateipfad = fileDialog.FileName;

            //FileStream und StreamReaer um eine Verbindung zur Datei herzustellen und die Datei zu lesen
            FileStream importStream = new FileStream(Dateipfad, FileMode.Open);
            StreamReader readDatei = new StreamReader(importStream);

            //Test:
            //TxtAusgabe.Text = readDatei.ReadToEnd();   Warum funktioniert trotzdem??!!
        }

        private void TxtAusgabe_TextChanged(object sender, TextChangedEventArgs e)
        {

        }

        private void btnErstellen_Click(object sender, RoutedEventArgs e)
        {

        }

        //Der Button schließt die Anwendung
        private void btnClose_Click_1(object sender, RoutedEventArgs e)
        {
            //Der Nutzer wird gefragt, ob er das Programm beenden möchte, wenn er 'Ja' wählt wird es beendet, bei 'Nein' läuft das Programm weiterhin
            MessageBoxResult result = MessageBox.Show("Möchten Sie das Programm schließen?", "Beenden", MessageBoxButton.YesNo, MessageBoxImage.Question, MessageBoxResult.No); 
            if (result == MessageBoxResult.Yes)
            {
                Close();
            }
        }
    }
}
