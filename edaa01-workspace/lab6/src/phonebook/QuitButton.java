package phonebook;

import javax.swing.*;
import java.awt.event.*;

public class QuitButton extends JButton implements ActionListener {
	private PhoneBook phoneBook;
	private PhoneBookGUI gui;

	public QuitButton(PhoneBook phoneBook, PhoneBookGUI gui) {
		super("Quit");
		this.phoneBook = phoneBook;
		this.gui = gui;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		switch (JOptionPane.showConfirmDialog(gui,
				"Do you want to save the phonebook to a file?")) {
		case JOptionPane.YES_OPTION:
			phoneBook.writeToFile(JOptionPane.showInputDialog("File name:"));
			break;
		case JOptionPane.CANCEL_OPTION:
			break;
		default:
		System.exit(ABORT);
		}
	}
}
