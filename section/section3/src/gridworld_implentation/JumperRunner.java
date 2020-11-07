package gridworld_implentation;

import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.awt.Color;


public class JumperRunner {
	
	   public static void main(String[] args) {
		     ActorWorld world = new ActorWorld();
		     Jumper jumper1 = new Jumper(Color.RED);
		     Jumper jumper2 = new Jumper(Color.YELLOW);
		     Bug bug = new Bug();
		     world.add(new Location(4, 4), jumper1);
		     world.add(new Location(2,2), jumper2);
		     world.add(new Location(3, 3), bug);
		     world.show();
		   }
}
