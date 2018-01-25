package calculate;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 *
 * CALC - The main class
 *
 */
public class Calc {
	private NumPad numKeys;
	private Frame frame;
	private Screen screen;
	private MathPad mathKeys;
	private MemoryPad memKeys;
	
	/*
	 * MAIN () - The entry point into the program
	 */
	public static void main(String[] args) {
		Calc calculator = new Calc();
		calculator.poweron();
	}

	/*
	 * Constructor - Create all the Swing frames, panels, widgets
	 */
	public Calc() {
		frame = new Frame();
		screen = new Screen();
		numKeys = new NumPad();
		memKeys = new MemoryPad();
		mathKeys = new MathPad();
		
		numKeys.registerDisplay(screen);
		mathKeys.registerDisplay(screen);
		// memKeys.registerDisplay(screen);  Not yet implemented / needed.
		
		numKeys.registerClearKey(screen.clearKeyListener);
		numKeys.registerClearKey(mathKeys.clearKeyListener);
		memKeys.registerEqualsKeyCallback(mathKeys.equalsKeyListener);

		frame.add(screen, BorderLayout.NORTH);
		frame.add(numKeys, BorderLayout.WEST);
		frame.add(mathKeys, BorderLayout.CENTER);
		frame.add(memKeys, BorderLayout.EAST);
		frame.setTitle("Calculator");
		frame.pack();
	}
	
	public void poweron() {
		frame.showIt();
	}
}
	

/*
 * FRAME - Manage the main calculator window
 */
class Frame extends JFrame {
	public Frame() {
		// Do nothing for now.
	}
	public void showIt() {
		super.setVisible(true);
	}
}
