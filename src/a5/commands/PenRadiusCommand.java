package a5.commands;

import a5.Turtle;

/**
 * Command that changes the pen radius.
 */
public class PenRadiusCommand extends Command {

	/**
	 * The radius of the pen.
	 */
	private float radius;

	/**
	 * Specify the turtle that responds to this command and the pen radius to change to.
	 * 
	 * @param t the turtle that responds to this command.
	 * @param radius the pen radius to change to.
	 */
	public PenRadiusCommand(Turtle t, float radius) {
    	super(t);
    	this.radius = radius;
    }
	
	/**
	 * Returns the radius to change the pen to.
	 * 
	 * @return the radius to change the pen to.
	 */
	public float getRadius() {
		return this.radius;
	}
	
	/**
	 * Commands the turtle to change its pen radius to {@code getRadius()}.
	 */
	@Override
    public void execute() {
    	this.turtle.setPenRadius(getRadius());
    }
}
