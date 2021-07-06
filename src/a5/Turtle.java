package a5;

import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import ca.queensu.cs.cisc124.notes.basics.geometry.Vector2;
import princeton.introcs.StdDraw;
import java.awt.Color;

/**
 * A class that supports 
 * <a href="https://en.wikipedia.org/wiki/Turtle_graphics">turtle graphics</a>.
 * 
 * <p>
 * A turtle walks in a straight line forwards or backwards in the direction that
 * it is currently pointing towards.
 * 
 * <p>
 * The direction that the turtle is pointing towards is called the heading of
 * the turtle. The heading is an angle measured from the positive x-axis to the
 * vector starting from the turtle's current position and pointing in the
 * direction that the turtle is facing in. The turtle maintains its heading
 * as a value between 0 (inclusive) and 360 (exclusive) degrees.
 * 
 * <p>
 * A turtle can change its heading without moving by turning left (counter
 * clockwise) or right (clockwise) in place.
 * 
 * <p>
 * A turtle holds a pen using its tail and the pen can be up or down If the pen
 * is down then a line is drawn when the turtle walks forwards or backwards. If
 * the pen is up then no line is drawn when the turtle walks.
 * 
 * <p>
 * Besides walking forwards or backwards, a turtle can teleport to a specified
 * point. No line is drawn when a turtle changes its position by teleporting.
 * 
 * 
 */
public class Turtle {
	private Point2 position;
	private double heading;
	private Pen pen;

	/**
	 * Create a turtle at location {@code (0, 0)} with a heading of {@code 0.0}
	 * degrees. The turtle's pen is {@code Color.BLACK}, with a radius of
	 * {@code 0.5f}, and is in the down state.
	 */
	public Turtle() {
		this(new Point2(0, 0), 0.0, Color.BLACK);
	}

	/**
	 * Create a turtle from another turtle. The created turtle is initialized having
	 * the same position, heading, and pen as the other turtle, but moves
	 * independently of the other turtle.
	 * 
	 * @param other the turtle to copy
	 */
	public Turtle(Turtle other) {
		this.position = new Point2(other.position);
		this.heading = other.getHeading();
		this.pen = new Pen(other.pen);
	}

	/**
	 * Create a turtle with the given starting position, heading, and pen color.
	 * The pen radius is set to {@code 0.5f} and is in the down state.
	 * 
	 * @param position the starting position of the turtle
	 * @param heading  the angle in degrees from the x axis that the turtle is
	 *                 facing in
	 * @param c        the pen color
	 * @throws IllegalArgumentException if the heading is negative or greater than
	 *                                  360 degrees
	 * @throws NullPointerException     if the pen color c is null
	 */
	public Turtle(Point2 position, double heading, Color c) {
		if (heading < 0 || heading > 360) {
			throw new IllegalArgumentException("heading out of range: " + heading);
		}
		if (c == null) {
			throw new NullPointerException("color is null");
		}
		this.position = new Point2(position);
		this.heading = Turtle.wrapAngle(heading);
		this.pen = new Pen(true, c, 0.5f);
	}

	/**
	 * Gets a copy of the current position of the turtle.
	 * 
	 * <p>
	 * The returned point is a new {@code Point2} instance equal to the turtle's
	 * current position.
	 * 
	 * @return the current position of the turtle
	 */
	public Point2 getPosition() {
		return new Point2(this.position);
		//return this.position;
	}

	/**
	 * Gets the direction that the turtle is facing in as an angle measured from the
	 * x axis. The angle of the turtle is always in the range of {@code 0} degrees,
	 * inclusive, and {@code +360} degrees, exclusive.
	 * 
	 * @return the angle measured in degrees from the x axis that the turtle is
	 *         facing
	 */
	public double getHeading() {
		return this.heading;
	}
	

	/**
	 * Draws a line connecting the specified start and end positions using the
	 * turtle's current pen color and pen radius.
	 * 
	 * <p>
	 * No line is drawn if the turtle's pen is up.
	 * 
	 * @param start the starting point of the line
	 * @param end   the ending point of the line
	 */
	private void drawLine(Point2 start, Point2 end) {
		if (this.isPenDown()) {
			StdDraw.setPenColor(this.getPenColor());
			StdDraw.setPenRadiusInPixels(this.getPenRadius());
			StdDraw.line(start.x(), start.y(), end.x(), end.y());
		}
	}
	

	/**
	 * Teleports the turtle to the specified position without drawing a line.
	 * 
	 * <p>
	 * The turtle changes the coordinates of its position to equal to coordinates of
	 * the specified position.
	 * 
	 * @param position the position to teleport the turtle to
	 */
	public void teleport(Point2 position) {
		this.position.set(position.x(), position.y());
	}

	/**
	 * Walks this turtle by the specified distance in the heading direction changing
	 * the position of the turtle. A negative distance walks the turtle backwards
	 * without changing the heading.
	 * 
	 * <p>
	 * A line is drawn between the current position of the turtle and the new
	 * position of the turtle if the pen is currently on.
	 * 
	 * @param distance a distance for the turtle to walk
	 */
	private void walk(double distance) {
		Point2 current = new Point2(this.position);
		Vector2 delta = new Vector2(distance * Math.cos(Math.toRadians(this.heading)),
				distance * Math.sin(Math.toRadians(this.heading)));
		this.position.add(delta);

		this.drawLine(current, this.position);
	}

