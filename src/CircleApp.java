import java.awt.event.WindowEvent;

import javax.swing.WindowConstants;

public class CircleApp {
	
	static MainFrame mainFrame;
	
	public static void main(String[] args)
	{
		mainFrame = new MainFrame();
		mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		SettingsFrame settingsFrame = new SettingsFrame();
	}
	
	public static void reset()
	{
		mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
		mainFrame = new MainFrame();
		mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
