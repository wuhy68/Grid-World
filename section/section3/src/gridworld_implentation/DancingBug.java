package gridworld_implentation;
import java.util.Arrays;
import info.gridworld.actor.Bug;

public class DancingBug extends Bug{
	private int index;
	private int[] arr;
	
	public DancingBug(int[] array) {
		arr = Arrays.copyOf(array,array.length);
	}
	
	public void act() {
		setDirection(getDirection() + arr[index]*45);
		if(canMove()) {
			move();
		}
		++index;
		if(index == arr.length)
			index = 0;
	}
}
