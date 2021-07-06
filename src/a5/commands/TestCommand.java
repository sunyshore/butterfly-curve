package a5.commands;

import a5.Turtle;

public class TestCommand extends CompositeCommand{

	//private double radius;
	
	public TestCommand(Turtle t, double radius) {
		super(t);
		if (radius <= 0) {
			throw new IllegalArgumentException("ur stupid");
		}
		//this.radius = radius;
		
		int angle = 5; // default is 5 degrees
		int degreesToRotate = 1440; // default is 360
		double radians = Math.toRadians(angle);
		double rotate = 90.0 - ((180.0 - angle) / 2);
		double chord = Math.sqrt(2 * Math.pow(radius, 2) * (1 - Math.cos(radians)));
		//commands.add(new TurnRightCommand(turtle, 90));
		
		/*
		for (int theta = 0; theta <= 1080; theta = theta + angle) {
			if (theta == 0 || theta + angle == 1080) {
				commands.add(new TurnRightCommand(turtle, rotate));
				commands.add(new ForwardCommand(turtle, chord));
			}
			else {
				commands.add(new TurnRightCommand(turtle, angle + (theta / angle)));
				commands.add(new ForwardCommand(turtle, chord - (chord / theta)));
				
			}
		}
		*/
		for (int theta = 0; theta <= degreesToRotate; theta = theta + angle) {
			if (theta == 0 || theta + angle == degreesToRotate) {
				commands.add(new TurnRightCommand(turtle, rotate));
				commands.add(new ForwardCommand(turtle, chord));
			}
			else {
				commands.add(new TurnRightCommand(turtle, angle + (theta / angle)));
				commands.add(new ForwardCommand(turtle, 0.01));
				
			}
		}
	}
}
