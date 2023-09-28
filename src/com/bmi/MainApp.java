package com.bmi;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.Label;
import javax.swing.Box;
@SuppressWarnings("serial")

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textWeight;
	private JTextField textFeet;
	private JTextPane textBMI;
	private JTextField textInches;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
		setTitle("BMI Calculator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -17, 610, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
        ImageIcon imageIcon = new ImageIcon("Image/bmi scale.png");
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(40, 93, 72, 33);
		lblHeight.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblHeight);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(40, 155, 72, 25);
		lblWeight.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblWeight);
		
		JLabel lblBMI = new JLabel("BMI");
		lblBMI.setBounds(67, 210, 45, 25);
		lblBMI.setHorizontalAlignment(SwingConstants.LEFT);
		lblBMI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblBMI);
		
		textWeight = new JTextField();
		textWeight.setBounds(133, 151, 96, 33);
		textWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(textWeight);
		textWeight.setColumns(10);
		
		textFeet = new JTextField();
		textFeet.setBounds(133, 93, 96, 33);
		textFeet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(textFeet);
		textFeet.setColumns(10);
		
		textBMI = new JTextPane();
		textBMI.setEditable(false);
		textBMI.setBounds(133, 210, 96, 33);
		textBMI.setBackground(SystemColor.control);
		textBMI.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(textBMI);
		
		JLabel lblNewLabel_3 = new JLabel("feet");
		lblNewLabel_3.setBounds(239, 93, 45, 25);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("inches");
		lblNewLabel_4.setBounds(422, 99, 45, 13);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("kgs");
		lblNewLabel_5.setBounds(239, 151, 81, 25);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_5);
		
		JLabel resultLabel = new JLabel("");
		resultLabel.setBounds(206, 279, 200, 25);
		resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(resultLabel);

		
		textInches = new JTextField();
		textInches.setBounds(310, 93, 96, 33);
		textInches.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(textInches);
		textInches.setColumns(10);
		
		JButton btnCalculateBMI = new JButton("Compute BMI");
		btnCalculateBMI.setBounds(40, 338, 166, 33);
		btnCalculateBMI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//declaring variables
				double feet, inches, height, weight, BMI;
				
				//exception handling
				try {
					feet=Double.parseDouble(textFeet.getText());
					inches=Double.parseDouble(textInches.getText());
					weight=Double.parseDouble(textWeight.getText());
					
					height=((feet*12)+inches)*0.0254;
					
					BMI = weight / (Math.pow(height, 2));
					
					String bmiCategory = "";
					Color textColor = Color.BLACK;

		            if (BMI < 18.5) {
		                bmiCategory = "You are Underweight";
		                textColor = Color.BLUE;
		            } else if (BMI > 18.5 && BMI < 23) {
		                bmiCategory = "You are Normal";
		                textColor = Color.GREEN;
		            } else if (BMI > 23 && BMI < 25) {
		                bmiCategory = "You are At Risk";
		                textColor = Color.ORANGE;
		            } else if (BMI > 25 && BMI < 30) {
		                bmiCategory = "You are Obese 1";
		                textColor = Color.RED;
		            } else {
		                bmiCategory = "You are Obese 2";
		                textColor = Color.MAGENTA;
		            }
					
					//display the result
					textBMI.setText(String.format("%.2f", BMI));
					resultLabel.setText(bmiCategory);
					resultLabel.setForeground(textColor);
					
				

;					
				}
				catch(Exception e1){
					
					JOptionPane.showInternalMessageDialog(null, "Please enter a valid input");
					
					//clear text
					textBMI.setText(null);
					textFeet.setText(null);
					textInches.setText(null);
					textWeight.setText(null);
					
				}
				
				
			}
		});
		btnCalculateBMI.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnCalculateBMI);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(229, 338, 143, 33);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textBMI.setText(null);
				textFeet.setText(null);
				textInches.setText(null);
				textWeight.setText(null);
				resultLabel.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(403, 339, 143, 31);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("BMI Calculator");
		lblNewLabel.setBounds(204, 10, 202, 41);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 581, 41);
		panel.setBackground(new Color(255, 255, 128));
		contentPane.add(panel);

		
	
		
	}
}
