import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CalculatorApp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 2102091302507328034L;

	//initializing 
	static JFrame jFrame;
	static JTextField textField;
	String first, second, operator;
	
	//creating constructor of main class
	CalculatorApp() {
		first = second = operator = "";
	}

	//main method starts
	public static void main(String[] args) throws UnsupportedLookAndFeelException{
		JFrame frame = new JFrame("RahulCal");    //making object of JFrame
		UIManager.setLookAndFeel(UIManager.getLookAndFeel());	//UIManager
		CalculatorApp calculator = new CalculatorApp();   //creating object of claculatorApp class
		textField = new JTextField(16);  // creating object of textfield and display screen 
		textField.setEditable(false); 
		
		//initializing all buttons
		JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
		btnAdd, btnSub, btnMul, btnDiv, btnDot, btnClr, btnEql;
		
		//creating objects of buttons
		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnEql = new JButton("=");
		btnAdd = new JButton("+");
		btnSub = new JButton("-");
		btnMul = new JButton("*");
		btnDiv = new JButton("/");
		btnClr = new JButton("c");
		btnDot = new JButton(".");
		
		//assigning buttons with actionlistener
		btnMul.addActionListener(calculator);
		btnDiv.addActionListener(calculator);
		btnSub.addActionListener(calculator);
		btnClr.addActionListener(calculator);
		btnAdd.addActionListener(calculator);
		btnEql.addActionListener(calculator);
		btnDot.addActionListener(calculator);
		btn9.addActionListener(calculator);
		btn8.addActionListener(calculator);
		btn7.addActionListener(calculator);
		btn6.addActionListener(calculator);
		btn5.addActionListener(calculator);
		btn4.addActionListener(calculator);
		btn3.addActionListener(calculator);
		btn2.addActionListener(calculator);
		btn1.addActionListener(calculator);
		btn0.addActionListener(calculator);
	
		JPanel panel = new JPanel();  //creating object of JPanel
		
		//adding textfield and all buttons in panel
		panel.add(textField); 
		panel.add(btn7);
		panel.add(btn8);
		panel.add(btn9);
		panel.add(btnDiv);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(btnMul);
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btnSub);
		panel.add(btnDot);
		panel.add(btn0);
		panel.add(btnEql);
		panel.add(btnAdd);
		panel.add(btnClr);
	
	    panel.setBackground(Color.RED);
	    frame.add(panel);   // adding panel in frame
	    frame.setSize(230, 250);
	    frame.show();  // make frame visible
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {  //what is action going to performed
		String action = e.getActionCommand();
		//if the value is number
		if((action.charAt(0) >= '0' && action.charAt(0) <='9')  || action.charAt(0) == '.') {
			if(action.equals(".") && first.contains(".")) {
				//no action
			}
			else if(!operator.equals(""))
				second += action;
			else
				first += action;				
				
			textField.setText(first + operator + second);
			
		}else if(action.charAt(0) == 'c') {
			operator = second = "";
			first = "0";
			//set the value of text
			textField.setText(first + operator + second);
		}else if(action.charAt(0) == '=' && !first.equalsIgnoreCase("") && !first.equalsIgnoreCase("")) {
				double result;
				if(operator.equals("+"))
					result = (Double.parseDouble(first) + Double.parseDouble(second));
				else if(operator.equals("-"))
					result = (Double.parseDouble(first) - Double.parseDouble(second));
				else if(operator.equals("/"))
					result = (Double.parseDouble(first) / Double.parseDouble(second));
				else 
					result = (Double.parseDouble(first) * Double.parseDouble(second));
					
				textField.setText(first + operator + second + "=" + result); 
				first = Double.toString(result);
				operator = action;
				second = "";
				
			}else{
				if(operator.equals("") || second.equals(""))
					operator = action;
				else{
					double result;
					if(operator.equals("+"))
						result = (Double.parseDouble(first) + Double.parseDouble(second));
					else if(operator.equals("-"))
						result = (Double.parseDouble(first) - Double.parseDouble(second));
					else if(operator.equals("/"))
						result = (Double.parseDouble(first) / Double.parseDouble(second));
					else 
						result = (Double.parseDouble(first) * Double.parseDouble(second));
						
						first = Double.toString(result);
						operator = action;
						second = "";
				}
				
				
				
			if(first.equals("")) {
			    first = operator = second = "";
		    }else if(second.equals("") && operator.equals("=")) {
				operator = "";
			}
		    textField.setText(first + operator + second); 
		    
           }
	}
}

