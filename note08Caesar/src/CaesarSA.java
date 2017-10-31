import javax.swing.JOptionPane;

public class CaesarSA {
	public CaesarSA () {
		// Do nothing for now.
	}
	
	public void doit() {
		boolean stopProgram = false;
		String selection = "";
		
		while (stopProgram == false) {
			// Get the mode from the user
			Object[] options = {"Exit", "Encode", "Decode", "Crack"};
			selection = (String) JOptionPane.showInputDialog(null,
					"Select a mode",
					"Options Menu",
					JOptionPane.PLAIN_MESSAGE,
					null,
					options,
					options[0]);
			System.out.println("You selected: " + selection);
			if (selection == null) {
				System.out.println("Cancelled InputDialog.");
				selection = "Cancel";
			}
	
			switch(selection) {
			case "Exit": 
				System.out.println("Quit program");
				stopProgram = true;
				break;
			
			case "Encode":
				System.out.println("Encode");

				// Create a Cipher object
				Cipher Cipher2 = new Cipher("abcdefghijklmnopqrstuvwxyz.!,$%;:");

				// Get the plain text from the user
				String plainText = JOptionPane.showInputDialog("Enter the plain text");
				System.out.println("Plain text: " + plainText);
				
				// Get the key to use
				Object[] keys = {1,5,12,26};
				int theKey = (int) JOptionPane.showInputDialog(null,
						"Select a Key value", "Key Menu",
						JOptionPane.PLAIN_MESSAGE, null,
						keys, keys[0]);
				System.out.println("Key selected: " + theKey);
							
				// Encode the plain text
				String encoding = Cipher2.encode(plainText, theKey);
				JOptionPane.showMessageDialog(null, "Encoded Text: " + encoding);
				
				break;
				
			case "Decode":
			case "Crack":
			default:
				System.out.println("Not yet implemented");
				
				break;
			}
		}
	}
}
