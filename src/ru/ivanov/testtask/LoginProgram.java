package ru.ivanov.testtask;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class LoginProgram {

	private JFrame frame;
//	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginProgram window = new LoginProgram();
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
	public LoginProgram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                e.getWindow().dispose();
                DAOHelper.closeConnection();
            }
        });
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Логин");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 85, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Пароль");
		springLayout.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblNewLabel);
		frame.getContentPane().add(label);
		
		final JTextArea textArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, textArea, 13, SpringLayout.EAST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, textArea, -247, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(textArea);
		
		final JPasswordField passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.EAST, label, -6, SpringLayout.WEST, passwordField);
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, textArea);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textArea);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, textArea);
		frame.getContentPane().add(passwordField);
		
		final JLabel lblNewLabel_1 = new JLabel("Успех");
		lblNewLabel_1.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 47, SpringLayout.EAST, passwordField);
		
		JButton button = new JButton("Авторизация");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setVisible(DAOHelper.login(textArea.getText(), 
						String.valueOf(passwordField.getPassword())));
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button, 19, SpringLayout.SOUTH, passwordField);
		springLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, lblNewLabel);
		frame.getContentPane().add(button);
		
		
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton button_1 = new JButton("Открой новое окно");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				NewAccountFrame newWindow = new NewAccountFrame(frame);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 0, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.WEST, button_1, 44, SpringLayout.EAST, button);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Выборка данных");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				DataFrame newWindow = new DataFrame(frame);
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, button_2, 39, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.WEST, button_2, 68, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(button_2);
	}
}
