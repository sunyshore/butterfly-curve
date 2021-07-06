package a5.commands;

import java.awt.Color;

import a5.Turtle;

/**
 * A class containing methods that return colors based on a specific palette. The options
 * can be chosen through the ButterflyCommand constructor.
 * 
 * The first option is a rainbow cycle. The second option is a gradient rainbow
 * cycle that gradually increases the saturation and brightness of the color. The
 * third option is a sunset palette. The default option is an all white butterfly.
 * 
 * @author Me/rcy :D
 *
 */
public class ColorCycles extends CompositeCommand {

	/**
	 * Specify the turtle that responds to this command.
	 * 
	 * @param t the turtle that responds to this command.
	 */
	public ColorCycles(Turtle t) {
		super(t);
	}

	/**
	 * Returns a color from the rainbow cycle based on the step, cycle, and iterations
	 * of the butterfly curve.
	 * 
	 * @param s the step that the curve is on.
	 * @param iterations the number of iterations of the butterfly curve to draw.
	 * @param cycles the number of color cycles to display.
	 * @return a color from the rainbow cycle.
	 */
	public static Color rainbow(double s, double cycles) {
		float saturation = 0.8f; // default is 1f
		return Color.getHSBColor((float) (s / 6.3 * cycles), saturation, 1f);
	}
	
	/**
	 * Returns a color from the gradient rainbow cycle based on the step,
	 * cycle, and iterations of the butterfly curve.
	 * 
	 * @param s the step that the curve is on.
	 * @param cycles the number of color cycles to display.
	 * @param iterations the number of iterations of the butterfly curve to draw.
	 * @return a color from the gradient rainbow cycle.
	 */
	public static Color gradRainbow(double s, double iterations, double cycles) {
		//float saturation = 0.8f; // default is 1f
		float saturation = (float) (s / iterations);
		float brightness = (float) (s / iterations);
		return Color.getHSBColor((float) ((s / 6.3 * cycles) - 0.45), saturation, brightness);
	}
	
	/**
	 * Returns a color from the sunset cycle based on the step, and cycle
	 * of the butterfly curve.
	 * 
	 * @param s the step that the curve is on.
	 * @param cycles the number of color cycles to display.
	 * @return a color from the sunset cycle.
	 */
	public static Color sunset(double s, double cycles) {
		float hue = (float) (0.1666666 * Math.sin(s * Math.PI) - 0.041666666);
		hue = (float) (hue / 6.3 * cycles);
		return Color.getHSBColor(hue, 0.9f, 1f);
	}
}
