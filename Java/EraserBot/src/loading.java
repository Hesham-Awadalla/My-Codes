import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class loading extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane2;
	
	static JLabel lblRobot;

	public loading()
	{		
		setFont(new Font("Arial", Font.PLAIN, 12));
		setTitle("Loading...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 176);
		setIconImage(new ImageIcon(this.getClass().getResource("/Mercedes-Benz-Logo.png")).getImage().getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH));
		setLocationRelativeTo(null);
		//setAlwaysOnTop(true);
		//setVisible(true);
		
		contentPane2 = new JPanel();
		contentPane2.setBackground(Color.WHITE);
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
		//Ein JLabel mit mehreren Zeilen beschriften, indem man den Text des JLabels in html-Tags packt
		JLabel lblBitteGeduld = new JLabel("<html>Bitte um etwas Geduld<br><br>Ich suche gerade die Dateien für dich...<html>");
		lblBitteGeduld.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBitteGeduld.setHorizontalAlignment(SwingConstants.LEFT);
		lblBitteGeduld.setBounds(27, 24, 273, 72);
		contentPane2.add(lblBitteGeduld);
		
		//Zum Hinzufügen des RoboterIcons während des Suchvorgangs (s. SwingWorker worker2 bei GUI)
		lblRobot = new JLabel();
		lblRobot.setHorizontalAlignment(SwingConstants.CENTER);
		lblRobot.setBounds(310, 24, 75, 72);
		contentPane2.add(lblRobot);
		
	}
}
