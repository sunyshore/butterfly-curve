package a5.commands;

import java.awt.Color;

import a5.Turtle;

/**
 * Commands a turtle to draw a butterfly curve. The user gives the number of iterations
 * of the curve and the number of color cycles to display.
 * 
 * @author Me/rcy :D
 *
 */
public class ButterflyCommand extends CompositeCommand{
	
	/**
	 * Specify the turtle that responds to this command, the number of iterations and
	 * color cycles, and the color option to display.
	 * 
	 * @param t the turtle that responds to this command.
	 * @param iter the number of iterations of the butterfly curve to draw.
	 * @param cycles the number of color cycles to display.
	 * @param colorOption the specific color cycle to be displayed.
	 */
	public ButterflyCommand(Turtle t, double iter, double cycles, int colorOption, int scale) {
		super(t);
		
		double x = 0;
		double y = 0;
		double theta = 0;
		
		for (double s = 0; s < iter; s = s + 0.01) {
			
			// tracking the last movement of the turtle
			double oldx = x;
			double oldy = y;
			double oldtheta = theta;
			
			// calculating next point to go to on butterfly curve
			x = Math.sin(s) * (Math.exp(Math.cos(s)) - (2 * Math.cos(4 * s))
					- Math.pow(Math.sin(s / 12), 5));
			y = Math.cos(s) * (Math.exp(Math.cos(s)) - (2 * Math.cos(4 * s))
					- Math.pow(Math.sin(s / 12), 5));
			
			// finding distance from old point to new point
			double deltaX = x - oldx;
			double deltaY = y - oldy;
			double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
			
			// finding angle to rotate by for next move
			theta = Math.toDegrees(Math.atan2(deltaY, deltaX));
			double rotate = theta - oldtheta;
			
			// adding rotation and distance commands
			if (rotate < 0) {
				commands.add(new TurnRightCommand(turtle, -rotate));
			}
			else {
				commands.add(new TurnLeftCommand(turtle, rotate));
			}
			commands.add(new ForwardCommand(turtle, distance / scale));
			
			// adding command to change color
			if (colorOption == 1) { // rainbow colors
				commands.add(new PenColorCommand(turtle,
						ColorCycles.rainbow(s, cycles)));
			}
			else if (colorOption == 2) { // gradient rainbow colors
				commands.add(new PenColorCommand(turtle,
						ColorCycles.gradRainbow(s, iter, cycles)));
				commands.add(new PenRadiusCommand(turtle,
						(float) ((s / iter) + 0.01)));
			}
			else if (colorOption == 3) { // sunset colors
				commands.add(new PenColorCommand(turtle, ColorCycles.sunset(s, cycles)));
			}
			else { // default white color
				commands.add(new PenColorCommand(turtle, new Color(250, 250, 250)));
			}
		}
	}
}
