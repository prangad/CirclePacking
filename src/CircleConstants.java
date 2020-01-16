import java.awt.Color;
import java.util.ArrayList;

public class CircleConstants {

	public static ArrayList<Color> COLORS = new ArrayList<Color>();
	public static int CIRCLE_START_DIAMETER = 1;
	public static double CIRCLE_GROW_SPEED = 1.0;
	public static int FRAMES_BETWEEN_CIRCLES = 1;
	public static int FRAMES_PER_SECOND = 60;
	public static int CIRCLE_ATTEMPTS_BEFORE_SHUTDOWN = 10;
	public static boolean COMPLETE = false;
	
	
	public static void populateColors()
	{
		for (int r=0; r<100; r++)
			COLORS.add(new Color(r*255/100, 255, 0));
		for (int g=100; g>0; g--)
			COLORS.add(new Color(255, g*255/100, 0));
		for (int b=0; b<100; b++)
			COLORS.add(new Color(255, 0, b*255/100));
		for (int r=100; r>0; r--)
			COLORS.add(new Color(r*255/100, 0, 255));
		for (int g=0; g<100; g++)
			COLORS.add(new Color(0, g*255/100, 255));
		for (int b=100; b>0; b--)
			COLORS.add(new Color(0, 255, b*255/100));
		COLORS.add(new Color(0, 255, 0));
	}
}
