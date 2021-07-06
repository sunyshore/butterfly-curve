package a5;

import java.awt.Color;

/**
 * A pen for a turtle. A pen has a color and non-negative radius. A pen can be on or off.
 * A pen radius of 0.5 corresponds to a line width of 1 pixel when drawing on a
 * {@link java.awt.Graphics2D} object (assuming no scaling transformation).
 */
public class Pen {

	private boolean isOn;
	private Color color;
	private float radius;
	
	/**
	 * Initializes a red pen of radius 0.5 that is on. 
	 */
	public Pen() {
		this(true, Color.RED, 0.5f);
	}
	
	/**
	 * Initializes this pen by copying the state of another pen.
	 * 
	 * @param other the pen to copy
	 */
	public Pen(Pen other) {
		this.isOn = other.isOn;
		this.color = other.color;
		this.radius = other.radius;
	}
	
	/**
	 * Initializes this pen to the specified on/off state, color, and radius.
	 * 
	 * @param isOn true if the pen is on, false if the pen is off
	 * @param color the color of this pen
	 * @param radius the radius in pixels of this pen
	 * @throws IllegalArgumentException if the radius is negative
	 * @throws NullPointerException if color is null
	 */
	public Pen(boolean isOn, Color color, float radius) {
		if (radius < 0f) {
			throw new IllegalArgumentException("negative radius: " + radius);
		}
		if (color == null) {
			throw new NullPointerException("color is null");
		}
		this.isOn = isOn;
		this.color = color;
		this.radius = radius;
	}
	
	/**
	 * Returns the on/off state of this pen.
	 * 
	 * @return true if the pen is on, false otherwise
	 */
	public boolean isOn() {
		return this.isOn;
	}
	
	/**
	 * Turns this pen on.
	 */
	public void on() {
		this.isOn = true;
	}
	
	/**
	 * Turns this pen off.
	 */
	public void off() {
		this.isOn = false;
	}
	
	/**
	 * Returns the color of this pen.
	 * 
	 * @return the color of this pen
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Sets the color of this pen to the specified color.
	 * 
	 * @param c the color of this pen
	 * @return the previous color of this pen
	 * @throws NullPointerException if color is null
	 */
	public Color setColor(Color c) {
		if (color == null) {
			throw new NullPointerException("color is null");
		}
		Color old = this.color;
		this.color = c;
		return old;
	}
	
	/**
	 * Returns the radius of this pen.
	 * 
	 * @return the radius of this pen
	 */
	public float getRadius() {
		return this.radius;
	}
	
	/**
	 * Sets the radius of this pen to the specified radius.
	 * 
	 * @param radius the radius of this pen 
	 * @return the previous radius of this pen
	 * @throws IllegalArgumentException if the radius is negative
	 */
	public float setRadius(float radius) {
		if (radius < 0f) {
			throw new IllegalArgumentException("negative radius: " + radius);
		}
		float old = this.radius;
		this.radius = radius;
		return old;
	}
} 
