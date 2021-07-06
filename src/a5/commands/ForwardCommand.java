package a5.commands;

import a5.Turtle;

/**
 * Command that walks the turtle forwards.
 *
 */
public class ForwardCommand extends WalkCommand {

	/**
	 * Specify the turtle that responds to this command and the distance to walk the turtle by.
	 * 
	 * @param t the turtle that responds to this command.
	 * @param distance the distance to walk the turtle by.
	 */
	public ForwardCommand(Turtle t, double distance) {
        super(t, distance);
    }
	
	/**
	 * Walks the turtle forward by {@code getDistance()} units.
	 */
	@Override
    public void execute() {
        this.turtle.forward(getDistance());
    }
}