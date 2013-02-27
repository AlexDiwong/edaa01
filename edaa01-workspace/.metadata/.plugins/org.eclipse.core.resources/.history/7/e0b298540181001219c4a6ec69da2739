package sudoku;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class OneLetterField extends JTextField {

	/**
	 * Creates a text field to display only one letter.
	 */
	public OneLetterField() {
		super("");
		setDocument(new OneNumberDocument());
	}
	
	public void clearField() {
		removeAll();
		setDocument(new OneNumberDocument());
	}
	
	private class OneNumberDocument extends PlainDocument {	   	   
		OneNumberDocument() {	    
			super();
		} 	   

		public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException {	
			if (str.equals("")){
				return;
			}
			if ((getLength() + str.length()) > 1) {
				return;
			}	
			if (!Character.isDigit(str.charAt(0))) {
				return;
			}
			super.insertString(offset, str, attr);	         
		}
	}


}