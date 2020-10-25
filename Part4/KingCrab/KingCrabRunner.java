import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public final class KingCrabRunner
{
    private KingCrabRunner() {}
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(2, 4), new Bug());
        world.add(new Location(4, 4), new Rock());
        world.add(new Location(3, 3), new Flower());
        world.add(new Location(3, 5), new Rock());

        world.add(new Location(3, 4), new KingCrab());

        world.show();
    }
}