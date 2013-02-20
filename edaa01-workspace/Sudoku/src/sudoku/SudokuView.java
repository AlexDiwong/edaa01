package sudoku;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuView {
	private CommandPanel commandPanel;
	private GridPanel gridPanel;
	JTextField[][] fields;
	
	public SudokuView(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fields = new JTextField[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[j][i] = new JTextField();
			}
		}
		
		commandPanel = new CommandPanel(this);
		gridPanel = new GridPanel(this, fields);
		
		frame.add(gridPanel, BorderLayout.NORTH);
		frame.add(commandPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
	
}
