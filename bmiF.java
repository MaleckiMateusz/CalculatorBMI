import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bmiF {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblWaga;
	private JButton btnCalculate;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bmiF window = new bmiF();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bmiF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("BMI Calculator");
		frame.setBounds(100, 100, 265, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblWzrost = new JLabel("Wzrost (cm)");
		
		lblWaga = new JLabel("Waga (kg)");
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float wagaInt = Integer.parseInt(textField_1.getText());
				float wzrostInt = Integer.parseInt(textField.getText());
				wzrostInt /= 100;
				float bmiInt = wagaInt / (wzrostInt * wzrostInt);	
				
				String opisWagi = "";
				if(bmiInt < 16) opisWagi = "wyg³odzenie";
				else if(bmiInt >= 16 && bmiInt < 17) opisWagi = "wychudzenie";
				else if(bmiInt >= 17 && bmiInt < 18.5) opisWagi = "niedowaga";
				else if(bmiInt >= 18.5 && bmiInt < 25) opisWagi = "wartoœæ prawid³owa";
				else if(bmiInt >= 25 && bmiInt < 30) opisWagi = "nadwaga";
				else if(bmiInt >= 30 && bmiInt < 35) opisWagi = "oty³oœæ";
				else if(bmiInt >= 35 && bmiInt < 40) opisWagi = "oty³oœæ kliniczna";
				else if(bmiInt >= 40) opisWagi = "oty³oœæ skrajna";
				
				String bmiStr = String.valueOf(bmiInt);
				label.setText("BMI = " + bmiStr + " " + opisWagi);
				
			}
		});
		
		label = new JLabel("");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnCalculate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblWaga)
										.addComponent(lblWzrost))
									.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(69))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWzrost)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWaga)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addComponent(btnCalculate)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
