package gridworld_implentation;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class DancingBugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld(); 
        int arr[] = {0,1,2,3,4,5};
        DancingBug alice = new DancingBug(arr);  
        alice.setColor(Color.ORANGE);
        world.add(new Location(4, 4), alice); 
        world.show(); 
  }
}
