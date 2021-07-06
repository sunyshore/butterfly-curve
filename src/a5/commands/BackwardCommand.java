package a5.commands;

import a5.Turtle;

/**
 * Command that walks the turtle backwards.
 *
 */
public class BackwardCommand extends WalkCommand {

	/**
	 * Specify the turtle that responds to this command and the distance to walk the turtle by.
	 * 
	 * @param t the turtle that responds to this command.
	 * @param distance the distance to walk the turtle by.
	 */
	public BackwardCommand(Turtle t, double distance) {
        super(t, distance);
    }
	
	/**
	 * Walks the turtle backward by getDistance() units.
	 */
	@Override
    public void execute() {
        this.turtle.backward(getDistance());
    }
}