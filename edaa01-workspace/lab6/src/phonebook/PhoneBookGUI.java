package phonebook;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class PhoneBookGUI extends JFrame {
	private PhoneBook phoneBook;
	private JTextArea messageArea;
		
	public PhoneBookGUI(PhoneBook pb) {
		super("PhoneBook");
		phoneBook = pb;
		if(!pb.readFromFile(JOptionPane.showInputDialog("Write a file name:"))) {
			JOptionPane.showMessageDialog(this, "File not found!");
		}
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		Locale.setDefault(new Locale("en"));
		/* To avoid hardcoded Swedish text on OptionPane dialogs */
		UIManager.put("OptionPane.cancelButtonText","Cancel");
		
		setLayout(new BorderLayout());
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		JMenu editMenu = new JMenu("Edit");
		menubar.add(editMenu);
		editMenu.add(new AddMenu(phoneBook,this));
		editMenu.add(new RemoveMenu(phoneBook,this));
		
		JMenu findMenu = new JMenu("Find");
		menubar.add(findMenu);
		findMenu.add(new FindNumberMenu(phoneBook, this));
		findMenu.add(new FindNameMenu(phoneBook, this));
		
		JMenu viewMenu = new JMenu("View");
		menubar.add(viewMenu);
		viewMenu.add(new ShowAllMenu(phoneBook, this));
		
		JPanel southPanel = new JPanel();
		messageArea = new JTextArea(4,25);
		messageArea.setEditable(false);
		southPanel.add(new JScrollPane(messageArea));
		southPanel.add(new QuitButton(phoneBook,this));
		add(southPanel,BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
	public void setText(String s) {
		messageArea.setText(s);
	}
}
