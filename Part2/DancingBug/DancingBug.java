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

public class DancingBug extends Bug
{
    private int steps;
    private int sideLength;
    private int[] turn;
    private int turnTime;
    private int nowTurn;

    /**
	 * AP(r) Computer Science GridWorld Case Study:
	 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
	 *
	 * This code is free software; you can redistribute it and/or modify
	 * it under the terms of the GNU General Public License as published by
	 * the Free Software Foundation
	 */
    public DancingBug(int []turn)
    {
        steps = 0;
        sideLength = 1;
        this.turn = new int[turn.length];
        System.arraycopy(turn, 0, this.turn, 0, turn.length);
        turnTime = 0;
        nowTurn = 0;
    }

	public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
        	if(nowTurn < turnTime % turn.length){
        		turn();
        		nowTurn++;
        	}
        	else{
        		steps = 0;
        		turnTime++;
        		nowTurn = 0;
        	}
        }
    }
}
