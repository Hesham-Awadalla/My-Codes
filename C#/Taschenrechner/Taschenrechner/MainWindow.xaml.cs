using System;
using System.Collections.Generic;
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

namespace Taschenrechner
{
    /// <summary>
    /// Interaktionslogik für MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        double zahl1, zahl2;
        char zeichen;
        double ergebnis;

        private void btnNull_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("0");
        }

        private void btnEins_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("1");
        }

        private void btnZwei_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("2");
        }

        private void btnDrei_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("3");
        }

        private void btnVier_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("4");
        }

        private void btnFünf_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("5");
        }

        private void btnSechs_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("6");
        }

        private void btnSieben_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("7");
        }

        private void btnAcht_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("8");
        }

        private void btnNeun_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText("9");
        }

        private void btnComma_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.AppendText(",");
        }

        private void btnGleich_Click(object sender, RoutedEventArgs e)
        {
            zahl2 = Convert.ToDouble(txtErgebnis.Text);

            switch (zeichen)
            {
                case '+':
                    ergebnis = zahl1 + zahl2;
                    txtErgebnis.Text = ergebnis.ToString();
                    break;
                case '-':
                    ergebnis = zahl1 - zahl2;
                    txtErgebnis.Text = ergebnis.ToString();
                    break;
                case '*':
                    ergebnis = zahl1 * zahl2;
                    txtErgebnis.Text = ergebnis.ToString();
                    break;
                case '/':
                    if (zahl2 != 0)
                    {
                        ergebnis = zahl1 / zahl2;
                        txtErgebnis.Text = ergebnis.ToString();                   
                    }
                    else
                    {
                        txtErgebnis.Text = "Nulldivision!";
                    }

                    break;

                default:
                    txtErgebnis.Text = "Falsche Eingabe!";
                    break;
            }
        }

        private void btnPlus_Click(object sender, RoutedEventArgs e)
        {
            zahl1 = Convert.ToDouble(txtErgebnis.Text);
            zeichen = '+';
            txtErgebnis.Text = "";
        }

        private void btnMinus_Click(object sender, RoutedEventArgs e)
        {
            zahl1 = Convert.ToDouble(txtErgebnis.Text);
            zeichen = '-';
            txtErgebnis.Text = "";
        }

        private void btnMulti_Click(object sender, RoutedEventArgs e)
        {
            zahl1 = Convert.ToDouble(txtErgebnis.Text);
            zeichen = '*';
            txtErgebnis.Text = "";
        }

        private void btnClear_Click(object sender, RoutedEventArgs e)
        {
            txtErgebnis.Text = "";
        }

        private void btnDiv_Click(object sender, RoutedEventArgs e)
        {
            zahl1 = Convert.ToDouble(txtErgebnis.Text);
            zeichen = '/';
            txtErgebnis.Text = "";
        }
    }
}
