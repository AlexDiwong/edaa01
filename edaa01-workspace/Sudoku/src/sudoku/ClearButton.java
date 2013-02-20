package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClearButton extends JButton implements ActionListener {

	private SudokuView view;
	
	public ClearButton(SudokuView view) {
		super("Clear");
		this.view = view;
		addActionListener(this);
		this.setToolTipText("Rensar F�nstret.");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
