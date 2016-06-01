package ru.ivanov.testtask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NewAccountFrame extends NavigableFrame {

	/**
	 * Create the frame.
	 */
	public NewAccountFrame(JFrame parentFrame) {
		super("newAccountFrame.title");
		
		JButton button = new JButton("Вернуться назад");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentFrame.setVisible(true);
				NewAccountFrame.this.setVisible(false);
			}
		});
	}

}
