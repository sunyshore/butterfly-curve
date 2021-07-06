package a5.commands;

import java.awt.Color;

import a5.Turtle;
import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import princeton.introcs.StdDraw;

/**
 * A class that displays a single large butterfly curve as drawn by a turtle.
 * The number of iterations, cycles, and color palettes can be customised.
 * 
 * @author Me/rcy :D
 *
 */
public class ButterflySingleCommands {

	public static void main(String[] args) {
	    // StdDraw.show(0);
		
		// formatting the board
		int size = 750; // default is 512
		StdDraw.setCanvasSize(size, size);
		StdDraw.clear(new Color(0, 0, 0));
		
		// setting up turtle and command parameters
	    Turtle t = new Turtle(new Point2(0.5, 0.4), 0, Color.BLACK);
	    double iterations = 6.3 * 40; // one cycle is ~6.3 iterations
	    double cycles = 7;
	    int scale = 8; // default is 8, which is the best size for a board of size 750
	    
	    /*
	     * Color Options:
	     * 1 = rainbow
	     * 2 = gradient rainbow
	     * 3 = sunset
	     * default = white
	     */
	    int colorOption = 3;
	    
	    Command c = new ButterflyCommand(t, iterations, cycles, colorOption, scale);
	    c.execute();

	    // StdDraw.show();
	}
}
