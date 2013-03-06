package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class ClearButton extends JButton implements ActionListener {

	private SudokuView view;
	
/**Best�r av en knapp i gr�nssnitet som ska rensa f�ltet i sudokun*/
	public ClearButton(SudokuView view) {
		super("Clear");
		this.view = view;
		addActionListener(this);
		this.setToolTipText("Rensar F�nstret.");
	}
	
/**Reagerar p� knapptrycket och s�tter f�lten i sukokun till 0
 *@param arg0*/
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				view.fields[j][i].setText("0");
			}
		}
	}	

}
