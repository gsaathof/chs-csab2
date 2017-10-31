public class Cipher {
	private String alpha = "abcdefghijklmnopqrstuvwxyz";
	
	public Cipher(String newAlphabet) {
		// Set the Alphabet
		setAlpha(newAlphabet);
	}
	
	public void setAlpha(String newAlphabet) {
		this.alpha = newAlphabet;
	}
	
	public String encode(String plainText, int key) {
		int alphaIndex = 0;
		int enIndex = 0;
		char ptChar = ' ';
		String encoding = "";
		
		// For each character in the plainText string
		for (int i=0; i<plainText.length(); i++) {
			// Get the plain text character at position 'i'.
			ptChar = plainText.charAt(i);
			
			// Check if the plain text character is a space
			if (ptChar == ' ') {
				// Add a space to the encoding
				encoding = encoding + ' ';
			}
			else {
				// Get the index of the plain text character in the alphabet
				alphaIndex = alpha.indexOf(Character.toLowerCase(ptChar));
				
				// Add the key to the alphabet index
				enIndex = (alphaIndex + key) % alpha.length();
				
				// Store the encrypted characters as a String
				encoding = encoding + alpha.charAt(enIndex);
			}
		}
		return(encoding);
	}
}
