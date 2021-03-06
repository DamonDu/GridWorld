import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class SparseBoundedGridRunner {
	public static void main(String[] args) {
		ActorWorld world = new ActorWorld();
		world.addGridClass("SparseBoundedGrid");
		world.addGridClass("SparseBoundedGrid2");
		world.addGridClass("SparseBoundedGrid3");
		world.addGridClass("UnboundedGrid2");
		world.add(new Location(4, 4), new Critter());
		world.show();
	}
}
