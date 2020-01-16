import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SettingsFrame extends JFrame{
	public SettingsFrame()
	{
		this.setTitle("Circle Settings");
		this.setSize(200, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Container contentArea = this.getContentPane();
		contentArea.setPreferredSize(new Dimension(200, 600));
		JPanel settingsPanel = new SettingsPanel(200, 600);
		contentArea.add(settingsPanel);
		settingsPanel.requestFocusInWindow();
		
		this.setLocation(this.getX() + 505, this.getY());

		this.setVisible(true);
		this.pack();
	}
}
