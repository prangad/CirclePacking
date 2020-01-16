import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class CirclePanel extends JPanel {
	
	private int width;
	private int height;
	
	ArrayList<Circle> circles;
	
	private int cycleCount = 0;
	Timer animationTimer = new Timer(1000/CircleConstants.FRAMES_PER_SECOND, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			cycleCount++;
			if (cycleCount % CircleConstants.FRAMES_BETWEEN_CIRCLES == 0)
			{
				cycleCount = 0;
				Circle circleToAdd = newCircle();
				if (circleToAdd != null)
					circles.add(circleToAdd);
			}
			
			if(failCounter >= CircleConstants.CIRCLE_ATTEMPTS_BEFORE_SHUTDOWN)
			{
				animationTimer.stop();
				System.out.println("COMPLETE!");
				CircleConstants.COMPLETE = true;
			}
			
			repaint();
		}
	});
	
	public CirclePanel(int width, int height)
	{
		CircleConstants.COMPLETE = false;
		CircleConstants.populateColors();
		circles = new ArrayList<Circle>();
		this.setBackground(new Color(60, 60, 60));
		this.width = width;
		this.height = height;
		
		animationTimer.start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (Circle c : circles)
		{
			c.grow();
			c.draw(g);
			
			for (Circle circle : circles)
			{
				if (c != circle && circle.getIsGrowing())
				{
					int distance = (int)Math.hypot((c.getX()-circle.getX()), (c.getY()-circle.getY()));
					if ((c.getDiameter()/2 + circle.getDiameter()/2)+1 >= distance)
					{
						circle.setIsGrowing(false);
					}
				}
			}
		}
	}
	
	
	private int failCounter = 0;
	public Circle newCircle()
	{
		boolean isValid = true;
		int randX = (int)(Math.random() * width);
		int randY = (int)(Math.random() * height);
		
		for (Circle c : circles)
		{
			int distance = (int)Math.hypot((c.getX()-randX), (c.getY()-randY));
		
			if (distance < c.getDiameter()/2)
			{
				isValid = false;
				break;
			}
		}
		if (isValid)
		{
			failCounter = 0;
			return new Circle(randX, randY);
		}
		else
		{
			failCounter++;
			return null;
		}
	}
	
	public void shutdown()
	{
		animationTimer.stop();
	}
}
