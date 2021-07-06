package a5.commands;

import a5.Turtle;

/**
 * Abstract base class for all commands that cause a turtle to
 * turn in place.
 *
 */
public abstract class TurnCommand extends Command {

    /**
     * The angle to turn the turtle by.
     */
    protected double angle;
	
    /**
     * Specify the turtle that responds to this command and the
     * angle to turn the turtle by.
     * 
     * @param t the turtle that responds to this command
     * @param angle the angle to turn by
     * @throws IllegalArgumentException if the angle is negative
     */
    public TurnCommand(Turtle t, double angle) {
    	super(t);
        if (angle < 0.0) {
			throw new IllegalArgumentException("angle is negative: " + angle);
		}
        this.angle = angle;
    }
    
    /**
     * Get the angle that the turtle turns by.
     * 
     * @return the angle that the turtle turns by
     */
    public double getAngle() {
    	return this.angle;
    }
}
