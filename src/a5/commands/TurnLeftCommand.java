package a5.commands;

import a5.Turtle;

/**
 * Command that turns the turtle left (counter clockwise).
 *
 */
public class TurnLeftCommand extends TurnCommand {

	/**
     * Specify the turtle that responds to this command and the
     * angle to turn the turtle by.
     * 
     * @param t the turtle that responds to this command
     * @param angle the angle to turn by
     * @throws IllegalArgumentException if the angle is negative
     */
    public TurnLeftCommand(Turtle t, double angle) {
        super(t, angle);
    }

    /**
     * Turns the turtle to the left by {@code getAngle()} degrees. 
     */
    @Override
    public void execute() {
        this.turtle.turnLeft(this.angle);
    }
}