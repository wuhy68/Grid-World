import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter {

    private ArrayList<Location> getQuick() {
        ArrayList<Location> locations = new ArrayList<Location>();
      
        Location present = getLocation();
        Location left = present.getAdjacentLocation(getDirection() + Location.LEFT);
        Location right = present.getAdjacentLocation(getDirection() + Location.RIGHT);

        Grid<Actor> grid = getGrid();

        if (grid.isValid(left) && grid.get(left) == null) {
            Location leftTwo = left.getAdjacentLocation(getDirection() + Location.LEFT);

            if (grid.isValid(leftTwo) && grid.get(leftTwo) == null) {
                locations.add(leftTwo);
            }
        }

        if (grid.isValid(right) && grid.get(right) == null) {
            Location rightTwo = right.getAdjacentLocation(getDirection() + Location.RIGHT);
            if (grid.isValid(rightTwo) && grid.get(rightTwo) == null) {
                locations.add(rightTwo);
            }
        }

        return locations;
    }

    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locations = getQuick();

        if (locations.size() == 0) {
         
            int[] dirs = { Location.LEFT, Location.RIGHT };
            for (Location loc : getLocationsInDirections(dirs)) {
                if (getGrid().get(loc) == null) {
                    locations.add(loc);
                }
            }
        }
        return locations;
    }
}