package lab1;
import location.Location;

public class NPC {
	private Location place;
	private int hp;
	private String name;
	
	public NPC(Location place, int hp, String name) {
		//this.place = new Location();
		this.place = place;
		this.hp = hp;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
