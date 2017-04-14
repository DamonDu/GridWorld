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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import sun.management.counter.Variability;

import java.util.ArrayList;

import javax.print.attribute.standard.PrinterMessageFromOperator;

import com.sun.org.apache.xml.internal.resolver.helpers.Debug;

import java.awt.Color;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChameleonKid extends ChameleonCritter
{
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
	
	/**
     * A critter acts by getting a list of other actors, processing that list,
     * getting locations to move to, selecting one of them, and moving to the
     * selected location.
     */
	public void act()
    {
        if (getGrid() == null)
            return;
        Location nowLoc = this.getLocation();
        ArrayList<Actor> actors = this.getActors(nowLoc);
        this.processActors(actors);
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
    }
	
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0){
        	darken();
        	return;
        }   
        int r = (int) (Math.random() * n);
        
        Actor other = actors.get(r);
        setColor(other.getColor());
    }
    
    /**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy neighboring grid locations. Override this method in subclasses to
     * look elsewhere for actors to process.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors(Location loc)
    {
    	ArrayList<Actor> neighbors = new ArrayList<Actor>();
    	int dir = getDirection();
    	for (Location neighborLoc : getGrid().getOccupiedAdjacentLocations(loc)){
    		if(loc.getDirectionToward(neighborLoc) == dir || loc.getDirectionToward(neighborLoc) == dir + 180){
    			neighbors.add(getGrid().get(neighborLoc));
    		}
    	}
        return neighbors;
    }
    /**
     * Turns towards the new location as it moves.
     */
}
