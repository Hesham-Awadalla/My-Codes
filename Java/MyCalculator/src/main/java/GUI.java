import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;

import net.objecthunter.exp4j.ExpressionBuilder;

public class GUI extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private double result;
	private JButton btnPunkt;
	
	net.objecthunter.exp4j.Expression expression;

	//Create the GUI	
	public GUI()
		{
			setResizable(false);
			setTitle("My Calculator");
			setAlwaysOnTop(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 273, 373);
			//setSize + setLocationRelativeTo(null) ?
			
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 0, 51));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			textField = new JTextField();			
			textField.setEditable(false);
			textField.setFont(new Font("Digital-7 Italic", Font.PLAIN, 25));
			textField.setBounds(10, 11, 239, 47);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JPanel Tastenfeld = new JPanel();
			Tastenfeld.setBackground(new Color(0, 0, 51));
			Tastenfeld.setBounds(10, 69, 239, 208);
			contentPane.add(Tastenfeld);
			Tastenfeld.setLayout(new GridLayout(0, 4, 5, 5));
			
			JButton btn7 = new JButton("7");
			btn7.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn7);
			btn7.addActionListener(this);
			
			JButton btn8 = new JButton("8");
			btn8.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn8);
			btn8.addActionListener(this);
			
			JButton btn9 = new JButton("9");
			btn9.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn9);
			btn9.addActionListener(this);
			
			JButton btnMulti = new JButton("x");
			btnMulti.setForeground(Color.RED);
			btnMulti.setFont(new Font("Palatino Linotype", Font.ITALIC, 17));
			Tastenfeld.add(btnMulti);
			btnMulti.addActionListener(this);
			
			//Button 4
			JButton btn4 = new JButton("4");
			btn4.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn4);
			btn4.addActionListener(this);
			
			//Button 5
			JButton btn5 = new JButton("5");
			btn5.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn5);
			btn5.addActionListener(this);
			
			JButton btn6 = new JButton("6");
			btn6.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn6);
			btn6.addActionListener(this);
			
			JButton btnDiv = new JButton("/");
			btnDiv.setForeground(Color.RED);
			btnDiv.setFont(new Font("Palatino Linotype", Font.ITALIC, 17));
			Tastenfeld.add(btnDiv);
			btnDiv.addActionListener(this);		
			
			//Button 1
			JButton btn1 = new JButton("1");
			btn1.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn1);
			btn1.addActionListener(this);
			
			//Button 2
			JButton btn2 = new JButton("2");
			btn2.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn2);
			btn2.addActionListener(this);
			
			//Button 3
			JButton btn3 = new JButton("3");
			btn3.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn3);
			btn3.addActionListener(this);
			
			JButton btnPlus = new JButton("+");
			btnPlus.setForeground(Color.RED);
			btnPlus.setFont(new Font("Palatino Linotype", Font.ITALIC, 17));
			Tastenfeld.add(btnPlus);
			btnPlus.addActionListener(this);
					
			JButton btn0 = new JButton("0");
			btn0.setFont(new Font("Digital-7 Italic", Font.PLAIN, 19));
			Tastenfeld.add(btn0);
			btn0.addActionListener(this);
			
			btnPunkt = new JButton(".");
			btnPunkt.setForeground(Color.RED);
			btnPunkt.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
			Tastenfeld.add(btnPunkt);
			btnPunkt.addActionListener(this);
	
			JButton btnEquals = new JButton("=");
			btnEquals.setForeground(Color.RED);
			btnEquals.setFont(new Font("Palatino Linotype", Font.ITALIC, 18));
			Tastenfeld.add(btnEquals);
			btnEquals.addActionListener(this);
															
			JButton btnMinus = new JButton("-");
			btnMinus.setForeground(Color.RED);
			btnMinus.setFont(new Font("Palatino Linotype", Font.ITALIC, 17));
			Tastenfeld.add(btnMinus);
			btnMinus.addActionListener(this);
			
			JPanel Tastenfeld2 = new JPanel();
			Tastenfeld2.setBackground(new Color(0, 0, 51));
			Tastenfeld2.setBounds(10, 284, 239, 39);
			contentPane.add(Tastenfeld2);
			Tastenfeld2.setLayout(new GridLayout(0, 3, 5, 5));
			
			JButton btnAns = new JButton("Ans");
			btnAns.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			Tastenfeld2.add(btnAns);
			btnAns.addActionListener(this);
			
			JButton btnDel = new JButton("DEL");
			btnDel.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			Tastenfeld2.add(btnDel);
			btnDel.addActionListener(this);
			
			JButton btnCLR = new JButton("CLR");
			btnCLR.setFont(new Font("Palatino Linotype", Font.ITALIC, 15));
			Tastenfeld2.add(btnCLR);
			btnCLR.addActionListener(this);
						
		}
	
	//ActionListener
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand() == "1")
			{
				textField.setText(textField.getText() + "1");
			}
		else if (e.getActionCommand() == "2")
			{
				textField.setText(textField.getText() + "2");
			}
		else if (e.getActionCommand() == "3")
			{
				textField.setText(textField.getText() + "3");
			}
		else if (e.getActionCommand() == "4")
			{
				textField.setText(textField.getText() + "4");
			}
		else if (e.getActionCommand() == "5")
			{
				textField.setText(textField.getText() + "5");
			}
		else if (e.getActionCommand() == "6")
			{
				textField.setText(textField.getText() + "6");
			}
		else if (e.getActionCommand() == "7")
			{
				textField.setText(textField.getText() + "7");
			}
		else if (e.getActionCommand() == "8")
			{
				textField.setText(textField.getText() + "8");
			}
		else if (e.getActionCommand() == "9")
			{
				textField.setText(textField.getText() + "9");
			}
		else if (e.getActionCommand() == "0")
			{
				textField.setText(textField.getText() + "0");
			}
		else if (e.getActionCommand() == "+")
			{
				textField.setText(textField.getText() + "+");
			}
		else if (e.getActionCommand() == "-")
			{
				textField.setText(textField.getText() + "-");
			}
		else if (e.getActionCommand() == "x")
			{
				textField.setText(textField.getText() + "*");
			}
		else if (e.getActionCommand() == "/")
			{
				textField.setText(textField.getText() + "/");
			}
		else if (e.getActionCommand() == ".")
			{
				textField.setText(textField.getText() + ".");
				btnPunkt.setEnabled(false);  //was ist mit DEL??
			}
		else if (e.getActionCommand() == "DEL")
			{
				try
					{
						textField.setText(textField.getText(0, textField.getText().length()-1));
					} catch (BadLocationException e1)
					{
						e1.printStackTrace();
					}
			}
		else if (e.getActionCommand() == "CLR")
			{
				textField.setText("");
				btnPunkt.setEnabled(true);
			}
		else if (e.getActionCommand() == "=")
			{
				try
					{
						expression = new ExpressionBuilder(textField.getText()).build();
					    result = expression.evaluate();			    
						textField.setText(String.valueOf(result));
						btnPunkt.setEnabled(true);
					} catch (ArithmeticException a)
					{
						textField.setText("Error");
					}
				//
			}
		else if (e.getActionCommand() == "Ans")
			{
				textField.setText(String.valueOf(result));
			}
		
	}
}
