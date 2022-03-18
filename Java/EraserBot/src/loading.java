import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class loading extends JFrame
{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane2;

	public loading()
	{
		setFont(new Font("Arial", Font.PLAIN, 12));
		setTitle("Loading...");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 176);
		setIconImage(new ImageIcon(this.getClass().getResource("/Mercedes-Benz-Logo.png")).getImage().getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH));
		setLocationRelativeTo(null);
		
		contentPane2 = new JPanel();
		contentPane2.setBackground(Color.WHITE);
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
		JLabel Label = new JLabel("Bitte um etwas Geduld!");
		Label.setFont(new Font("Arial", Font.PLAIN, 15));
		Label.setHorizontalAlignment(SwingConstants.LEFT);
		Label.setBounds(27, 24, 234, 47);
		contentPane2.add(Label);
		
		JLabel lblIchSucheGerade = new JLabel("Ich suche gerade die Dateien f\u00FCr dich...");
		lblIchSucheGerade.setHorizontalAlignment(SwingConstants.LEFT);
		lblIchSucheGerade.setFont(new Font("Arial", Font.PLAIN, 15));
		lblIchSucheGerade.setBounds(27, 62, 285, 47);
		contentPane2.add(lblIchSucheGerade);
		
		Image img1 = new ImageIcon(this.getClass().getResource("/robot-line.png")).getImage();  
		Image imgscaled1 = img1.getScaledInstance(75, 72,  java.awt.Image.SCALE_SMOOTH);  
		ImageIcon newIcon1 = new ImageIcon(imgscaled1);
		
		JLabel Label_1 = new JLabel("");
		Label_1.setIcon(newIcon1);
		Label_1.setHorizontalAlignment(SwingConstants.CENTER);
		Label_1.setBounds(310, 24, 75, 72);
		contentPane2.add(Label_1);				
		
	}
}
