/**
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
import info.gridworld.grid.*;
import info.gridworld.actor.*;

public class Jumper extends Bug
{
	public Jumper(){}

	public void act()
	{
		if (canJump())
		{
			jump();
		}
		else if (canMove())
		{
			move();
		}
		else
		{
			turn();
		}
	}
	
	/**
	 * This code is free software; you can redistribute it and/or modify
	 * it under the terms of the GNU General Public License as published by
	 * the Free Software Foundation.
	 */
	public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null){
        	return false;
        }
        Location loc = getLocation();
        int direc = getDirection();
        Location next = loc.getAdjacentLocation(direc).getAdjacentLocation(direc);
        if (!gr.isValid(next)){
        	 return false;
        }
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any otlrszher actor
    }
	
	/**
	 * This code is free software; you can redistribute it and/or modify
	 * it under the terms of the GNU General Public License as published by
	 * the Free Software Foundation.
	 */
	public void jump(){
		Grid<Actor> gr = getGrid();
        if (gr == null){
        	 return;
        }
        Location loc = getLocation();
        int direc = getDirection();
        Location next = loc.getAdjacentLocation(direc).getAdjacentLocation(direc);
        if (gr.isValid(next)){
        	moveTo(next);
        }
        else{
        	removeSelfFromGrid();
        } 
	}
}
