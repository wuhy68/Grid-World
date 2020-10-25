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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    private int steps;
    private int[] turns;

    public DancingBug(int[] newTurns)
    {
        steps = 0;
        turns = new int[newTurns.length];
        System.arraycopy(newTurns, 0, turns, 0, newTurns.length);
    }

    public void act()
    {
        for (int i = 0; i < turns[steps]; i++) {
            turn();
        }

        if (canMove()) {
            move();
            steps++;

            if (steps == turns.length) {
                steps = 0;
            }
        }
        else {
            turn();
        }
    }
}
