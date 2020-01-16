import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

public class MainFrame extends JFrame {
	public MainFrame()
	{
		this.setTitle("Circle Test Application");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		Container contentArea = this.getContentPane();
		contentArea.setPreferredSize(new Dimension(800, 600));
		CirclePanel circlePanel = new CirclePanel(800, 600);
		contentArea.add(circlePanel);
		circlePanel.requestFocusInWindow();
		
		this.addWindowListener(new WindowListener(){
			public void windowClosing(WindowEvent e) {
				circlePanel.shutdown();
			}
			public void windowActivated(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowOpened(WindowEvent e) {}
			
		});
		
		this.setVisible(true);
		this.pack();
	}
}
