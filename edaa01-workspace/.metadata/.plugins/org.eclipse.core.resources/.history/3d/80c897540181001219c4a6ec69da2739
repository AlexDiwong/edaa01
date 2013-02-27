package sudoku;

import javax.swing.*;

import java.awt.*;

public class GridPanel extends JPanel{
	
	private OneLetterField[][] fields;
	
	public GridPanel(SudokuView view,  OneLetterField[][] fields) {
		this.fields = fields;
		setLayout(new GridLayout(9, 9));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[i][j] = new OneLetterField();
				fields[i][j].setText("0");
				if(i/3 != 1 && j/3 != 1 || i/3 == 1 && j/3 == 1) {
					fields[i][j].setBackground(new Color(192, 192, 192));
				}
				add(fields[i][j]);
			}
		}
		
	}	
}