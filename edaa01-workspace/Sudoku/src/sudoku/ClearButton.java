package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class ClearButton extends JButton implements ActionListener {

	private SudokuView view;
	
/**Består av en knapp i gränssnitet som ska rensa fältet i sudokun*/
	public ClearButton(SudokuView view) {
		super("Clear");
		this.view = view;
		addActionListener(this);
		this.setToolTipText("Rensar Fönstret.");
	}
	
/**Reagerar på knapptrycket och sätter fälten i sukokun till 0
 *@param arg0*/
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				view.fields[j][i].setText("0");
			}
		}
	}	

}
