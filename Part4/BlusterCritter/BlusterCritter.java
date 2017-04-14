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
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
	int c;
	private static final double DARKENING_FACTOR = 0.05;
	
	public BlusterCritter(int c){
		super();
		this.c = c;
	}
	
	public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Location location =getLocation();
        int row = location.getRow();
        int col = location.getCol();
        for (int i = row - 2; i <= row + 2; i++){
        	for (int j = col - 2; j <= col + 2; j++){
    			if(getGrid().isValid(new Location(row, col))){
    				Actor actor = getGrid().get(new Location(row, col));
    				if(actor != null && actor != this)
    					actors.add(actor);	
        		}
        	}
        }
        return actors;
    }
	
	
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
    public void processActors(ArrayList<Actor> actors)
    {
    	int n = 0;
    	for(Actor actor : actors){
    		if(actor instanceof Critter){
    			n++;
    		}
    	}
    	if (n < c){
    		lighten();
    	}
    	else{
        	darken();
        }   
    }   
    
    /**
     * Turns towards the new location as it moves.
     */
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
    
    public void darken()
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
    } 
    
    public void lighten()
    {
        Color c = getColor();
        int red = (int) c.getRed();
        int green = (int) c.getGreen();
        int blue = (int) c.getBlue();
        
        if(red < 255)
        	red++;
        if(green < 255)
        	green++;
        if(blue < 255)
        	blue++;
        setColor(new Color(red, green, blue));
    } 
}
