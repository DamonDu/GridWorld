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

public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int turnTime;

    public ZBug(int length)
    {
        steps = 0;
        sideLength = length;
        turnTime = 3;
        this.setDirection(90);
    }
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
    public void act()
    {
    	if (turnTime == 0 && steps == sideLength) {
    		return;
    	}
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
        	for(int i = 0; i < turnTime; i++){
        		turn();
        	}
        	switch(turnTime){
        	case 3:
        		turnTime = 5;
        		break;
        	case 5:
        		turnTime = 0;
        		break;
    		case 4:
    			break;
        	}
            steps = 0;
        }
    }
}
