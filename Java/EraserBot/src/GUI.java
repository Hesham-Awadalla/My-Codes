import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList list;
	private JList listInfo;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JTextField AnzahlMonate;
	
	private JFrame jf = new JFrame();

	//Der Konstruktor
	public GUI() throws IOException
	{
		setResizable(false);
		setIconImage(new ImageIcon(this.getClass().getResource("/Mercedes-Benz-Logo.png")).getImage());
		setTitle("DTO Eraserbot");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(859, 587);
		setLocationRelativeTo(null);
		
		//New JPanel
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Willkommen zum DTO Eraserbot!");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel.setBounds(276, 19, 317, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Nach welchem Dateityp möchtest du suchen?");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(12, 369, 412, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ergebnisse zeigen");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(638, 370, 198, 30);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setToolTipText("Select an option");
		comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {".pdf", ".doc", ".docx", ".xlsx", ".csv", ".one"}));
		comboBox.setBounds(402, 372, 149, 28);
		contentPane.add(comboBox);
		
		scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//Das Gegenteil von:
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 84, 824, 282);
		contentPane.add(scrollPane);
			
		JButton btnNewButton_1 = new JButton("Datei löschen?");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(638, 408, 198, 30);
		contentPane.add(btnNewButton_1);
		
		/////
		Image img = new ImageIcon(this.getClass().getResource("/DT1.jpg")).getImage();  
		Image imgscaled = img.getScaledInstance(260, 70,  java.awt.Image.SCALE_SMOOTH);  
		ImageIcon newIcon = new ImageIcon(imgscaled);
		
		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/DT1.png")));
		lblNewLabel_1.setIcon(newIcon);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 19, 231, 53);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Die gesuchten Dateien m\u00FCssen \u00E4lter als wie viele Monate?");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(12, 407, 490, 30);
		contentPane.add(lblNewLabel_3_1);
		
		AnzahlMonate = new JTextField();
		AnzahlMonate.setFont(new Font("Arial", Font.PLAIN, 17));
		AnzahlMonate.setColumns(10);
		AnzahlMonate.setBounds(501, 407, 49, 30);
		contentPane.add(AnzahlMonate);
		
		Image img2 = new ImageIcon(this.getClass().getResource("/DT2.jpg")).getImage();  
		Image imgscaled2 = img2.getScaledInstance(843, 110,  java.awt.Image.SCALE_SMOOTH);  
		ImageIcon newIcon2 = new ImageIcon(imgscaled2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(newIcon2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 453, 843, 95);
		contentPane.add(lblNewLabel_2);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand() == "Ergebnisse zeigen")
		{			
			//User_ID ist somit unnötig(?)
			Path HomeDir = Path.of(System.getProperty("user.home"));
			//Path currentDir = Path.of(System.getProperty("user.dir"));	
			String path = HomeDir.toString();
			String filetype = comboBox.getSelectedItem().toString();				
			int FileAge = Integer.parseInt(AnzahlMonate.getText());
	
			try
			{
				tools.listDir(path, filetype, FileAge);
				list = new JList(tools.result.toArray());
				listInfo = new JList(tools.resultInfo.toArray());						
				listInfo.setEnabled(false);

				scrollPane.setViewportView(list);						
				scrollPane.setRowHeaderView(listInfo);
				
				JLabel label1 = new JLabel("zuletzt geändert am:");
				JLabel label2 = new JLabel("Ergebnisse");
				label2.setHorizontalAlignment(SwingConstants.CENTER);
				scrollPane.setCorner("UPPER_LEFT_CORNER", label1);
				scrollPane.setColumnHeaderView(label2);
				
				//Die ArrayLists "result" & "resultInfo" wieder entleeren.
				//Somit bekommen wir nur die neuen Ergebnisse bei jedem Klick auf "Ergebnisse zeigen"
				tools.result.clear();
				tools.resultInfo.clear();				
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}		
		else if(e.getActionCommand() == "Datei löschen?")
		{
			//The file to be delete:
			File f= new File(list.getSelectedValue().toString());
			
			jf.setAlwaysOnTop(true);  //Setting the following JOpionPane/showMessageDialog always on top!
			
			int dialogResult = JOptionPane.showConfirmDialog (jf, "Möchtest du wirklich die Datei löschen?","Warning", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				if(f.delete()) 
				{  
					showMessageDialog(jf, (f.getName() + " erfolgreich gelöscht")); 
				}  
				else  
				{  
					showMessageDialog(jf, "Fehlermeldung!");
				}  
			}
			
		}
	}
}
