package a5.commands;

import a5.Turtle;

/**
 * Command that lifts the pen up off the canvas.
 */
public class PenUpCommand extends Command {

    /**
     * Specify the turtle that responds to this command.
     * 
     * @param t the turtle that responds to this command
     */
    public PenUpCommand(Turtle t) {
    	super(t);
    }
    
    /**
     * Commands the turtle to lift its pen off the canvas.
     */
    @Override
    public void execute() {
    	this.turtle.penUp();
    }
}
