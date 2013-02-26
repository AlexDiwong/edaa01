package sudoku;

import javax.swing.*;

import solver.Solver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GridPanel extends JPanel{
	
	private OneLetterField[][] fields;
	
	public GridPanel(SudokuView view,  OneLetterField[][] fields) {
		this.fields = fields;
		setLayout(new GridLayout(9, 9));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				fields[i][j] = new OneLetterField();
				fields[i][j].setText("0");
				add(fields[i][j]);
			}
		}
		
	}	
}