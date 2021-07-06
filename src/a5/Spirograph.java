package a5;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import ca.queensu.cs.cisc124.notes.basics.geometry.Point2;
import ca.queensu.cs.cisc124.notes.basics.geometry.Vector2;
import princeton.introcs.StdDraw;

public class Spirograph {

	public static void walkTo(Point2 p, Turtle t) {
		Vector2 v = t.getPosition().to(p);
		double hv = Math.toDegrees(Math.atan2(v.y(), v.x()));
		if (hv < 0) {
			hv += 360;
		}
		double delta = hv - t.getHeading();
		if (delta >= 0) {
			t.turnLeft(delta);
		}
		else {
			t.turnRight(-delta);
		}
		double d = v.mag();
		t.forward(d);
	}
	
	public static Point2 hypotrochoid(double r1, double r2, double d, double theta) {
		double x = (r1 - r2) * Math.cos(theta) + d * Math.cos((r1 - r2) / r2 * theta);
		double y = (r1 - r2) * Math.sin(theta) - d * Math.sin((r1 - r2) / r2 * theta);
		return new Point2(x, y);
	}
	
	public static void main(String[] args) {
		StdDraw.setScale(-2, 2);
		Turtle t1 = new Turtle();
		int n = 100;
		double r11 = 2;
		double r21 = 0.99;
		double d1 = 0.8;
		t1.teleport(hypotrochoid(r11, r21, d1, 0));
		t1.setPenColor(Color.RED);
		
		List<Color> colors = Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA);
		for (int i = 2; i < 360 * n; i += 2) {
			double theta1 = Math.toRadians(i);
			Point2 p1 = hypotrochoid(r11, r21, d1, theta1);
			Color c = colors.get(i / 3600 % 5);
			t1.setPenColor(c);
			walkTo(p1, t1);
		}
	}

}
