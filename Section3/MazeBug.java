package info.gridworld.maze;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug{
	public Location next;
	public Location last;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown
	
	public Stack<Location> path = new Stack<Location>();
	private int[] prob = {1, 1, 1, 1};
	
	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug() {
		setColor(Color.GREEN);
		last = new Location(0, 0);
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		//add the initial location to the first array list
		if(stepCount==0){
			Location local = this.getLocation();
			dirPredict();
			ArrayList<Location> start = new ArrayList<Location>();
			start.add(local);
			path.push(local);
			crossLocation.add(start);
		}
	
		if (stepCount==341) {
			dirPredict();
		}
		
		boolean willMove = canMove();
		
		if (isEnd == true) {
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove) {
			move();
			//increase step count when move
			stepCount++;
		} else {
			//If can't move, return to last location
			Back();
		}
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location l) {
		int[] dir = {Location.SOUTH, Location.WEST, Location.NORTH, Location.EAST};
		
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return null;
		ArrayList<Location> valid = new ArrayList<Location>();
		
		for (int i = 0; i < 4; i++) {
			Location location = l.getAdjacentLocation(dir[i]);
			if(gr.isValid(location)){
				Actor actor = gr.get(location);
				if ((actor instanceof Rock) && actor.getColor().equals(Color.RED)) {
					next = location;
					
					ArrayList<Location> loc = new ArrayList<Location>();
					loc.add(next);
					
					return loc;
				} else if(actor == null) {
					valid.add(location);
				}
			}
		}
		return valid;
	}

	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */
	public boolean canMove() {
		ArrayList<Location> validLocation = new ArrayList<Location>();
		Location current = this.getLocation();
		
		validLocation = getValid(current);

		if (validLocation.size() == 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		Location loc = this.getLocation();
		
		ArrayList<Location> chooseLocation = getValid(loc);

		int x = 0;
		int max = 0;
		int total = 0;
		int which = 0;
		
		for (Location get : chooseLocation) {
			int dir = loc.getDirectionToward(get);
			if (prob[dir / 90] > max) {
				max = prob[dir / 90];
				x = (int) dir / 90;
				which = total;
			}
			total++;
		}
		
		if (chooseLocation.size() == 1) {
			next = chooseLocation.get(which); 
			prob[x]++;
		} else {
			int randomNum = (int) (Math.random() * 10);
			if(randomNum >= 0 && randomNum < 7){
				next = chooseLocation.get(which); 
				prob[x]++;
			}else {
				next = chooseLocation.get(randomNum % chooseLocation.size()); 
				int dir = loc.getDirectionToward(next);
				x = dir / 90;
				prob[x]++;
			}
		}
		
		for (Location l : chooseLocation) {
			if( this.getDirection() == this.getLocation().getDirectionToward(l) ){
				next = l;
				int dire = loc.getDirectionToward(next);
				x = dire / 90;
				prob[x]++;
				break;
			}
		}
		
		if (gr.isValid(next)) {
			Actor actor = gr.get(next);
			
			if( actor instanceof Rock && actor.getColor().equals(Color.RED) ){
				isEnd = true;
			}
			moveTo(next);
			path.push(next);
			int facing = loc.getDirectionToward(next);
			this.setDirection(facing);
			
			ArrayList<Location> med = crossLocation.pop();
			med.add(next);
			crossLocation.push(med);
			
			ArrayList<Location> latest = new ArrayList<Location>();
			latest.add(next);
			crossLocation.push(latest);
			
		} else {
			removeSelfFromGrid();
		}
		
		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}
	
	public void Back(){
		if (crossLocation.size() > 0) {
			crossLocation.pop();
			path.pop();
			if(crossLocation.size() > 0){
				Grid<Actor> gr = getGrid();
				if( gr == null )
					return;
				ArrayList<Location> back = crossLocation.peek();
				Location backLoc = back.get(0);

				Location current = this.getLocation();
				
				int dir = current.getDirectionToward(backLoc);
				if (gr.isValid(backLoc)) {
					this.setDirection(dir);
					moveTo(backLoc);
					stepCount++;
				}else {
					removeSelfFromGrid();
				}
				if ((int)(dir / 90) == 0) {
					prob[2]--;
				} else if ((int)(dir / 90) == 1) {
					prob[3]--;
				} else if ((int)(dir / 90) == 2) {
					prob[0]--;
				} else if ((int)(dir / 90) == 3) {
					prob[1]--;
				}
				Flower flower = new Flower(getColor());
				flower.putSelfInGrid(gr, current);
			}
		}
	}

	public void dirPredict(){
		Grid<Actor> gr = getGrid();
		ArrayList<Location> array = gr.getOccupiedLocations();
		
		for (Location a : array) {
			Actor act = gr.get(a);
			if (act instanceof Rock && act.getColor().equals(Color.RED)) {
				Location loc = this.getLocation();
				if (loc.getRow() < a.getRow()) {
					prob[2] = 6;
					prob[0] = 1;
				} else {
					prob[0] = 6;
					prob[2] = 1;
				}
				
				if (loc.getCol() < a.getCol()) {
					prob[1] = 6;
					prob[3] = 1;
				} else {
					prob[3] = 6;
					prob[1] = 1;
				}
				break;
			}
		}
	}
}

