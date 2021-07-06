package a5.commands;

import a5.Turtle;

/**
 * Abstract base class for all commands that cause a turtle to
 * walk in a straight line.
 *
 */
public abstract class WalkCommand extends Command {

	/**
	 * The distance to walk the turtle by.
	 */
	protected double distance;
	
	/**
	 * Specify the turtle that responds to this command and the distance to walk the turtle by.
	 * 
	 * @param t the turtle that responds to this command.
	 * @param distance the distance to walk the turtle by.
	 */
	public WalkCommand(Turtle t, double distance) {
		super(t);
		if (distance < 0) {
			throw new IllegalArgumentException("Distance cannot be negative.");
		}
		this.distance = distance;
	}
	
	/**
	 * Get the distance that the turtle walks by.
	 * 
	 * @return the distance that the turtle walks by.
	 */
	public double getDistance() {
		return this.distance;
	}
    
}
