
public class OccupantInCol {
	private Object occupant;
	private int col;
	
	public OccupantInCol(Object occupant, int col){
		this.col = col;
		this.occupant = occupant;
	}
	
	public Object getOccupant() {
		return this.occupant;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public void setOccupant(Object occupant) {
		this.occupant = occupant;
	}
}
