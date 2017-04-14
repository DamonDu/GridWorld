/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
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
 * @author Alyce Brady
 * @author APCS Development Committee
 * @author Cay Horstmann
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.*;

import info.gridworld.grid.*;

/**
 * <code>Grid</code> provides an interface for a two-dimensional, grid-like
 * environment containing arbitrary objects. <br />
 * This interface is testable on the AP CS A and AB exams.
 */
public class UnboundedGrid2<E> extends AbstractGrid<E>
{
	private Object[][] occupants;
	private int dim;
    /**
     * Returns the number of rows in this grid.
     * @return the number of rows, or -1 if this grid is unbounded
     */
	public UnboundedGrid2(){
		dim = 16;
		occupants = new Object[dim][dim];
	}
	
    public int getNumRows(){
    	return dim;
    }

    /**
     * Returns the number of columns in this grid.
     * @return the number of columns, or -1 if this grid is unbounded
     */
    public int getNumCols(){
    	return dim;
    }

    /**
     * Checks whether a location is valid in this grid. <br />
     * Precondition: <code>loc</code> is not <code>null</code>
     * @param loc the location to check
     * @return <code>true</code> if <code>loc</code> is valid in this grid,
     * <code>false</code> otherwise
     */
    public boolean isValid(Location loc){
    	 return 0 <= loc.getRow() && 0 <= loc.getCol();
    }

    /**
     * Puts an object at a given location in this grid. <br />
     * Precondition: (1) <code>loc</code> is valid in this grid (2)
     * <code>obj</code> is not <code>null</code>
     * @param loc the location at which to put the object
     * @param obj the new object to be added
     * @return the object previously at <code>loc</code> (or <code>null</code>
     * if the location was previously unoccupied)
     */
    public E put(Location loc, E obj){
    	 if (!isValid(loc))
             throw new IllegalArgumentException("Location " + loc
                     + " is not valid");
    	 if(obj == null)
    		 throw new NullPointerException("obj == null");
    	 int row = loc.getRow();
    	 int col = loc.getCol();
    	 if(row>= dim || col >= dim)
    		 resize(loc);
    	 E old = get(loc);
    	 occupants[row][col] = obj;
    	 return old;
    }

    /**
     * Removes the object at a given location from this grid. <br />
     * Precondition: <code>loc</code> is valid in this grid
     * @param loc the location of the object that is to be removed
     * @return the object that was removed (or <code>null<code> if the location
     *  is unoccupied)
     */
    public E remove(Location loc){
    	if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
    	int row = loc.getRow();
   	 	int col = loc.getCol();
   	 	if(row>= dim || col >= dim)
   	 		return null;
   	 	E temp = (E)occupants[row][col];
   	 	occupants[row][col] = null;
   	 	return temp;
    }
    

    /**
     * Returns the object at a given location in this grid. <br />
     * Precondition: <code>loc</code> is valid in this grid
     * @param loc a location in this grid
     * @return the object at location <code>loc</code> (or <code>null<code> 
     *  if the location is unoccupied)
     */
    public E get(Location loc){
    	if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
	   	 int row = loc.getRow();
	   	 int col = loc.getCol();
	   	 if(row>= dim || col >= dim)
	   		 return null;
	   	 return (E)occupants[row][col];
    }

    /**
     * Gets the locations in this grid that contain objects.
     * @return an array list of all occupied locations in this grid
     */
    public ArrayList<Location> getOccupiedLocations(){
    	ArrayList<Location> occupiedLocations = new ArrayList<Location>();
    	for(int i = 0; i < dim; i++){
    		for(int j = 0; j < dim; j++){
    			Location location = new Location(i, j);
    			if(get(location) != null)
    				occupiedLocations.add(location);
    		}
    	}
    	return occupiedLocations;
    }

    /**
     * Gets the valid locations adjacent to a given location in all eight
     * compass directions (north, northeast, east, southeast, south, southwest,
     * west, and northwest). <br />
     * Precondition: <code>loc</code> is valid in this grid
     * @param loc a location in this grid
     * @return an array list of the valid locations adjacent to <code>loc</code>
     * in this grid
     */
    
    public void resize(Location loc) {
		int size = dim;
		while(loc.getCol() >= size || loc.getRow() >= size)
			size*=2;
		Object[][] temp = new Object[size][size];
		for(int i = 0;i < dim; i++){
			for(int j = 0; j < dim; j++){
				temp[i][j] = occupants[i][j];
			}
		}
		occupants = temp;
		dim = size;
	}
}