	/**
	 * Walks the turtle forward by a given distance in the heading direction
	 * changing the position of the turtle.
	 * 
	 * <p>
	 * A line is drawn between the current position of the turtle and the new
	 * position of the turtle if the pen is currently on.
	 * 
	 * <p>
	 * The heading of the turtle does not change.
	 * 
	 * @param distance the distance to move
	 * @throws IllegalArgumentException if distance is less than zero
	 */
	public void forward(double distance) {
		if (distance < 0.0) {
			throw new IllegalArgumentException("distance is negative: " + distance);
		}
		this.walk(distance);
	}

	/**
	 * Walks the turtle backward by a given distance in the direction opposite to
	 * the heading direction changing the position of the turtle.
	 * 
	 * <p>
	 * A line is drawn between the current position of the turtle and the new
	 * position of the turtle if the pen is currently on.
	 * 
	 * <p>
	 * The heading of the turtle does not change.
	 * 
	 * @param distance the distance to move
	 * @throws IllegalArgumentException if distance is less than zero
	 */
	public void backward(double distance) {
		if (distance < 0.0) {
			throw new IllegalArgumentException("distance is negative: " + distance);
		}
		this.walk(-distance);
	}

	/**
	 * Returns the angle lying in the range 0 degrees (inclusive) to 360 degrees
	 * (exclusive) that is equivalent to {@code degrees}.
	 * 
	 * @param degrees an angle to wrap to the range 0 to 360 degrees
	 * @return the wrapped angle
	 */
	private static double wrapAngle(double degrees) {
		double result = degrees % 360;
		if (result < 0) {
			result += 360;
		}
		return result;
	}

	/**
	 * Turns the turtle to the left (counter clockwise), increasing its heading by
	 * delta degrees. The heading of the turtle is always corrected to lie within
	 * the range of {@code 0} degrees, inclusive, and {@code +360} degrees,
	 * exclusive.
	 * 
	 * @param delta the angle in degrees to turn counter clockwise
	 * @throws IllegalArgumentException if distance is less than zero
	 */
	public void turnLeft(double delta) {
		if (delta < 0.0) {
			throw new IllegalArgumentException("delta is negative: " + delta);
		}
		this.heading += delta;
		this.heading = Turtle.wrapAngle(this.heading);
	}

	/**
	 * Turns the turtle to the right (clockwise), decreasing its heading by delta
	 * degrees. The heading of the turtle is always corrected to lie within the
	 * range of {@code 0} degrees, inclusive, and {@code +360} degrees, exclusive.
	 * 
	 * @param delta the angle in degrees to turn clockwise
	 * @throws IllegalArgumentException if distance is less than zero
	 */
	public void turnRight(double delta) {
		if (delta < 0.0) {
			throw new IllegalArgumentException("delta is negative: " + delta);
		}
		this.heading -= delta;
		this.heading = Turtle.wrapAngle(this.heading);
	}

	/**
	 * Returns {@code true} if the turtle's pen is down, {@code false} otherwise.
	 * 
	 * @return {@code true} if the turtle's pen is down, {@code false} otherwise
	 */
	public boolean isPenDown() {
		return this.pen.isOn();
	}

	/**
	 * Sets the pen to the down position. A line will be drawn when the turtle moves
	 * forward or backwards.
	 */
	public void penDown() {
		this.pen.on();
	}

	/**
	 * Sets the pen to the up position. No line will be drawn when the turtle moves
	 * forward or backwards.
	 */
	public void penUp() {
		this.pen.off();
	}

	/**
	 * Gets the current pen color.
	 * 
	 * @return the current pen color
	 */
	public Color getPenColor() {
		return this.pen.getColor();
	}

	/**
	 * Sets the pen color.
	 * 
	 * @param c the new pen color
	 * @throws IllegalArgumentException if the pen color c is null
	 */
	public void setPenColor(Color c) {
		if (c == null) {
			throw new IllegalArgumentException("pen color is null");
		}
		this.pen.setColor(c);
	}

	/**
	 * Gets the current pen radius. The radius has no units, it is
	 * up to the caller to decide how to interpret the magnitude
	 * of the returned radius.
	 * 
	 * <p>
	 * The returned radius is always greater than or equal to zero.
	 * 
	 * @return the current pen radius
	 */
	public float getPenRadius() {
		return this.pen.getRadius();
	}

	/**
	 * Sets the pen radius. The radius has no units, it is
	 * up to the caller to decide how to interpret the magnitude
	 * of the returned radius.
	 * 
	 * @param radius the pen radius
	 * @throws IllegalArgumentException if the radius is negative
	 */
	public void setPenRadius(float radius) {
		this.pen.setRadius(radius); // will throw if radius is negative
	}

	/**
	 * Returns a string representation of this turtle. The string representation is:
	 * 
	 * <ol>
	 * <li>the position of the turtle (as given by {@code Point2.toString}),
	 * followed by
	 * <li>a comma and a space, followed by
	 * <li>the heading, followed by
	 * <li>a space, the string "degrees", a space, and a comma, followed by
	 * <li>the pen color (as given by {@code Color.toString})
	 * </ol>
	 * 
	 * @return a string representation of this turtle
	 */
	@Override
	public String toString() {
		String s = String.format("%s, %f degrees, %s", this.getPosition(), this.getHeading(), this.getPenColor());
		return s;
	}

}
