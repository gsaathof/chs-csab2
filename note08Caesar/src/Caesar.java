import javax.swing.JOptionPane;

public class Caesar {

	public static void main(String[] args) {
		// Create an instance of a class called Cipher
		Cipher myCipher = new Cipher("abcdefghijklmnopqrstuvwxyz");
		
		// Call the method "encode" on the Cipher class
		// passing a String and a key to the encode method.
		// The method returns a string.
		myCipher.setAlpha("abcdefghijklmnopqrstuvwxyz.!,$%;:");
		System.out.println("Cipher Text = " + myCipher.encode("dog", 1));
		System.out.println("Cipher Text = " + myCipher.encode("z", 1));
		System.out.println("Cipher Text = " + myCipher.encode("what!?:", 10));
		System.out.println("Cipher Text = " + myCipher.encode("The quick brown fox",  18));
		
		CaesarSA Caesar2 = new CaesarSA();
		Caesar2.doit();
	}
}

