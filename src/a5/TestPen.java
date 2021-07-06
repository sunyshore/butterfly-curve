package a5;

import java.awt.Color;

import a5.commands.BackwardCommand;
import a5.commands.Command;
import a5.commands.ForwardCommand;
import a5.commands.PenColorCommand;
import a5.commands.PenRadiusCommand;
import a5.commands.TurnRightCommand;
import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import princeton.introcs.StdDraw;

/**
 * Simple test class for Assignment 5.
 */

public class TestPen {

	public static void main(String[] args) {
		StdDraw.clear(new Color(250, 250, 250));
		Turtle t = new Turtle(new Point2(0.5, 0.5), 0, Color.BLACK);
	    Command c = new ForwardCommand(t, 0.25);
	    c.execute();
	    c = new TurnRightCommand(t, 90.0);
	    c.execute();
	    c = new PenColorCommand(t, Color.RED);
	    c.execute();
	    c = new BackwardCommand(t, 0.4);
	    c.execute();
	    c = new TurnRightCommand(t, 90.0);
	    c.execute();
	    c = new PenRadiusCommand(t, 2.5f);
	    c.execute();
	    c = new ForwardCommand(t, 0.4);
	    c.execute();
	}

}
