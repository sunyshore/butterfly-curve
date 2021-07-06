package a5.commands;

import java.util.Objects;

import a5.Turtle;

/**
 * Abstract base class for all turtle commands. 
 *
 */
public abstract class Command implements TurtleCommand {

	/**
	 * The turtle that executes this command.
	 */
	protected Turtle turtle;
	
	/**
	 * Initialize this command with a turtle that executes
	 * this command.
	 * 
	 * @param t the turtle that executes this command
	 * @throws NullPointerException if t is null
	 */
	public Command(Turtle t) {
		Objects.requireNonNull(t);
		this.turtle = t;
	}
	
	/**
     * Returns the turtle that responds to this command.
     * 
     * @return the turtle that responds to this command
     */
	@Override
    public Turtle getTurtle() {
        return this.turtle;
    }

	/**
     * Sets the turtle that responds to this command.
     * 
     * @param t the turtle that responds to this command
     */
    @Override
    public void setTurtle(Turtle t) {
    	Objects.requireNonNull(t);
        this.turtle = t;
    }
}
