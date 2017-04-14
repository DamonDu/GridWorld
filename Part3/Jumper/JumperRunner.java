/**
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public final class JumperRunner
{
	private JumperRunner(){}
	/**
	 * AP(r) Computer Science GridWorld Case Study:
	 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
	 *
	 * This code is free software; you can redistribute it and/or modify
	 * it under the terms of the GNU General Public License as published by
	 * the Free Software Foundation.
	 */
    public static void main(String[] args)
    {
    	Rock rock = new Rock();
        ActorWorld world = new ActorWorld();
        Jumper alice = new Jumper();
        world.add(new Location(7, 8), alice);
        world.add(new Location(6, 8), rock);
        world.show();
    }
}