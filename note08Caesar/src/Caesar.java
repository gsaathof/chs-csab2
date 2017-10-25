
public class Caesar {

	public static void main(String[] args) {
		// Create an instance of a class called Cipher
		Cipher myCipher = new Cipher();
		
		// Call the method "encode" on the Cipher class
		// passing a String and a key to the encode method.
		// The method returns a string.
		myCipher.encode("dog", 1);
		System.out.println("Test");
	}
}

class Cipher {
	public Cipher() {
		// Do nothing for now.
	}
	public String encode(String plainText, int key) {
		// The meat of the encryption goes here!
		
		// For each character in the plainText string
		
			// index = Get the alphabet index of the plainText character
			
			// Add the key to the alphabet index
			
			// Print the encrypted character (new keyed index)
		
		return("");
	}
}