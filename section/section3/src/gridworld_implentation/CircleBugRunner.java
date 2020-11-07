package gridworld_implentation;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class CircleBugRunner{
    public static void main(String[] args) {
          ActorWorld world = new ActorWorld(); 
          CircleBug alice = new CircleBug(4);  
          alice.setColor(Color.ORANGE);
          CircleBug bob = new CircleBug(3);
          world.add(new Location(4, 4), alice); 
          world.add(new Location(3, 3), bob);
          world.show(); 
    }
}
