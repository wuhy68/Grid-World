package maze;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;
import maze.Maze;
import info.gridworld.actor.Rock;
import java.awt.Color;
public class MazeRunner {
    public static void main(String[] args){
        ActorWorld world = new ActorWorld(); 
        world.add(new Location(0,0), new Maze());
        world.show();
    }
}
