package ru.ivanov.testtask;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class NavigableFrame extends JFrame {

	protected JPanel contentPane;
	
	public NavigableFrame(String keyResource){
		super(DAOHelper.getResourceText(keyResource));
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setVisible(true);
	}
}
