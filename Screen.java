package calculate;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * SCREEN - manage the calculator's display.
 */
class Screen extends JPanel {
	public JLabel display;
	public ClearKeyCallback clearKeyListener;
	private boolean startNewNum = true;
	
	/* Constructor */
	public Screen() {
		display = new JLabel("0");
		super.add(display);
		clearKeyListener = new ClearKeyListener();
	}
		
	/* postDigit() - Display a single digit by concatenating */
	public void postDigit(String number) {
		String displayLine = display.getText();
		if (startNewNum) {
			display.setText(number);
			startNewNum = false;
		}
		else {
			if (!displayLine.equals("0")) {
				display.setText(displayLine + number);
			}
		}
	}
	
	/* postResult() - Display an entire value. */
	public void postResult(double value) {
		// Write code that posts a math result to the screen
		display.setText(Double.toString(value));
		startNewNum = true;
	}
	
	/* getValue() - Provide access to the current value on the display */
	public double getValue() {
		double screenValue = Double.parseDouble(display.getText());
		String displayLine = display.getText();
		startNewNum = true;
		return(screenValue);
	}
	
	/* ClearKeyCallback() - Clear the display when "C" key is pressed. */
	class ClearKeyListener implements ClearKeyCallback {
		public void callback() {
			System.out.println("Screen Clear Key Callback");
			System.out.println("Set text to clear");
			display.setText("0");
			startNewNum = true;
		}
	}
}