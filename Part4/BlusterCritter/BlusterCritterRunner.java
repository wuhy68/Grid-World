import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

public final class BlusterCritterRunner {
    private BlusterCritterRunner() {}
  public static void main(String[] args) {
    ActorWorld world = new ActorWorld();
    BlusterCritter Leo = new BlusterCritter(5);
    Leo.setColor(Color.RED);
    BlusterCritter Howell = new BlusterCritter(2);
    Howell.setColor(Color.ORANGE);

    world.add(new Location(3, 3), Leo);

    Rock rock1 = new Rock();
    Rock rock2 = new Rock();
    Rock rock3 = new Rock();

    world.add(new Location(5, 4), Howell);
    world.add(new Location(5, 5), rock1);
    world.add(new Location(5, 3), rock2);
    world.add(new Location(4, 4), rock3);

    world.show();
  }
}