package gridworld_implentation;

import static org.junit.Assert.*;
import org.junit.Test;
import info.gridworld.actor.*;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class JumperTest {
    public ActorWorld world = new ActorWorld();
    public Jumper jumper = new Jumper(Color.YELLOW);
    public Jumper jumper2 = new Jumper(Color.RED);
    public Bug bug = new Bug();
    public Rock rock = new Rock();
    public Flower flower = new Flower();

    @Test
    public void testJump1() {
        world.add(new Location(4, 4), jumper);
        jumper.act();
        Location loc = jumper.getLocation();
        Location loc2 = new Location(2, 4);
        assertEquals(loc, loc2);
    }

    @Test
    public void testJump2() {
        world.add(new Location(4, 4), jumper);
        world.add(new Location(3, 4), rock);
        jumper.act();
        int dir = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location loc2 = new Location(2, 4);
        assertTrue(loc.equals(loc2) && dir == Location.NORTH);
    }

    @Test
    public void testBlockRock() {
        world.add(new Location(4, 4), jumper);
        world.add(new Location(2, 4), rock);
        jumper.act();
        int dir = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location loc2 = new Location(4, 4);
        assertTrue(loc.equals(loc2) && dir == Location.NORTHEAST);
    }
 
    @Test
    public void testBlockBug() {
        world.add(new Location(4, 4), jumper);
        world.add(new Location(2, 4), bug);
        jumper.act();
        int dir = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location loc2 = new Location(4, 4);
        assertTrue(loc.equals(loc2) && dir == Location.NORTHEAST);
    }

    @Test
    public void testBlockFlower() {
        world.add(new Location(4, 4), jumper);
        world.add(new Location(2, 4), flower);
        jumper.act();
        int dir = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location loc2 = new Location(4, 4);
        assertTrue(loc.equals(loc2) && dir == Location.NORTHEAST);
    }

    @Test
    public void testOutOfGrid() {
        world.add(new Location(1, 4), jumper);
        jumper.act();
        int dir = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location loc2 = new Location(1, 4);
        assertTrue(loc.equals(loc2) && dir == Location.NORTHEAST);
    }

    @Test
    public void testGridEdge() {
        world.add(new Location(0, 4), jumper);
        jumper.act();
        int direc = jumper.getDirection();
        Location loc = jumper.getLocation();
        Location loc2 = new Location(0, 4);
        assertTrue(loc.equals(loc2) && direc == Location.NORTHEAST);
    }

    @Test
    public void testJumper1() {
        world.add(new Location(3, 4), jumper);
        jumper2.setDirection(Location.SOUTH);
        world.add(new Location(1, 4), jumper2);
        jumper.act();
        jumper2.act();
        int dir = jumper.getDirection();
        int dir2 = jumper2.getDirection();
        Location loc = jumper.getLocation();
        Location loc2 = jumper2.getLocation();
        Location locr = new Location(3, 4);
        Location locr2 = new Location(1, 4);
        assertTrue(loc.equals(locr) && dir == Location.NORTHEAST);
        assertTrue(loc2.equals(locr2) && dir2 == Location.SOUTHWEST);
    }

    @Test
    public void testJumper2() {
        world.add(new Location(2, 4), jumper);
        jumper2.setDirection(Location.SOUTH);
        world.add(new Location(1, 4), jumper2);
        jumper.act();
        jumper2.act();
        int dir = jumper.getDirection();
        int dir2 = jumper2.getDirection();
        Location loc = jumper.getLocation();
        Location loc2 = jumper2.getLocation();
        Location loct = new Location(0, 4);
        Location loct2 = new Location(3, 4);
        assertTrue(loc.equals(loct) && dir == Location.NORTH);        
        assertTrue(loc2.equals(loct2) && dir2 == Location.SOUTH);
    }
}