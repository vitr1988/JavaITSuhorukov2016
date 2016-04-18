package ru.suhorukov.desktopdevelopment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;

public class GuiTest {

	private JFrame frmHelloWorldgfsmjoisd;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiTest window = new GuiTest();
					window.frmHelloWorldgfsmjoisd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHelloWorldgfsmjoisd = new JFrame("Hello World");
		frmHelloWorldgfsmjoisd.setTitle("Hello Worldgfsmjoisd");
//		frame.setBounds(100, 100, 450, 300);
		frmHelloWorldgfsmjoisd.setSize(400, 200);
		frmHelloWorldgfsmjoisd.setLocationRelativeTo(null);
		frmHelloWorldgfsmjoisd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frmHelloWorldgfsmjoisd.getContentPane();
		SpringLayout springLayout = new SpringLayout();
		frmHelloWorldgfsmjoisd.getContentPane().setLayout(springLayout);
		
		final JLabel lblNewLabel = new JLabel("Текст приветствия");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 38, SpringLayout.WEST, frmHelloWorldgfsmjoisd.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -28, SpringLayout.SOUTH, frmHelloWorldgfsmjoisd.getContentPane());
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Push me");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 23, SpringLayout.NORTH, frmHelloWorldgfsmjoisd.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frmHelloWorldgfsmjoisd.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText(textField.getText());
			}
		});
		btnNewButton.setBounds(10, 10, 50, 50);
//		btnNewButton.setSize(50, 50);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField, 31, SpringLayout.WEST, frmHelloWorldgfsmjoisd.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, btnNewButton);
		frmHelloWorldgfsmjoisd.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
