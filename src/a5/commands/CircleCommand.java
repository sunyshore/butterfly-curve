package a5.commands;

import a5.Turtle;

/**
 * Commands a turtle to draw a circle of non-zero radius.
 * The circle is drawn in clockwise order starting from the
 * turtle's current position. After drawing the circle, the
 * turtle returns to its position and heading that it had
 * immediately before drawing the circle.
 * 
 * <p>
 * A turtle can draw only straight lines so drawing a circle
 * involves drawing a sequence of straight lines to approximate
 * a circle. 
 *
 */
public class CircleCommand extends CompositeCommand {

	/**
	 * The radius of the circle.
	 */
	private double radius;

	/**
	 * Specify the turtle that responds to this command and the radius of the circle.
	 * 
	 * @param t the turtle that responds to this command.
	 * @param radius the radius of the circle.
	 */
	public CircleCommand(Turtle t, double radius) {
		super(t);
		
		if (radius <= 0) {
			throw new IllegalArgumentException("ur stupid");
		}
		this.radius = radius;
		
		int angle = 5; // default is 5 degrees
		double radians = Math.toRadians(angle);
		double rotate = 90.0 - ((180.0 - angle) / 2);
		double chord = Math.sqrt(2 * Math.pow(radius, 2) * (1 - Math.cos(radians)));
		commands.add(new TurnRightCommand(turtle, 90));
		
		for (int theta = 0; theta <= 360; theta = theta + angle) {
			if (theta == 0 || theta + angle == 360) {
				commands.add(new TurnRightCommand(turtle, rotate));
				commands.add(new ForwardCommand(turtle, chord));
			}
			else {
				commands.add(new TurnRightCommand(turtle, angle));
				commands.add(new ForwardCommand(turtle, chord));
				
			}
		}
	}
	
	/**
	 * Returns the radius of the circle drawn by the turtle.
	 * 
	 * @return the radius of the circle drawn by the turtle.
	 */
	public double getRadius() {
		return this.radius;
	}
}
