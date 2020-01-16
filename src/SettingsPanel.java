import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsPanel extends JPanel {
	private int width, height;
	
	DecimalFormat df = new DecimalFormat("#.00");
	
	public JButton resetButton;
	public JLabel speedLabel;
	public JSlider speedSlider;
	public JLabel startDiameterLabel;
	public JSlider startDiameterSlider;
	public JLabel fpsLabel;
	public JSlider fpsSlider;
	public JLabel failsLabel;
	public JSlider failsSlider;
	public JLabel framesBetweenCirclesLabel;
	public JSlider framesBetweenCirclesSlider;
	
	public JLabel requiresResetLabel = new JLabel("(Requires Reset)");
	public JLabel completeLabel = new JLabel("COMPLETE!");
	
	public SettingsPanel(int width, int height)
	{
		finishedTimer.start();
		this.width = width;
		this.height = height;
		
		completeLabel.setForeground(Color.RED);
		completeLabel.setVisible(false);
		
		resetButton = new JButton("Reset");
		resetButton.setSize(200, 20);
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CircleApp.reset();
			}
		});
		
		speedSlider = new JSlider();
		speedSlider.setMinimum(1);
		speedSlider.setMaximum(500);
		speedSlider.setValue((int)CircleConstants.CIRCLE_GROW_SPEED * 100);
		speedSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CircleConstants.CIRCLE_GROW_SPEED = (speedSlider.getValue() * 0.01);
				speedLabel.setText("Circle Grow Speed: " + df.format((speedSlider.getValue() * 0.01)));
			}
		});
		
		startDiameterSlider = new JSlider();
		startDiameterSlider.setMinimum(0);
		startDiameterSlider.setMaximum(25);
		startDiameterSlider.setValue(CircleConstants.CIRCLE_START_DIAMETER);
		startDiameterSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CircleConstants.CIRCLE_START_DIAMETER = (startDiameterSlider.getValue());
				startDiameterLabel.setText("Circle Start Diameter: " + (startDiameterSlider.getValue()));
			}
		});
		
		fpsSlider = new JSlider();
		fpsSlider.setMinimum(1);
		fpsSlider.setMaximum(250);
		fpsSlider.setValue(CircleConstants.FRAMES_PER_SECOND);
		fpsSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CircleConstants.FRAMES_PER_SECOND = (fpsSlider.getValue());
				fpsLabel.setText("Frames Per Second: " + (fpsSlider.getValue()));
			}
		});
		
		failsSlider = new JSlider();
		failsSlider.setMinimum(1);
		failsSlider.setMaximum(1000);
		failsSlider.setValue(CircleConstants.CIRCLE_ATTEMPTS_BEFORE_SHUTDOWN);
		failsSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CircleConstants.CIRCLE_ATTEMPTS_BEFORE_SHUTDOWN = (failsSlider.getValue());
				failsLabel.setText("Attempts Before Complete: " + (failsSlider.getValue()));
			}
		});
		
		framesBetweenCirclesSlider = new JSlider();
		framesBetweenCirclesSlider.setMinimum(1);
		framesBetweenCirclesSlider.setMaximum(50);
		framesBetweenCirclesSlider.setValue(CircleConstants.FRAMES_BETWEEN_CIRCLES);
		framesBetweenCirclesSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				CircleConstants.FRAMES_BETWEEN_CIRCLES = (framesBetweenCirclesSlider.getValue());
				framesBetweenCirclesLabel.setText("Frames Between Attempts: " + (framesBetweenCirclesSlider.getValue()));
			}
		});
		
		speedLabel = new JLabel("Circle Grow Speed: " + (speedSlider.getValue() * 0.01));
		startDiameterLabel = new JLabel("Circle Start Diameter: " + (startDiameterSlider.getValue()));
		fpsLabel = new JLabel("Frames Per Second: " + (fpsSlider.getValue()));
		failsLabel = new JLabel("Attempts Before Complete: " + (failsSlider.getValue()));
		framesBetweenCirclesLabel = new JLabel("Frames Between Attempts: " + (framesBetweenCirclesSlider.getValue()));
		
		this.add(resetButton);
		this.add(speedLabel);
		this.add(speedSlider);
		this.add(startDiameterLabel);
		this.add(startDiameterSlider);
		this.add(framesBetweenCirclesLabel);
		this.add(framesBetweenCirclesSlider);
		this.add(failsLabel);
		this.add(failsSlider);
		this.add(fpsLabel);
		this.add(requiresResetLabel);
		this.add(fpsSlider);
		this.add(completeLabel);
	}
	
	Timer finishedTimer = new Timer(100, new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	});
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (CircleConstants.COMPLETE)
		{
			this.setBackground(new Color(150, 255, 170));
			completeLabel.setVisible(true);
		}
		else
		{
			this.setBackground(null);
			completeLabel.setVisible(false);
		};
	}
}
