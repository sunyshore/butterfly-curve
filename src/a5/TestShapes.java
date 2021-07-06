package a5;

import java.awt.Color;

import a5.commands.CircleCommand;
import a5.commands.Command;
import a5.commands.PenColorCommand;
import a5.commands.SquareCommand;
import a5.commands.TeleportCommand;
import a5.commands.TurnLeftCommand;
import a5.commands.TurnRightCommand;
import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import princeton.introcs.StdDraw;

/**
 * Simple test class for Assignment 5.
 */

public class TestShapes {

	public static void main(String[] args) {
		StdDraw.clear(new Color(250, 250, 250));
		Turtle t = new Turtle(new Point2(0.25, 0.75), 0, Color.BLACK);
	    Command c = new SquareCommand(t, 0.5);
	    c.execute();
	    c = new TeleportCommand(t, new Point2(0.5, 0.75));
	    c.execute();
	    c = new PenColorCommand(t, Color.RED);
	    c.execute();
	    c = new CircleCommand(t, 0.25);
	    c.execute();
	    c = new TeleportCommand(t, new Point2(0.5, 0.75));
	    c.execute();
	    c = new TurnRightCommand(t, 45.0);
	    c.execute();
	    c = new PenColorCommand(t, Color.BLUE);
	    c.execute();
	    double len = Math.sqrt(2 * 0.25 * 0.25);
	    c = new SquareCommand(t, len);
	    c.execute();
	    c = new TurnLeftCommand(t, 225);
	    c.execute();
	    c = new CircleCommand(t, 0.05);
	    c.execute();
	}

}
