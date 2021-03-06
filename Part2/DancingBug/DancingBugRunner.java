
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


public final class DancingBugRunner
{
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

	private DancingBugRunner(){}
	
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        int[] turn = {0,1,2,3,4,5};
        DancingBug bob = new DancingBug(turn);
        world.add(new Location(5,5), bob);
        world.show();
    }
}