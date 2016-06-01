package ru.ivanov.testtask;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;

public class DataFrame extends NavigableFrame {
	
	private JTable table;

	/**
	 * Create the frame.
	 * @param frame 
	 */
	public DataFrame(JFrame frame) {
		super("dataFrame.title");
		
		table = new JTable();
		contentPane.add(table);
		
		DataStructure structure = DAOHelper.fetchData("select * from emp");
		DefaultTableModel model = new DefaultTableModel(structure.getData(), structure.getColumnNames());
    	table.setModel(model);
	}

}
