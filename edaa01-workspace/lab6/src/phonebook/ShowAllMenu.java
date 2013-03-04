package phonebook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JMenuItem;

public class ShowAllMenu extends JMenuItem implements ActionListener {
	
	private PhoneBook pb;
	private PhoneBookGUI view;
	
	public ShowAllMenu(PhoneBook pb, PhoneBookGUI view) {
		super("Show All");
		this.pb = pb;
		this.view = view;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(pb.isEmpty()) {
			view.setText("PhoneBook empty!");
		} else {
			String s = "";
			Set<String> names = pb.names();
			for (String name : names) {
				s = s + name + ":";
				List<String> nbrs = pb.findNumber(name);
				for(String nbr : nbrs) {
					s = s + "\t" + nbr + "\n";
				}
			}
			view.setText(s);
		}
		

	}

}
