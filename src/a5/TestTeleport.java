package a5;

import java.awt.Color;

import a5.commands.Command;
import a5.commands.ForwardCommand;
import a5.commands.TeleportCommand;
import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import princeton.introcs.StdDraw;

/**
 * Simple test class for Assignment 5.
 */

public class TestTeleport {

	public static void main(String[] args) {
		StdDraw.clear(new Color(250, 250, 250));
		Turtle t = new Turtle(new Point2(0.5, 0.5), 0, Color.BLACK);
	    Command c = new TeleportCommand(t, new Point2(0.1, 0.1));
	    c.execute();
	    c = new ForwardCommand(t, 0.25);
	    c.execute();
	    c = new TeleportCommand(t, new Point2(0.5, 0.5));
	    c.execute();
	    c = new ForwardCommand(t, 0.25);
	    c.execute();
	    c = new TeleportCommand(t, new Point2(0.25, 0.8));
	    c.execute();
	    c = new ForwardCommand(t, 0.25);
	    c.execute();
	}

}
