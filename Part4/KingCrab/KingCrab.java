import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter {
    public void processActors(ArrayList<Actor> actors)
    {
        Grid<Actor> grid = getGrid();
        Location present = getLocation();
        for (Actor a : actors) {
            int direction = present.getDirectionToward(a.getLocation());
            Location toMove = a.getLocation().getAdjacentLocation(direction);
            if (grid.isValid(toMove)) {
                a.moveTo(toMove);
            }
            else {
                a.removeSelfFromGrid();
            }
        }
    }
}