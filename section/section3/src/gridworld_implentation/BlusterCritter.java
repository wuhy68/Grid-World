package gridworld_implentation;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

public class BlusterCritter extends Critter{
	private int Courage;
    private static final Color DEFAULT_COLOR = Color.PINK;
    private static final double DARKENING_FACTOR = 0.05;
    
    public BlusterCritter(int c) {
    	Courage = c;
    	setColor(DEFAULT_COLOR);
    }
    
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs =
            { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT,Location.RIGHT,Location.LEFT,Location.SOUTHEAST,Location.SOUTHWEST};
        for (Location loc : getLocationsInDirections(dirs))
        {
            Actor a = getGrid().get(loc);
            if (a != null)
                actors.add(a);
        }
        
        return actors;
    }
    
    public void processActors(ArrayList<Actor> actors) {
        int n = actors.size();
        for (Actor a : actors)
        {
            if (!(a instanceof Rock) && !(a instanceof Critter))
                a.removeSelfFromGrid();
        }
        if(n >= this.Courage) {
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

            setColor(new Color(red, green, blue));
        } else {
            Color c = getColor();
            int red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));

            setColor(new Color(red, green, blue));
        }

    }
    
    public ArrayList<Location> getLocationsInDirections(int[] directions) {
        ArrayList<Location> locs1 = new ArrayList<Location>();
        ArrayList<Location> locs2 = new ArrayList<Location>();
        Grid gr = getGrid();
        int [] dirs = 
        	{Location.HALF_LEFT,Location.HALF_RIGHT,Location.SOUTHEAST,Location.SOUTHWEST};
        for(int d : directions) {
        	Location loc = getLocation().getAdjacentLocation(d);
        	if(gr.isValid(loc))
        		locs1.add(loc);
        }
        for (Location loc : locs1) {
            for (int d : directions) {
                 Location loc2= loc.getAdjacentLocation(getDirection()+d);
                 if (gr.isValid(loc2) && !locs2.contains(loc2))
                    locs2.add(loc2);
            }
            if(gr.isValid(loc))
            	locs2.add(loc);
        }
        
        return locs2;
   }
}
