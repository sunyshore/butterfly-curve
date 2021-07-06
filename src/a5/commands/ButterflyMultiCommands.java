package a5.commands;

import java.awt.Color;

import a5.Turtle;
import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import princeton.introcs.StdDraw;

/**
 * A class that displays 9 butterfly curves with varying color palettes and cycles.
 * 
 * @author Me/rcy :D
 *
 */
public class ButterflyMultiCommands {

	public static void main(String[] args) {
		
		double n = 6; // number of sections on the board
		int size = (int) n * 125;
		StdDraw.setCanvasSize(size, size);
		StdDraw.clear(new Color(0, 0, 0));
		// StdDraw.show(0);
	    
	    /*
	     * Color Options:
	     * 0 = white
	     * 1 = rainbow
	     * 2 = gradient rainbow
	     * 3 = sunset
	     */
	    int colorOption = 0;
	    double iterations = 6.3 * 30; // one cycle is ~6.3 iterations
	    int scale = 32; // size of the butterflies: bigger number = smaller butterfly
		
		// rainbow turtles
	    colorOption = 1;
	    Turtle t1 = new Turtle(new Point2(1/n, 5/n - 0.022), 0, Color.BLACK);
		Command c1 = new ButterflyCommand(t1, iterations, 1, colorOption, scale);
	    c1.execute();
	    Turtle t2 = new Turtle(new Point2(3/n, 5/n - 0.022), 0, Color.BLACK);
		Command c2 = new ButterflyCommand(t2, iterations, 4, colorOption, scale);
	    c2.execute();
	    Turtle t3 = new Turtle(new Point2(5/n, 5/n - 0.022), 0, Color.BLACK);
		Command c3 = new ButterflyCommand(t3, iterations, 2, colorOption, scale);
	    c3.execute();
	    
		// gradient rainbow turtles
	    colorOption = 2;
	    Turtle t4 = new Turtle(new Point2(1/n, 3/n - 0.022), 0, Color.BLACK);
		Command c4 = new ButterflyCommand(t4, iterations, 2, colorOption, scale);
	    c4.execute();
	    Turtle t5 = new Turtle(new Point2(3/n, 3/n - 0.022), 0, Color.BLACK);
		Command c5 = new ButterflyCommand(t5, iterations, 4, colorOption, scale);
	    c5.execute();
	    Turtle t6 = new Turtle(new Point2(5/n, 3/n - 0.022), 0, Color.BLACK);
		Command c6 = new ButterflyCommand(t6, iterations, 1, colorOption, scale);
	    c6.execute();
		
		// sunset turtles
	    colorOption = 3;
	    Turtle t7 = new Turtle(new Point2(1/n, 1/n - 0.022), 0, Color.BLACK);
		Command c7 = new ButterflyCommand(t7, iterations, 4, colorOption, scale);
	    c7.execute();
	    Turtle t8 = new Turtle(new Point2(3/n, 1/n - 0.022), 0, Color.BLACK);
		Command c8 = new ButterflyCommand(t8, iterations, 8, colorOption, scale);
	    c8.execute();
	    Turtle t9 = new Turtle(new Point2(5/n, 1/n - 0.022), 0, Color.BLACK);
		Command c9 = new ButterflyCommand(t9, iterations, 2, colorOption, scale);
	    c9.execute();
	    
	    // StdDraw.show();
	}
}
