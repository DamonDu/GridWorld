
public class SparseGridNode {

	private Object occupant;
	private int col;
	private SparseGridNode next;
	
	public SparseGridNode(Object occupant, int col, SparseGridNode next){
		this.occupant = occupant;
		this.col = col;
		this.next = next;
	}
	
	public Object getOccupant() {
		return this.occupant;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public SparseGridNode getNext() {
		return this.next;
	}
	
	public void setOccupant(Object occupant) {
		this.occupant = occupant;
	}
	
	public void setNext(SparseGridNode next) {
		this.next = next;
	}
}
