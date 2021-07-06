package a5.commands;

import a5.Turtle;

/**
 * Command that lowers the pen down onto the canvas.
 */
public class PenDownCommand extends Command {

    /**
     * Specify the turtle that responds to this command.
     * 
     * @param t the turtle that responds to this command
     */
    public PenDownCommand(Turtle t) {
    	super(t);
    }
    
    /**
     * Commands the turtle to lower the pen down onto the canvas.
     */
    @Override
    public void execute() {
    	this.turtle.penDown();
    }
}
