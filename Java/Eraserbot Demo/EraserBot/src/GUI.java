import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;

public class GUI extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JList list;
	private JComboBox comboBox;
	private JTextArea textArea;
	JScrollPane scrollPane_1;

	//Der Konstruktor
	public GUI() throws IOException
	{
		setResizable(false);
		setIconImage(new ImageIcon(this.getClass().getResource("/Mercedes-Benz-Logo.png")).getImage());
		setTitle("DTO Eraserbot");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(920, 482);
		setLocationRelativeTo(null);
		
		//New JPanel
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Willkommen zum DTO Eraserbot!");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel.setBounds(294, 13, 317, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Bitte gib deine User_ID an:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(12, 13, 234, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nach welchem Dateityp möchtest du suchen?");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(12, 369, 412, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Ergebnisse zeigen");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(350, 401, 198, 30);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 17));
		textField.setBounds(12, 49, 165, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setToolTipText("Select an option");
		comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {".pdf", ".doc", ".docx", ".xlsx", ".csv", ".one"}));
		comboBox.setBounds(12, 402, 149, 28);
		contentPane.add(comboBox);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 84, 599, 282);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		//JScrollPane SP = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		//	ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
			
		JButton btnNewButton_1 = new JButton("Datei l\u00F6schen?");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_1.setBounds(701, 401, 191, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/DT1.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(623, 8, 269, 66);
		contentPane.add(lblNewLabel_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(623, 84, 269, 282);
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane_1);		
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand() == "Ergebnisse zeigen")
			{
				//User_ID ist somit unnötig(?)
				Path HomeDir = Path.of(System.getProperty("user.home"));
				//Path currentDir = Path.of(System.getProperty("user.dir"));			
				String path = HomeDir.toString();
				
				//String path = "C:\\Users\\Hesham M. Awadalla\\OneDrive - it.schule stuttgart";  //Erstmal zum Testen
				//String filetype = ".pdf";
				String filetype = comboBox.getSelectedItem().toString();

				try
					{
						//Die Jlist muss bei jedem click auf dem Button neu geleert werden!!
						// oder einen neuen Buttom "Clear screen" hinzufügen!
						tools.listDir(path, filetype);
						list = new JList(tools.result.toArray());

						scrollPane.setViewportView(list);
						
						textArea = new JTextArea();
						
						for(String a : tools.resultInfo)
							{
							   textArea.append(a + "\n");
							}  //passt noch nicht so ganz!  wäre toll mit nur einem Scrollbar!
						
						scrollPane_1.setViewportView(textArea);
						
					} catch (IOException e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
			}
		else if(e.getActionCommand() == "Datei löschen?")
			{
				//file.delete();
			}
	}
}
