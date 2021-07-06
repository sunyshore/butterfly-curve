package a5.commands;

import a5.Turtle;

/**
 * Commands a turtle to draw a square of non-zero length.
 * The square edges are drawn in clockwise order with the
 * turtle moving forward from its current position and heading.
 *
 */
public class SquareCommand extends CompositeCommand {
	
	/**
	 * The side length of the square.
	 */
	private double length;

	/**
	 * Specify the turtle that responds to this command and the side length of the square.
	 * 
	 * @param t the turtle that responds to this command.
	 * @param length the side length of the square.
	 */
	public SquareCommand(Turtle t, double length) {
		super(t);
		if (length <= 0) {
			throw new IllegalArgumentException("Length must be positive and non-zero.");
		}
		this.length = length;
		commands.add(new ForwardCommand(turtle, length));
		commands.add(new TurnRightCommand(turtle, 90));
		commands.add(new ForwardCommand(turtle, length));
		commands.add(new TurnRightCommand(turtle, 90));
		commands.add(new ForwardCommand(turtle, length));
		commands.add(new TurnRightCommand(turtle, 90));
		commands.add(new ForwardCommand(turtle, length));
	}
	
	/**
	 * Returns the side length of the square drawn by the turtle.
	 * 
	 * @return the side length of the square drawn by the turtle.
	 */
	public double getLength() {
		return this.length;
	}
}
