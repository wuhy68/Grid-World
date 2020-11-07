package gridworld_implentation;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class SpiralBugRunner {
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld(); 
        SpiralBug alice = new SpiralBug(4);  
        alice.setColor(Color.ORANGE);
        world.add(new Location(4, 4), alice); 
        world.show(); 
  }
}
