package gridworld_implentation;
import info.gridworld.actor.Bug;

public class ZBug extends Bug{
	private int steps;
	private int sideLength;
	private int count;
	public ZBug(int length) {
		steps = 0;
		sideLength = length;
		count = 0;
		setDirection(90);
	}
	
	public void act() {
		if (steps < sideLength && canMove()) {
            move();
            steps++;
		}
		else if( steps == sideLength && count == 0) {
			count++;
			steps = 0;
			setDirection(225);
		}
		else if (steps == sideLength && count == 1) {
			count++;
			steps = 0;
			setDirection(90);
		}
	}
}
