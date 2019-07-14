/**
 * 
 */
package location;

import lab1.Player;

/**
 * @author Ingrid Wendin
 *
 */
public class Room extends Location {
	
	private int size;
	private static int defaultSize = 10;
	private String firstIntroduction;
	private String shortDescription;
	private String door = "door";
	
	private String defaultFirstIntroduction = "There are many things here you haven't seen before";
	private String defaultShortDescription  = "You have enterd the magical room ";
	
	public Room() {	//Default name in Location Constructor	
		this.size = defaultSize;
		this.shortDescription = defaultShortDescription;
		this.firstIntroduction = defaultFirstIntroduction;
	}
	
	public Room(String name, int size, String firstIntroduction, String shortDescription) {
		super(name);
		this.size = size;
		this.shortDescription = shortDescription;
		this.firstIntroduction = firstIntroduction;
	}
	
	public void describeYourself(Player player) {
		if(isFirstTimeVisiting()) {
			if(firstIntroduction.equals(defaultFirstIntroduction)) {
				System.out.println(shortDescription + getName() + ". " + firstIntroduction);
				setFirstTimevisitingFalse();
			} else {
				System.out.println(firstIntroduction);
				setFirstTimevisitingFalse();
			}
		} else {
			if(shortDescription.equals(defaultShortDescription)) {
				System.out.println(shortDescription + getName());
			} else {
				System.out.println(shortDescription);
			}
		}
		this.listItems();
		this.listNPCs();
		this.listPaths(player, door);
		System.out.println("");
	}
	
	public void listDoors(Player player) {
		for(int i = 0; i < 4; i++) {
			String direction = getDirection(i); //get North 0, West 1, East 2, South 3
		//	if(direction != null && player.hasWand()) {
			if(direction != null && player.hasItem("wand")) {
				System.out.println("There is a door leading to "+direction+"."+getPathDestinationName(i)); //getPathDestinationName for control purpose
			} else if(direction != null && !getPathDestinationName(i).contentEquals("Knockturn Alley")) {
				System.out.println("There is a door leading to "+direction+"."+getPathDestinationName(i)); //getPathDestinationName for control purpose
			} else {
				continue;
			}
		}
	}
	
	public void doCommand(String str, Player player) {
		if(str.contentEquals("dig")) {
			System.out.println("You got strucked by a stinging hex and lose 5 hp.");
			player.looseHealth(5);
			System.out.println("Your hp is now "+player.getHealth()+" hp.");
		}
	}
	
	//Helpers
	public boolean isRoom() {
		return true;
	}
	
	public String getWayType() {
		return door;
	}
	
	public int getSize() {
		return this.size;
	}
}
