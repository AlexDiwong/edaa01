package sudoku;

import javax.swing.*;

import solver.Solver;
import java.awt.*;

public class SudokuView {
	private CommandPanel commandPanel;
	private GridPanel gridPanel;
	public OneLetterField[][] fields;
	/**Skapar f�nstret och ramen till panelerna samt placerar panelerna som ska ing� inuti ramen.
	 * @param title f�nstrets titel*/
	public SudokuView(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fields = new OneLetterField[9][9];
		
		commandPanel = new CommandPanel(this);
		gridPanel = new GridPanel(this, fields);
		
		frame.add(gridPanel, BorderLayout.NORTH);
		frame.add(commandPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
	
}
