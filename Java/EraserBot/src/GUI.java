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
import javax.swing.DefaultListModel;
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
	private JComboBox Dateityp;
	private JComboBox AnzahlMonate;
	private JTextArea textArea;
	
	private JFrame jf = new JFrame();
	
	DefaultListModel model;

	//Der Konstruktor
	public GUI() throws IOException
	{
		setResizable(false);
		setIconImage(new ImageIcon(this.getClass().getResource("/Mercedes-Benz-Logo.png")).getImage().getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH));
		setTitle("DTO Eraserbot");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(859, 620);
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
		lblNewLabel_3.setBounds(12, 381, 412, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ergebnisse zeigen");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(648, 382, 188, 30);
		contentPane.add(btnNewButton);
		
		Dateityp = new JComboBox();
		Dateityp.setToolTipText("Select an option");
		Dateityp.setFont(new Font("Arial", Font.PLAIN, 15));
		Dateityp.setModel(new DefaultComboBoxModel(new String[] {"Alle", ".pdf", ".doc", ".docx", ".xlsx", ".pptx", ".csv", ".one"}));
		Dateityp.setBounds(402, 384, 149, 28);
		contentPane.add(Dateityp);
		
		scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//Das Gegenteil von:
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 84, 824, 282);
		contentPane.add(scrollPane);
			
		JButton btnNewButton_1 = new JButton("Datei löschen");
		btnNewButton_1.addActionListener(this);
		//btnNewButton_1.addActionListener(createStartTaskActionListener(jf));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(648, 420, 188, 30);
		contentPane.add(btnNewButton_1);
		
		/////
		Image img = new ImageIcon(this.getClass().getResource("/DT0.jpg")).getImage();  
		Image imgscaled = img.getScaledInstance(191, 76,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(imgscaled);
		
		JLabel lblNewLabel_1 = new JLabel();	
		//Die Lücke zwischen Text und Bild negativ setzen, so dass die Komponenten übereinander gezeichnet werden
		//lblNewLabel_1.setIconTextGap(-200);
		//lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/DT0.png")));
		lblNewLabel_1.setIcon(newIcon);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 6, 191, 76);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Wie alt sollen die gesuchten Dateien mindestens sein (in Monaten)?");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(12, 419, 559, 30);
		contentPane.add(lblNewLabel_3_1);
		
		Image img2 = new ImageIcon(this.getClass().getResource("/DT1.svg")).getImage();  
		Image imgscaled2 = img2.getScaledInstance(843, 147,  java.awt.Image.SCALE_SMOOTH);  
		ImageIcon newIcon2 = new ImageIcon(imgscaled2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(newIcon2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 462, 843, 118);
		contentPane.add(lblNewLabel_2);
		
		AnzahlMonate = new JComboBox();
		AnzahlMonate.setToolTipText("Select an option");
		AnzahlMonate.setFont(new Font("Arial", Font.PLAIN, 15));
		AnzahlMonate.setModel(new DefaultComboBoxModel(new String[] {"1", "3", "6", "12"}));
		AnzahlMonate.setBounds(570, 421, 53, 28);
		contentPane.add(AnzahlMonate);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand() == "Ergebnisse zeigen")
		{			
			//////////////
			
//			loading RobotFenster = new loading();
//			RobotFenster.setVisible(true);
//			RobotFenster.setAlwaysOnTop(true);
			
			//////////////
			
			setTitle("Loading...");
			
			Path HomeDir = Path.of(System.getProperty("user.home"));
			//Path currentDir = Path.of(System.getProperty("user.dir"));	
			String path = HomeDir.toString();
			
			//TODO
			//Path per Hand eingeben (zusätzlich/2. Variante)  Wenn leer, eine Rückmeldung geben (getText()isEmpty()
			
			String filetype = Dateityp.getSelectedItem().toString();
			int FileAge = Integer.parseInt(AnzahlMonate.getSelectedItem().toString());
			
			try
			{	
				
				tools.listDir(path, filetype, FileAge);

				list = new JList(tools.result.toArray());				
				listInfo = new JList(tools.resultInfo.toArray());						
				listInfo.setEnabled(false);
				
				//model = (DefaultListModel) list.getModel();

				scrollPane.setViewportView(list);						
				scrollPane.setRowHeaderView(listInfo);
				
				JLabel label1 = new JLabel("zuletzt geändert am:");
				JLabel label2 = new JLabel("Ergebnisse:  (Es wurden "+ tools.result.size() + " Dateien vom Typ '"+ filetype + "' gefunden, die älter als "+ FileAge +
						" Monate sind)");
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
			
			//RobotFenster.setVisible(false);
			setTitle("DTO Eraserbot");
			
		}		
		else if(e.getActionCommand() == "Datei löschen")
		{
			//The file(s) to be delete:			
			Object[] f1 = list.getSelectedValues();

			jf.setAlwaysOnTop(true);  //Setting the following JOpionPane/showMessageDialog always on top!
			
			int dialogResult = JOptionPane.showConfirmDialog (jf, "Möchtest du wirklich die Datei löschen?","Warning", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				try
				{
					for (int i = 0; i < f1.length; i++)
					{
						File f = new File(f1[i].toString());
						f.delete();
						//model.remove(list.getSelectedIndices()[i]);
						
					}
					
					scrollPane.setViewportView(list);
					
					showMessageDialog(jf, "Die Datei(en) wurde(n) erfolgreich gelöscht"); 
				}
				catch (Exception ex)
				{
					showMessageDialog(jf, ex.getMessage());
				}
				
			}
			
		}
	}

}
