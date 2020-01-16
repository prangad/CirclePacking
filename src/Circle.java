import java.awt.*;
import java.util.ArrayList;

public class Circle {

	private int x, y;
	private double d;
	private boolean isGrowing;

	public Circle(int x, int y)
	{
		this.d = CircleConstants.CIRCLE_START_DIAMETER;
		this.x = (int)(x-(d/2));
		this.y = (int)(y-(d/2));
		this.isGrowing = true;
	}
	
	public void grow()
	{
		if (isGrowing && !touchingEdges())
			this.d += CircleConstants.CIRCLE_GROW_SPEED;
	}
	
	public boolean touchingEdges()
	{
		return (this.x + (d/2) + 1 > 800
				|| this.x - (d/2) - 1 < 0
				|| this.y + (d/2) + 1 > 600
				|| this.y - (d/2) - 1 < 0);
	}
	
	public void draw(Graphics g)
	{
		g.setColor(new Color(80, 80, 80));
		g.fillOval(this.x-(int)(d/2), this.y-(int)(d/2), (int)this.d, (int)this.d);
		g.setColor(CircleConstants.COLORS.get((int)d * 2));
		g.drawOval(this.x-(int)(d/2), this.y-(int)(d/2), (int)this.d, (int)this.d);
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public double getDiameter()
	{
		return this.d;
	}
	
	public boolean getIsGrowing()
	{
		return this.isGrowing;
	}
	
	public void setIsGrowing(boolean isGrowing)
	{
		this.isGrowing = isGrowing;
	}
	
}
