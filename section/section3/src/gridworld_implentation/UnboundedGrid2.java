package gridworld_implentation;

import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.*;
import java.awt.Color;

public class UnboundedGrid2<E> extends AbstractGrid<E> {
  private Object[][] occupantArray;
  private int gridSize;
  private final int FACTOR = 2;

  public UnboundedGrid2() {
    System.out.println("In constructor");
    gridSize = 16;
    occupantArray = new Object[16][16];
  }

  public int getNumRows()
    {
        return -1;
    }

    public int getNumCols()
    {
        return -1;
    }

    public boolean isValid(Location loc)
    {
        return loc.getRow() >= 0 && loc.getCol() >= 0;
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for (int i = 0; i < gridSize; i++) {
          for (int j = 0; j < gridSize; j++) {
            Location loc = new Location(i, j);
            if (get(loc) != null) {
              locs.add(loc);
            }
          }
        }

        return locs;
    }

    public E get(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
        if (loc.getRow() >= gridSize || loc.getCol() >= gridSize)
          return null;
        return (E) occupantArray[loc.getRow()][loc.getCol()]; // unavoidable warning
    }

    public E put(Location loc, E obj) {
      System.out.println("In put");
      if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");
        int size = gridSize;
        while (loc.getRow() >= gridSize || loc.getCol() >= gridSize) {
          gridSize *= FACTOR;
        }

        if (gridSize != size) {
          Object[][] newGrid = new Object[gridSize][gridSize];
          for (int i = 0; i < size; i++) {
            System.arraycopy(occupantArray[i], 0, newGrid[i], 0, size);
          }
          occupantArray = newGrid;
        }
        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }

    public E remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        E r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }
}