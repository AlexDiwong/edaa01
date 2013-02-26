package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import solver.Solver;

public class SolveButton extends JButton implements ActionListener {

	SudokuView view;
	Solver solver = new Solver();
	
	public SolveButton(SudokuView view) {
		super("Solve");
		this.view = view;
		addActionListener(this);
		this.setToolTipText("Lös problemet");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(solver.solve(view.fields)){
			solver.printSudoku();
			int[][] temp = solver.getSolved();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					String str ="" + temp[i][j];
					view.fields[i][j].setText(str);
				}
			}
		} else {
			System.out.println("fail");
			solver.printSudoku();
			
		}

	}

}
