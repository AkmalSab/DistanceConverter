import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class DistanceConverter implements ActionListener{

	public double input, conversion;
	public String message;
	JFrame frame = new JFrame("Distance Converter");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	JTextField box1 = new JTextField(10);
	
	JLabel label1 = new JLabel("Enter a distance in kilometers:");
	
	JRadioButton rb1 = new JRadioButton("Convert to miles");
	JRadioButton rb2 = new JRadioButton("Convert to feet");
	JRadioButton rb3 = new JRadioButton("Convert to inches");
	
	ButtonGroup group = new ButtonGroup();	
	
	JButton button1 = new JButton("Calculate");
	JButton button2 = new JButton("Close");
	
	public DistanceConverter() {
		input = 0;
		conversion = 0;
	}
	
	public void createAndShowGui() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());		
		
		box1.addActionListener(this);
		box1.setActionCommand("box1");
		rb1.setActionCommand("rb1");
		rb2.setActionCommand("rb2");
		rb3.setActionCommand("rb3");
		
		
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		
		button1.addActionListener(this);
		
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.SOUTH);
		
		panel1.add(label1);
		panel1.add(box1);
		panel2.add(rb1);
		panel2.add(rb2);
		panel2.add(rb3);
		panel3.add(button1);
		panel3.add(button2);
		
		button2.addActionListener(e -> {
	         frame.dispose();
	      });
	}
	
	public void actionPerformed(ActionEvent e) {
		input = Double.parseDouble(box1.getText());	
			if(group.getSelection().getActionCommand() == "rb1") {				
				conversion = input * 0.6214;
				message = input + " Kilometer is " + conversion + " miles";
			}
			else if(group.getSelection().getActionCommand() == "rb2") {
				conversion = input * 3281.0;
				message = input + " Kilometer is " + conversion + " feet";
			}
			else if(group.getSelection().getActionCommand() == "rb3") {
				conversion = input * 39370.0;
				message = input + " Kilometer is " + conversion + " inches";
			}
			JOptionPane.showMessageDialog(frame,message);
	}	
	
	public static void main(String[] args) {
		DistanceConverter dc = new DistanceConverter();
		dc.createAndShowGui();
	}
}
