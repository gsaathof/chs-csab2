package calculate;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * MEMORY PAD - Manage the 3 memory keys plus the "=" clear key.
 */
class MemoryPad extends JPanel {
	public EqualsKeyCallback equalsKeyCallback;
	private String [] keyLabels = {" ", "RM", "M+", "="};
	private JButton [] keys = new JButton[4];
	private GridBagConstraints grid = new GridBagConstraints();
	
	/* Constructor */
	public MemoryPad() {
		super(new GridBagLayout());
		MemKeyListener listener = new MemKeyListener();
		
		// Create the memory keys and the '=' key
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
	
	public void registerEqualsKeyCallback(EqualsKeyCallback callback) {
		equalsKeyCallback = callback;
	}
	
	class MemKeyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton keyPressed = (JButton)event.getSource();
			switch (keyPressed.getText()) {
			case "=":
				equalsKeyCallback.callback();
				break;
			default:
				System.out.println("Implement action for " + keyPressed.getText());
				break;
			}
		}
	}
}
