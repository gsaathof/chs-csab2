package calculate;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * MATH PAD - manage the 4 basic math operations!
 */
class MathPad extends JPanel {
	public ClearKeyCallback clearKeyListener;
	public EqualsKeyCallback equalsKeyListener;
	private String [] keyLabels = {"/","*","-","+"};
	private JButton [] keys = new JButton[4];
	private GridBagConstraints grid = new GridBagConstraints();
	private double accumReg = 0.0;
	private String accumOp = "";
	private Screen screen;
	
	/* Constructor */
	public MathPad() {
		super(new GridBagLayout());
		MathOpKeyPressListener listener = new MathOpKeyPressListener();
		equalsKeyListener = new EqualsKeyListener();
		clearKeyListener = new ClearKeyListener();
		
		// Create 4 math operation keys
		for (int y=0; y<4; y++) {
			JButton button;
			button = new JButton(keyLabels[y]);
			button.addActionListener(listener);
			keys[y] = button;
			grid.gridx = 0;
			grid.gridy = y;
			super.add(keys[y], grid);
		}
	}
	
	public void registerDisplay(Screen display) {
		screen = display;
	}
	
	/* proccessMathOp() - Perform calculations when math keys are pressed */
	private void processMathOp(String mathOpPressed) {
		System.out.print("Process: ");
		if (mathOpPressed == "=") {
			System.out.println("'='");
			processMathOp(accumOp);  // Sets accumReg
			accumOp = ""; // Override and setting made in recursion
		}
		else if (accumOp == "") {
			System.out.println("Set math operation: " + mathOpPressed);
			accumReg = screen.getValue();
			accumOp = mathOpPressed;
		}
		else {
			switch (accumOp) {
			case "/":
				System.out.println("'/'");
				accumReg = accumReg / screen.getValue();
				break;
			case "*":
				System.out.println("'*'");
				accumReg = accumReg * screen.getValue();
				break;
			case "-":
				System.out.println("'-'");
				accumReg = accumReg - screen.getValue();
				break;
			case "+":
				System.out.println("'+'");
				accumReg = accumReg + screen.getValue();
				break;
			default:
				System.out.println("Must implement action for " + mathOpPressed);
				break;
			}
			screen.postResult(accumReg);
			accumOp = mathOpPressed;
		}
	}
	
	/* ClearKeyCallback() - Clear the accumulator when "C" key is pressed. */
	class ClearKeyListener implements ClearKeyCallback {
		public void callback() {
			System.out.println("Math Pad Clear Key Callback");
			accumReg = 0;
			accumOp = "";
		}
	}
	
	class EqualsKeyListener implements EqualsKeyCallback {
		public void callback() {
			processMathOp("=");
		}
	}
	
	class MathOpKeyPressListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			JButton keyPressed = (JButton)evt.getSource();
			processMathOp(keyPressed.getText());
		}
	}
}




