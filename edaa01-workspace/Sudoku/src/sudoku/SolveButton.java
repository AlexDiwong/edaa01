package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import solver.Solver;

public class SolveButton extends JButton implements ActionListener {

	SudokuView view;
	Solver solver = new Solver();

/**Skapar en knapp som används då sudokun ska lösas*/
	public SolveButton(SudokuView view) {
		super("Solve");
		this.view = view;
		addActionListener(this);
		this.setToolTipText("Lös problemet");
	}

/**Vid knapptryck löses sudokun.
 * param e det ActionEvent som skapas vid knapptryck*/
	public void actionPerformed(ActionEvent e) {
		if (solver.createMatrix(view.fields)) {
			if (solver.solve()) {
				int[][] temp = solver.getSolved();
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						String str = "" + temp[i][j];
						view.fields[i][j].setText(str);
					}
				}
				JOptionPane.showMessageDialog(this,
						"Grattis! Det fanns en lösning!", "Lösning hittad", 1);
			} else {
				System.out.println("fail");
				JOptionPane.showMessageDialog(this,
						"Tyvärr. Den gick inte att lösa.", "Lösning ej hittad",
						1);
			}
		} else {
			JOptionPane.showMessageDialog(this,
					"Du har fyllt i olagligt", "Olaglig ifyllnad", 1);
		}

	}

}
