package gridworld_implentation;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter{

    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        for (Location loc : getLocationsInDirections2(dirs))
            if (getGrid().get(loc) == null)
                locs.add(loc);
        if(locs.size() != 0)
        	return locs;
        else {
            for (Location loc : getLocationsInDirections(dirs))
                if (getGrid().get(loc) == null)
                    locs.add(loc);     	
            return locs;
        }
    }	
    
    public ArrayList<Location> getLocationsInDirections2(int[] directions) {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();

       for (int d : directions) {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            Location neighborLoc2 = neighborLoc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc2) && gr.get(neighborLoc) == null && gr.get(neighborLoc2) == null)
              locs.add(neighborLoc2);
       }
       return locs;
   }

}
