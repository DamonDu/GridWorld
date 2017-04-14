import static org.junit.Assert.*;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import org.junit.Before;
import org.junit.Test;


public class JumperTest {

	/**
	 * This code is free software; you can redistribute it and/or modify
	 * it under the terms of the GNU General Public License as published by
	 * the Free Software Foundation.
	 */
	private ActorWorld world = new ActorWorld();
	private Jumper testJumper = new Jumper();
	
	@Before
	public void setUp() throws Exception {
		world.add(new Location(5, 5), testJumper);
	}

	@Test
	public void testAct() {
		Location startloc = testJumper.getLocation();
		int direc = testJumper.getDirection();
		if (testJumper.canJump())
		{
			testJump();
		}
		else if (testJumper.canMove())
		{
			testJumper.move();
			Location nowLoc = testJumper.getLocation();
	        Location testLoc = startloc.getAdjacentLocation(direc);
	        assertEquals(nowLoc, testLoc);
		}
		else
		{
			testJumper.turn();
			assertEquals(testJumper.getDirection(), direc + 45);
		}
	}

	/**
	 * This code is free software; you can redistribute it and/or modify
	 * it under the terms of the GNU General Public License as published by
	 * the Free Software Foundation.
	 */
	@Test
	public void testCanJump() {
		boolean testCanJump1 = testJumper.canJump();
		assertEquals(true, testCanJump1);
	}

	@Test
	public void testJump() {
		if (testJumper.canJump()){
			Location startloc = testJumper.getLocation();
			int direc = testJumper.getDirection();
			testJumper.jump();
			Location nowLoc = testJumper.getLocation();
	        Location testLoc = startloc.getAdjacentLocation(direc).getAdjacentLocation(direc);
	        assertEquals(nowLoc, testLoc);
		}
	}

}
