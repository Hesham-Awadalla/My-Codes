import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class MyCalculator extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
		{
			EventQueue.invokeLater(new Runnable()
			{
				public void run()
					{
						try
							{
								MyCalculator frame = new MyCalculator();
								frame.setVisible(true);
							} catch (Exception e)
							{
								e.printStackTrace();
							}
					}
			});
		}

	/**
	 * Create the frame.
	 */
	public MyCalculator()
		{
		setTitle("My Calculator");
		setAlwaysOnTop(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 275, 359);
			contentPane = new JPanel();
			contentPane.setBackground(Color.BLACK);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(10, 11, 239, 35);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setBounds(10, 54, 239, 208);
			contentPane.add(panel);
			panel.setLayout(new GridLayout(4, 4, 5, 5));
			
			JButton btnNewButton = new JButton("1");
			btnNewButton.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("2");
			btnNewButton_1.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("3");
			btnNewButton_2.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("+");
			btnNewButton_3.setForeground(Color.RED);
			btnNewButton_3.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_3);
			
			JButton btnNewButton_4 = new JButton("4");
			btnNewButton_4.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_4);
			
			JButton btnNewButton_5 = new JButton("5");
			btnNewButton_5.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_5);
			
			JButton btnNewButton_6 = new JButton("6");
			btnNewButton_6.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_6);
			
			JButton btnNewButton_7 = new JButton("-");
			btnNewButton_7.setForeground(Color.RED);
			btnNewButton_7.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_7);
			
			JButton btnNewButton_8 = new JButton("7");
			btnNewButton_8.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_8);
			
			JButton btnNewButton_9 = new JButton("8");
			btnNewButton_9.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_9);
			
			JButton btnNewButton_10 = new JButton("9");
			btnNewButton_10.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_10);
			
			JButton btnNewButton_11 = new JButton("*");
			btnNewButton_11.setForeground(Color.RED);
			btnNewButton_11.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_11);
			
			JButton btnNewButton_12 = new JButton("0");
			btnNewButton_12.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_12);
			
			JButton btnNewButton_13 = new JButton(".");
			btnNewButton_13.setForeground(Color.RED);
			btnNewButton_13.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_13);
			
			JButton btnNewButton_14 = new JButton("=");
			btnNewButton_14.setForeground(Color.RED);
			btnNewButton_14.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_14);
			
			JButton btnNewButton_15 = new JButton("/");
			btnNewButton_15.setForeground(Color.RED);
			btnNewButton_15.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel.add(btnNewButton_15);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.BLACK);
			panel_1.setBounds(10, 274, 239, 35);
			contentPane.add(panel_1);
			panel_1.setLayout(new GridLayout(0, 3, 5, 5));
			
			JButton btnNewButton_16 = new JButton("+/-");
			btnNewButton_16.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel_1.add(btnNewButton_16);
			
			JButton btnNewButton_17 = new JButton("CLR");
			btnNewButton_17.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel_1.add(btnNewButton_17);
			
			JButton btnNewButton_18 = new JButton("DEL");
			btnNewButton_18.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			panel_1.add(btnNewButton_18);
		}
}
