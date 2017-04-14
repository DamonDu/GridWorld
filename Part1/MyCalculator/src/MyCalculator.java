import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class MyCalculator extends JFrame{
	
	private Border border = BorderFactory.createEmptyBorder(5,3,5,3);
	
	private JTextField num1 = new JTextField("");
	private JTextField op = new JTextField("");
	private JTextField num2 = new JTextField("");
	private JTextField equal = new JTextField("=");
	private JTextField result = new JTextField("");
	
	private ActionListener listener = new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			String label = button.getText();
			calculator_process(label);
		}
	};
	
	public MyCalculator(String title) throws HeadlessException {
		super(title);
		setFrame();
		setControls();
	}
	
	private void setFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(100,100);
		this.setSize(400,200);
		this.setResizable(false);
	}
	
	private void setControls() {
		
		JPanel panel = new JPanel();
		panel.setBorder(border);
		panel.setLayout(new GridLayout(2, 5, 3, 3));
		
		op.setEditable(false);
		equal.setEditable(false);
		result.setEditable(false);
		num1.setHorizontalAlignment(JTextField.CENTER);
		op.setHorizontalAlignment(JTextField.CENTER);
		num2.setHorizontalAlignment(JTextField.CENTER);
		equal.setHorizontalAlignment(JTextField.CENTER);
		result.setHorizontalAlignment(JTextField.CENTER);
		
		panel.add(num1);
		panel.add(op);
		panel.add(num2);
		panel.add(equal);
		panel.add(result);
		String[] labels = new String[]{
				"+","-","*","/","OK"
		};
		creatButton(panel, labels);
		
		this.add(panel,BorderLayout.CENTER);
	}
	
	private void creatButton(JPanel panel, String[] labels){
		for (String label : labels){
			if(label.equals("")) {
				panel.add(new JPanel());
			}
			else {
				JButton button = new JButton(label);
				button.addActionListener(listener);
				panel.add(button);
			}
		}
	}
	
	private void calculator_process(String label){
		switch (label) {
		case "+":
			op.setText("+");
			break;
		case "-":
			op.setText("-");
			break;
		case "*":
			op.setText("*");
			break;
		case "/":
			op.setText("/");
			break;
		case "OK":
			calculate();
			break;
		default:
			break;
		}
	}
	
	private void calculate() {
		int firstNum = Integer.parseInt(num1.getText());
		int secondNum = Integer.parseInt(num2.getText());
		String op = this.op.getText();
		switch (op) {
		case "+":
			this.result.setText(String.valueOf(firstNum+secondNum));
			break;
		case "-":
			this.result.setText(String.valueOf(firstNum-secondNum));
			break;
		case "*":
			this.result.setText(String.valueOf(firstNum*secondNum));
			break;
		case "/":
			this.result.setText(String.valueOf(firstNum/secondNum));
			break;
		default:
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		MyCalculator myCalculator = new MyCalculator("Easy Calculator");
		myCalculator.setVisible(true);
	}
	
	
}
