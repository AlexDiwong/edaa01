package sudoku;

import javax.swing.*;

import java.awt.*;


public class GridPanel extends JPanel {
	
	
	
	public GridPanel(SudokuView view,  JTextField[][] fields) {
		setLayout(new GridLayout(9, 9));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[j][i] = new JTextField();
				add(fields[j][i]);
			}
		}
	}

}
