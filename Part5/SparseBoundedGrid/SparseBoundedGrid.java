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
import info.gridworld.grid.*;

/**
 * <code>Grid</code> provides an interface for a two-dimensional, grid-like
 * environment containing arbitrary objects. <br />
 * This interface is testable on the AP CS A and AB exams.
 */
public class SparseBoundedGrid<E> extends AbstractGrid<E>
{
	private SparseGridNode[] occupants;
	private int col;
	private int row;
    /**
     * Returns the number of rows in this grid.
     * @return the number of rows, or -1 if this grid is unbounded
     */
	public SparseBoundedGrid(int col, int row){
		if (col <= 0)
            throw new IllegalArgumentException("col <= 0");
        if (row <= 0)
            throw new IllegalArgumentException("row <= 0");
		this.col = col;
		this.row = row;
		occupants = new SparseGridNode[row];
	}
	
    public int getNumRows(){
    	return row;
    }

    /**
     * Returns the number of columns in this grid.
     * @return the number of columns, or -1 if this grid is unbounded
     */
    public int getNumCols(){
    	return col;
    }

    /**
     * Checks whether a location is valid in this grid. <br />
     * Precondition: <code>loc</code> is not <code>null</code>
     * @param loc the location to check
     * @return <code>true</code> if <code>loc</code> is valid in this grid,
     * <code>false</code> otherwise
     */
    public boolean isValid(Location loc){
    	 return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                 && 0 <= loc.getCol() && loc.getCol() < getNumCols();
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
    	 E beRemoved = remove(loc);
    	 int row = loc.getRow();
    	 int col = loc.getCol();
    	 SparseGridNode temp = occupants[row];
    	 occupants[row] = new SparseGridNode(obj, col, temp);
    	 return beRemoved;
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
	   	 SparseGridNode temp = occupants[row];
	   	 E tempE = get(loc);
	   	 if (tempE == null)
	   		 return null;
	   	 if(temp != null){
	   		 if (temp.getCol() == loc.getCol())
	   			 occupants[row] = temp.getNext();
	   		 else{
	   			 SparseGridNode next = temp.getNext();
	   			 while(next != null){
	   				 if (next.getCol() != loc.getCol()){
	   					 next = next.getNext();
	   					 temp = temp.getNext();
	   				 }
	   			 }
	   			 if(next != null){
	   				 temp.setNext(next.getNext());
	   			 }
	   		 }
	   	 }
	   	return tempE;
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
    	 SparseGridNode temp = occupants[row];
    	 while (temp != null){
    		 if(temp.getCol() == col){
    			 return (E)temp.getOccupant();
    		 }
    		 temp = temp.getNext();
    	 }
    	 return null;
    }

    /**
     * Gets the locations in this grid that contain objects.
     * @return an array list of all occupied locations in this grid
     */
    public ArrayList<Location> getOccupiedLocations(){
    	ArrayList<Location> occupiedLocations = new ArrayList<Location>();
    	for (int row = 0; row < getNumRows();row++){
    		SparseGridNode temp = occupants[row];
    		while (temp != null){
    			Location location = new Location(row, temp.getCol());
    			occupiedLocations.add(location);
    			temp = temp.getNext();
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
}