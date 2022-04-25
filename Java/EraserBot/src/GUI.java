import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.Desktop;
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
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	static JScrollPane scrollPane;	
	static DefaultListModel<File> listModel = new DefaultListModel<File>();
	static DefaultListModel<String> listModelInfo = new DefaultListModel<String>();
	static JList<DefaultListModel<File>> list = new JList(listModel);
	static JList<DefaultListModel<String>> listInfo = new JList(listModelInfo);
	private JComboBox<String> Dateityp, AnzahlMonate;
	
	private JFrame jf = new JFrame();
	
	String path = System.getProperty("user.home");
	
	//RoboterIcon:
	Image Robot = new ImageIcon(this.getClass().getResource("/robot-line.png")).getImage();  
	Image RobotScaled = Robot.getScaledInstance(75, 72,  java.awt.Image.SCALE_SMOOTH);  
	ImageIcon RobotIcon = new ImageIcon(RobotScaled);
	
	//RoboterIcon beim Zwinkern:
	Image zwinkern = new ImageIcon(this.getClass().getResource("/robot-line2.png")).getImage();  
	Image zwinkernSscaled = zwinkern.getScaledInstance(75, 72,  java.awt.Image.SCALE_SMOOTH);  
	ImageIcon zwinkernIcon = new ImageIcon(zwinkernSscaled);
	
	//TrashIcon
	Image trash = new ImageIcon(this.getClass().getResource("/trash-icon.png")).getImage();
	Image trashSscaled = trash.getScaledInstance(23, 23,  java.awt.Image.SCALE_SMOOTH); 
	ImageIcon trashIcon = new ImageIcon(trashSscaled);
	
	loading RobotFenster = new loading();
	
	//Vom ScrollPane zum Hinzufügen der Überschriften "Zuletzt geändert am" und "Ergebnisse:  ":
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	
	//Ein Ergebnis-Label
	JLabel lblErgebnisse = new JLabel();
	
	//Der Konstruktor
	public GUI() throws IOException
	{
		setResizable(false);
		setIconImage(new ImageIcon(this.getClass().getResource("/Mercedes-Benz-Logo.png")).getImage().getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH));
		setTitle("DTO Eraserbot 1.3");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(859, 665);
		setLocationRelativeTo(null);
		
		//New JPanel
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWillkommen = new JLabel("Willkommen zum DTO Eraserbot!");
		lblWillkommen.setFont(new Font("Arial", Font.PLAIN, 21));
		lblWillkommen.setBounds(276, 19, 317, 53);
		contentPane.add(lblWillkommen);
		
		JLabel lblDateityp = new JLabel("Nach welchem Dateityp möchtest du suchen?");
		lblDateityp.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDateityp.setBounds(12, 381, 382, 30);
		contentPane.add(lblDateityp);
		
		Dateityp = new JComboBox<String>();
		Dateityp.setToolTipText("Select an option");
		Dateityp.setFont(new Font("Arial", Font.PLAIN, 15));
		Dateityp.setModel(new DefaultComboBoxModel<String>(new String[] {"Alle", ".pdf", ".doc", ".docx", ".xlsx", ".pptx", ".csv", ".one"}));
		Dateityp.setBounds(391, 383, 65, 29);
		contentPane.add(Dateityp);
		
		scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//Das Gegenteil von:
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 84, 824, 282);
		contentPane.add(scrollPane);
		
		JButton btnOrdnerAuswahl = new JButton("Ordner auswählen");
		btnOrdnerAuswahl.addActionListener(this);
		btnOrdnerAuswahl.setFont(new Font("Arial", Font.PLAIN, 15));
		btnOrdnerAuswahl.setBounds(467, 382, 180, 30);
		contentPane.add(btnOrdnerAuswahl);
		
		JButton btnErgebnisse = new JButton("Ergebnisse zeigen");
		btnErgebnisse.addActionListener(this);
		btnErgebnisse.setFont(new Font("Arial", Font.PLAIN, 15));
		btnErgebnisse.setBounds(656, 382, 180, 30);
		contentPane.add(btnErgebnisse);
			
		JButton btnLoeschen = new JButton("Endgültig löschen");
		btnLoeschen.addActionListener(this);
		btnLoeschen.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLoeschen.setBounds(656, 420, 180, 30);
		contentPane.add(btnLoeschen);
		
		JButton btnRecyceln = new JButton("Recyceln");
		btnRecyceln.setIcon(trashIcon);
		btnRecyceln.addActionListener(this);
		btnRecyceln.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRecyceln.setBounds(656, 458, 180, 30);
		contentPane.add(btnRecyceln);
		
		Image logo = new ImageIcon(this.getClass().getResource("/DT0.jpg")).getImage();  
		Image logoScaled = logo.getScaledInstance(191, 76,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon logoIcon = new ImageIcon(logoScaled);
		
		JLabel lblLogo = new JLabel();	
		lblLogo.setIcon(logoIcon);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(12, 6, 191, 76);
		contentPane.add(lblLogo);
		
		JLabel lblDateiAlter = new JLabel("Wie alt sollen die gesuchten Dateien mindestens sein (in Monaten)?");
		lblDateiAlter.setFont(new Font("Arial", Font.PLAIN, 18));
		lblDateiAlter.setBounds(12, 419, 559, 30);
		contentPane.add(lblDateiAlter);
		lblErgebnisse.setForeground(Color.RED);
		
		lblErgebnisse.setFont(new Font("Arial", Font.ITALIC, 17));
		lblErgebnisse.setBounds(12, 457, 635, 30);
		contentPane.add(lblErgebnisse);
		
		Image banner = new ImageIcon(this.getClass().getResource("/DT2.jpg")).getImage();  
		Image bannerScaled = banner.getScaledInstance(855, 143,  java.awt.Image.SCALE_SMOOTH);  
		ImageIcon bannerIcon = new ImageIcon(bannerScaled);
		
		JLabel lblBanner = new JLabel("");
		lblBanner.setIcon(bannerIcon);
		lblBanner.setHorizontalAlignment(SwingConstants.CENTER);
		lblBanner.setBounds(0, 498, 843, 118);
		contentPane.add(lblBanner);
		
		AnzahlMonate = new JComboBox<String>();
		AnzahlMonate.setToolTipText("Select an option");
		AnzahlMonate.setFont(new Font("Arial", Font.PLAIN, 15));
		AnzahlMonate.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "3", "6", "12"}));
		AnzahlMonate.setBounds(578, 421, 53, 29);
		contentPane.add(AnzahlMonate);		
	
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
			//Die DefaultModelLists wieder entleeren.
			//Somit bekommen wir nur die neuen Ergebnisse bei jedem Klick auf "Ergebnisse zeigen"			
			listModel.clear();
			listModelInfo.clear();
			
			//JScrollPane-Bereiche befüllen: (s. Foto im Resources-Ordner)
			scrollPane.setCorner("UPPER_LEFT_CORNER", label1);
			scrollPane.setColumnHeaderView(label2);
			
			//Die Beschriftung der Labels immer am Anfang zurücksetzen:
			label1.setText("");
			label2.setText("Loading...");
			label2.setHorizontalAlignment(SwingConstants.CENTER);
			lblErgebnisse.setText("");		
			
			//Damit man nur die Dateien markieren kann (relevant beim Löschen nachher)
			listInfo.setEnabled(false);
			
			//Das Loading-Fensterchen anzeigen lassen
			RobotFenster.setVisible(true);
			RobotFenster.setAlwaysOnTop(true);
			
			//Ermittlung des ausgewählten Dateityps und Dateialters
			String filetype = Dateityp.getSelectedItem().toString();
			int FileAge = Integer.parseInt(AnzahlMonate.getSelectedItem().toString());
			
			//Da der Suchvorgang zeitintensiv sein könnte, benutzen wir den SwingWorker:
			SwingWorker<Void, Void> worker = new SwingWorker <Void, Void>()		
			{
				@Override
				protected Void doInBackground() throws Exception 
				{
					try
					{
				
					tools.listDir(path, filetype, FileAge);
					
					//Die Beschriftung der Labels aktualisieren:
					label1.setText("zuletzt geändert am:");
					label2.setText("Die Ergebnisse");				
					lblErgebnisse.setText("Es wurden "+ listModel.size() + " Dateien vom Typ '"+ filetype + "' gefunden, die älter als "+ FileAge +
							" Monate sind");
					
					//Die restlichen JScrollPane-Bereiche befüllen: (s. Foto im Resources-Ordner)
					scrollPane.setViewportView(list);					
					scrollPane.setRowHeaderView(listInfo);
					
					//LoadingFenster wieder schließen
					RobotFenster.setVisible(false);					

					}
					catch (Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					return null;
				}
		
			};
			
			//Noch ein SwingWorker zum Zwinkern-Effekt des Roboter während des Suchvorgangs:
			SwingWorker<Void, Void> worker2 = new SwingWorker <Void, Void>()		
			{
				@Override
				protected Void doInBackground() throws Exception 
				{
					try
					{						
						while (!worker.isDone())
						{   
							loading.lblRobot.setIcon(RobotIcon);
							Thread.sleep(2900);
							loading.lblRobot.setIcon(zwinkernIcon);
							Thread.sleep(700);
							
						};

					}
					catch (Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					return null;
				}
		
			};
			
			//Die SwingWorkers 1 & 2 starten:
			worker.execute();		
			worker2.execute();
			
		}		
		else if(e.getActionCommand() == "Endgültig löschen" || e.getActionCommand() == "Recyceln")
		{
			//Die Pfade der aus der Ergebnis-Liste ausgewählten/markierten Datei(en) in einem Object[] speichern	
			Object[] selectedFiles = list.getSelectedValues();

			jf.setAlwaysOnTop(true);  //Setting the following MessageDialog always on top
			
			//Dem JFrame(jf) wird der JOptionPane übergeben 
			int dialogResult = JOptionPane.showConfirmDialog (jf, "Möchtest du wirklich die Datei(en) "+e.getActionCommand()+"?","Warnung", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				try
				{
					for (int i = 0; i < selectedFiles.length; i++)
					{
						//Die Indices der "Zuletzt geändert am"-Liste gleichsetzen mit denen
						//von den gewählten Indices der "Ergebnis"-Liste
						//Deswegen: listInfo.setEnabled(false);
						listInfo.setSelectedIndices(list.getSelectedIndices());
						
						//Aus den Pfaden werden File-Objekten erstellt (die gelöscht werden können)
						File f = new File(selectedFiles[i].toString());
						
						if(e.getActionCommand() == "Endgültig löschen")
						{
							//Die Datei(en) endgültig löschen
							f.delete();
						}
						else if (e.getActionCommand() == "Recyceln")
						{
							//Die Datei(en) in den Papierkorb verschieben
							Desktop.getDesktop().moveToTrash(f);
						}
						
						//Die ausgewählten Elemente ebenfalls aus den listModel "Ergebnisse" & listModelInfo "zuletzt geändert am"
						//löschen, um diese zu aktualisieren
						listModel.remove(list.getSelectedIndices()[0]);
						listModelInfo.remove(listInfo.getSelectedIndices()[0]);
					}
					
					//Der Benutzer wird informiert, dass die Datei(en) gelöscht worden sind
					showMessageDialog(jf, e.getActionCommand()+" der Datei(en) war erfolgreich!"); 
				}
				catch (Exception ex)
				{
					//Andernfalls die entsprechende Fehler-Benachrichtigung
					showMessageDialog(jf, ex.getMessage());
				}
				
			}
			
		}
	}
}
