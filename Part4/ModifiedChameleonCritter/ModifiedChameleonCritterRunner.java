import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

public final class ModifiedChameleonCritterRunner {
    private ModifiedChameleonCritterRunner() {}
  public static void main(String[] args) {
    ActorWorld world = new ActorWorld();

    ModifiedChameleonCritter Leo = new ModifiedChameleonCritter();
    Leo.setColor(Color.RED);

    ModifiedChameleonCritter Howell = new ModifiedChameleonCritter();
    Howell.setColor(Color.GREEN);

    Bug bug = new Bug();
    bug.setColor(Color.ORANGE);

    world.add(new Location(3, 2), Leo);
    world.add(new Location(3, 2), bug);

    world.add(new Location(5, 4), Howell);

    world.show();
  }
}