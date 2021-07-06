package a5.commands;

import java.awt.Color;

import a5.Turtle;

/**
 * Command that changes the pen color.
 */
public class PenColorCommand extends Command {
	
	/**
	 * The color of the pen.
	 */
	private Color color;

	/**
	 * Specify the turtle that responds to this command and the pen color to change to.
	 * 
	 * @param t the turtle that responds to this command.
	 * @param c the pen color to change to.
	 */
	public PenColorCommand(Turtle t, Color c) {
    	super(t);
    	this.color = c;
    }
	
	/**
	 * Returns the color to change the pen to.
	 * 
	 * @return the color to change the pen to.
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Commands the turtle to change its pen color to {@code getColor()}.
	 */
	@Override
    public void execute() {
    	this.turtle.setPenColor(getColor());
    }
}
