/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;

import java.awt.Color;

public class Jumper extends Actor
{
    public Jumper()
    {
        setColor(Color.RED);
    }

    public Jumper(Color jumperColor)
    {
        setColor(jumperColor);
    }

    public void act()
    {
        if (canMove()) {
            move();
        }
        else {
            turn();
        }
    }

    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void move()
    {
        Grid<Actor> grid = getGrid();
        if (grid == null) {
            return;
        }
        Location location = getLocation();
        Location next = (location.getAdjacentLocation(getDirection())).getAdjacentLocation(getDirection());
        if (grid.isValid(next)) {
            moveTo(next);
        }
        else {
            removeSelfFromGrid();
        }
    }

    public boolean canMove()
    {
        Grid<Actor> grid = getGrid();
        if (grid == null) {
            return false;
        }
        Location location = getLocation();
        Location next = (location.getAdjacentLocation(getDirection())).getAdjacentLocation(getDirection());
        if (!grid.isValid(next)) {
            return false;
        }
        Actor neighbor = grid.get(next);
        return (neighbor == null) || (neighbor instanceof Flower) || (neighbor instanceof Bug);
    }
}
