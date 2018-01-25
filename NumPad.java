package calculate;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/* 
 * NUM PAD - Manage the 4x3 number pad that includes the 'C' key.
 */
public class NumPad extends JPanel {
	private String [] keyLabels = {"7","8","9","4","5","6","1","2","3","0","C","."};
	private JButton [] keys = new JButton[12];
	private GridBagConstraints grid = new GridBagConstraints();
	private ArrayList<ClearKeyCallback> callbackList = new ArrayList<ClearKeyCallback>();
	private Screen display;
	
	/* Constructor */
	public NumPad() {
		super(new GridBagLayout());
		NumKeyPressListener listener = new NumKeyPressListener();

		// Create 9 keys
		for (int y=0; y<4; y++) {
			JButton button;
			for (int x=0; x<3; x++) {
				button = new JButton(keyLabels[x+3*y]);
				button.addActionListener(listener);
				keys[x+3*y] = button;
				grid.gridx = x;
				grid.gridy = y;
				super.add(keys[x+3*y], grid);
			}
		}
	}
	
	public void registerClearKey(ClearKeyCallback callback) {
		System.out.println("Add Clear Key callback");
		callbackList.add(callback);
		callback.callback();
	}
	
	public void registerDisplay(Screen screen) {
		display = screen;
	}

	class NumKeyPressListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			JButton keyPressed = (JButton)evt.getSource();
			if (keyPressed.getText() == "C") {
				System.out.println("Process Clear Key press. Number of callbacks: " + callbackList.size());
				for (int dex=0; dex<callbackList.size(); dex++) {
					ClearKeyCallback callClass = callbackList.get(dex);
					callClass.callback();
				}
			}
			else {
				display.postDigit(keyPressed.getText());
			}
		}
	}
}