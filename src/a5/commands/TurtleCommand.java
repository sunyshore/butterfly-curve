package a5.commands;

import a5.Turtle;

/**
 * Executable commands for the {@code Turtle} class. Classes implementing this
 * interface can have a turtle object execute commands.
 */
public interface TurtleCommand {
	/**
     * Returns the turtle that responds to this command.
     * 
     * @return the turtle that responds to this command
     */
    Turtle getTurtle();

    /**
     * Sets the turtle that responds to this command.
     * 
     * @param turtle the turtle that responds to this command
     */
    void setTurtle(Turtle turtle);

    /**
     * Execute this command using the turtle associated with this command.
     */
    void execute();
}
