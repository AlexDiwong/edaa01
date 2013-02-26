package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuView {
	private CommandPanel commandPanel;
	private GridPanel gridPanel;
	OneLetterField[][] fields;
	
	public SudokuView(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
<<<<<<< HEAD
		fields = new OneLetterField[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[j][i] = new OneLetterField();
			}
		}
=======
		fields = new JTextField[9][9];
>>>>>>> df98ee49a55b9104922c26221b9eecb83d4344c1
		
		commandPanel = new CommandPanel(this);
		gridPanel = new GridPanel(this, fields);
		
		frame.add(gridPanel, BorderLayout.NORTH);
		frame.add(commandPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
	
}
