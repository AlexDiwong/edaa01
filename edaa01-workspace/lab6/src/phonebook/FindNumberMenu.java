package phonebook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class FindNumberMenu extends JMenuItem implements ActionListener {
	
	private PhoneBook pb;
	private PhoneBookGUI view;

	public FindNumberMenu(PhoneBook pb, PhoneBookGUI view) {
		super("Find Number(s)");
		this.pb = pb;
		this.view = view;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.setText("");
		String name = JOptionPane.showInputDialog("Enter Name");
		if(name != null) {
			List<String> nbrs = pb.findNumber(name);
			if(nbrs == null) {
				view.setText(name + " not found!");
			} else {
				String s = name + ":" + "\t"  + nbrs.get(0);
				for(int i = 1; i <nbrs.size(); i++) {
					s = s + "\n" + "\t" + nbrs.get(i);
				}
				view.setText(s);
			}
		} else {
			view.setText("");
		}
	}

}
