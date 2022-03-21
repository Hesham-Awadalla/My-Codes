import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	static JScrollPane scrollPane;	
	static DefaultListModel<File> listModel = new DefaultListModel<File>();
	static DefaultListModel<String> listModelInfo = new DefaultListModel<String>();	
	static JList<DefaultListModel<File>> list;
	static JList<DefaultListModel<String>> listInfo;
	private JComboBox<String> Dateityp;
	private JComboBox<String> AnzahlMonate;
	
	private JFrame jf = new JFrame();
	
	String path = System.getProperty("user.home");
	
	//Der Konstruktor
	public GUI() throws IOException
	{
		setResizable(false);
		setIconImage(new ImageIcon(this.getClass().getResource("/Mercedes-Benz-Logo.png")).getImage().getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH));
		setTitle("DTO Eraserbot 1.0");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(859, 638);
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
		lblNewLabel_3.setBounds(12, 381, 382, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ergebnisse zeigen");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(657, 382, 180, 30);
		contentPane.add(btnNewButton);
		
		Dateityp = new JComboBox<String>();
		Dateityp.setToolTipText("Select an option");
		Dateityp.setFont(new Font("Arial", Font.PLAIN, 15));
		Dateityp.setModel(new DefaultComboBoxModel<String>(new String[] {"Alle", ".pdf", ".doc", ".docx", ".xlsx", ".pptx", ".csv", ".one"}));
		Dateityp.setBounds(391, 383, 65, 29);
		contentPane.add(Dateityp);
		
		scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(12, 84, 824, 282);
		contentPane.add(scrollPane);
			
		JButton btnNewButton_1 = new JButton("Datei löschen");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(657, 420, 180, 30);
		contentPane.add(btnNewButton_1);
		
		Image img = new ImageIcon(this.getClass().getResource("/DT0.jpg")).getImage();  
		Image imgscaled = img.getScaledInstance(191, 76,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(imgscaled);
		
		JLabel lblNewLabel_1 = new JLabel();
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
		lblNewLabel_2.setBounds(0, 471, 843, 118);
		contentPane.add(lblNewLabel_2);
		
		AnzahlMonate = new JComboBox<String>();
		AnzahlMonate.setToolTipText("Select an option");
		AnzahlMonate.setFont(new Font("Arial", Font.PLAIN, 15));
		AnzahlMonate.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "3", "6", "12"}));
		AnzahlMonate.setBounds(578, 421, 53, 29);
		contentPane.add(AnzahlMonate);
		
		JButton btnNewButton_2 = new JButton("Ordner ausw\u00E4hlen");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_2.setBounds(467, 382, 180, 30);
		contentPane.add(btnNewButton_2);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand() == "Ordner auswählen")
		{	
		
			JFileChooser choose = new JFileChooser();
			choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			choose.setPreferredSize(new Dimension(700, 500));
			choose.setDialogTitle("Ordner auswählen");
			choose.setApproveButtonText("Ordner auswählen");
			choose.showOpenDialog(this);
			
			path = choose.getSelectedFile().getAbsolutePath();
			
		}
		else if (e.getActionCommand() == "Ergebnisse zeigen")
		{			
			
			loading RobotFenster = new loading();
			RobotFenster.setVisible(true);
			RobotFenster.setAlwaysOnTop(true);
			
			String filetype = Dateityp.getSelectedItem().toString();
			int FileAge = Integer.parseInt(AnzahlMonate.getSelectedItem().toString());
			
			//Die DefaultModelLists wieder entleeren.
			//Somit bekommen wir nur die neuen Ergebnisse bei jedem Klick auf "Ergebnisse zeigen"			
			listModel.clear();
			listModelInfo.clear();
			
			SwingUtilities.invokeLater(new Runnable() {
			    public void run()
			    {
			    	try
					{	
			    		
						setTitle("Loading...");
						
						tools.listDir(path, filetype, FileAge);

						list = new JList(listModel);
						listInfo = new JList(listModelInfo);
						listInfo.setEnabled(false);

						scrollPane.setViewportView(list);					
						scrollPane.setRowHeaderView(listInfo);
						
						JLabel label1 = new JLabel("zuletzt geändert am:");
						JLabel label2 = new JLabel("Ergebnisse:  (Es wurden "+ listModel.size() + " Dateien vom Typ '"+ filetype + "' gefunden, die älter als "+ FileAge +
								" Monate sind)");
						label2.setHorizontalAlignment(SwingConstants.CENTER);
						scrollPane.setCorner("UPPER_LEFT_CORNER", label1);
						scrollPane.setColumnHeaderView(label2);
						
						setTitle("DTO Eraserbot 1.0");
											
						RobotFenster.setVisible(false);
						
					}
					catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
			});
			
		}		
		else if(e.getActionCommand() == "Datei löschen")
		{
			//The file(s) to be delete:			
			Object[] f1 = list.getSelectedValues();

			jf.setAlwaysOnTop(true);  //Setting the following JOpionPane/showMessageDialog always on top!
			
			int dialogResult = JOptionPane.showConfirmDialog (jf, "Möchtest du wirklich die Datei(en) löschen?","Warnung", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				try
				{
					for (int i = 0; i < f1.length; i++)
					{
						
						listInfo.setSelectedIndices(list.getSelectedIndices());
						
						File f = new File(f1[i].toString());
						f.delete();
						
						listModel.remove(list.getSelectedIndices()[0]);
						listModelInfo.remove(listInfo.getSelectedIndices()[0]);
					}
					
					
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
