import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public final class ChameleonKidRunner {
    private ChameleonKidRunner() {}
    public static void main(String[] args) {
        ActorWorld world = new ActorWorld();
        ChameleonKid Leo = new ChameleonKid();
        Leo.setColor(Color.RED);
        ChameleonKid Howell = new ChameleonKid();
        Howell.setColor(Color.ORANGE);

        world.add(new Location(3, 3), Leo);

        Rock rock = new Rock();
        rock.setColor(Color.BLACK);
        world.add(new Location(5, 5), Howell);
        world.add(new Location(6, 6), rock);

        world.show();
    }
}