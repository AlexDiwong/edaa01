package sudoku;

import javax.swing.*;

import java.awt.*;

public class CommandPanel extends JPanel {
	
	/**Skapar en panel som innehåller två knappar*/
	public CommandPanel(SudokuView view) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(new ClearButton(view));
		add(new SolveButton(view));
	}
}
