/**
 * 
 */
package location;
import lab1.*;
import java.util.ArrayList; 

/**
 * @author Ingrid Wendin
 *
 */

public class Location {
	private String name;
	private String description;
	private String firstIntroduction;
	private Location[] paths;
	private Boolean firstTimeVisiting;
	private Item items[];
	private int numberOfItems = 0;
	private NPC[] npcs;
	private int numberOfNPCs = 0;

	
	//Default values and messages
	private String defaultName = "a magical place";
	private String defaultDescription = "You have entered a magical location.";
	private String defaultFirstIntroduction = "You have entered a magical location. There are many things here you haven't seen before";
	private static int maxNumberOfPaths = 4;
	private static int maxNumberOfItems = 100;
	private static int maxNumberOfNPCs = 10;
	
	//Konstruktor
	public Location() {
		this.name = this.defaultName;
		this.description = this.defaultDescription;
		this.firstIntroduction = defaultFirstIntroduction;
		this.paths = new Location[maxNumberOfPaths];
		this.firstTimeVisiting = true;
		this.items = new Item[maxNumberOfItems];
		this.npcs = new NPC[maxNumberOfNPCs];
	}
	//Konstruktor
	public Location(String name) {
		this.name = name;
		this.description = this.defaultDescription;
		this.firstIntroduction = defaultFirstIntroduction;
		this.paths = new Location[maxNumberOfPaths];
		this.firstTimeVisiting = true;
		this.items = new Item[maxNumberOfItems];
		this.npcs = new NPC[maxNumberOfNPCs];
	}
	
	public void addNPC(NPC npc) {
		this.npcs[numberOfNPCs] = npc;
		numberOfNPCs++;
	}
	
	public void listNPCs() {
		if(numberOfNPCs > 0) {
			System.out.print("There is ");
			for(int i = 0; i < numberOfNPCs; i++) {
				System.out.print(" "+npcs[i].getName()+" ");
			}
			System.out.println("in front of you");
		}
	}
	
	public void addPath(Location destination, int direction) {
		if(direction < maxNumberOfPaths) {
			if((paths[direction] == null) && (destination.paths[3-direction] == null || destination.paths[3-direction].getName() == this.getName())) { //.equals(null) gives exception? -> can't use -equals because element is null?
				paths[direction] = destination;
				destination.addPath(this,(3-direction));
			} else {
			}
		} else {
			System.out.println("There only exists four directions on a compass");
		}
	}
	
	public Location getPath(int i) {
		return this.paths[i];
	}
	
	public void listPaths(Player player, String roadType) {
		for(int i = 0; i < 4; i++) {
			String direction = getDirection(i); //get North 0, West 1, East 2, South 3
			
			if(direction != null && getPathDestinationName(i).contentEquals("Knockturn Alley")) {
			//	if(player.hasWand()) {
				if(player.hasItem("wand")) {
					System.out.println("There is a "+roadType+" leading to "+direction+"."+getPathDestinationName(i)); //getPathDestinationName for control purpose
				} else {
					continue; //nothing
				}
			} else if(direction != null && getPathDestinationName(i).contentEquals("Unknown Vault")) {
			//	if(player.hasKey()) {
				if(player.hasItem("key")) {
					System.out.println("There is a "+roadType+" leading to "+direction+"."+getPathDestinationName(i)); //getPathDestinationName for control purpose
				} else {
					continue; //nothing
				}
			} else if(direction != null){
					System.out.println("There is a "+roadType+" leading to "+direction+"."+getPathDestinationName(i)); //getPathDestinationName for control purpose
			} else {
				continue;
			}
		}
	}
	
	public String getPathDestinationName(int i) {
		return this.paths[i].getName();
	}
	
	public String getDirection(int i) {
		String direction = null;
		if(paths[i] != null) {
			switch(i) {
			case 0: {
				direction = "north";
				break;
			}
			case 1: {
				direction = "west";
				break;
			}
			case 2: {
				direction = "east";
				break;
			}
			case 3: {
				direction = "south";
				break;
			}
			}
		} else {	//All places needs a door or a path leading to it
			direction = null;
		}
		return direction;
	}
	//items
	public void addItem(Item it) {
		items[numberOfItems] = it;
		numberOfItems++;
	//	System.out.println(this.getName()+" has "+numberOfItems+" number of items"); //Control
	}
	
	public void removeItem(String itemName) {
		for(int i = 0; i < numberOfItems; i++) {
			if(itemName.contentEquals(items[i].getName())) {
				for(int j = i; j <= numberOfItems-1; j++) {
					items[j] = items[j+1];
				}
				numberOfItems--;
			}
		}
	}
	
	public void listItems() {	//Control method, can be removed 
		for(int i = 0; i < numberOfItems; i++) {
			items[i].introduceYourself();
		}
	}
	
	public Item getItem(String itemName) {
		Item it = new Item();
		for(int i = 0; i < numberOfItems; i++) {
			if(itemName.equals(items[i].getName())) { //parts[0].equals("quit"
				it = items[i];
				break;
			} else {
				//do nothing
			}
		}
		return it;
	}
	
	public boolean getItems(String itemName) {
		boolean res = false;
		for(int i = 0; i < numberOfItems; i++) {
			if(items[i].getName().contentEquals(itemName)) {
				res = true;
				return res;
			} else {
				//do nothing
			}
		}
		return res;
	}
	
	//other
	public void doCommand(String str, Player player) {
		System.out.println("Nothing particulary seems to happen");
	}
	
	//helpers
	public boolean isRoom() {
		return false;
	}
	
	public String getWayType() {
		return "path";	//Path is default
	}
	
	public Boolean isFirstTimeVisiting() {
		return firstTimeVisiting;
	}
	
	public void setFirstTimevisitingFalse() {
		firstTimeVisiting = false;
	}
	
	public void describeYourself(Player player) {
		System.out.println(description);
		this.listItems();
		this.listNPCs();
	}
	
	public String getName() {
		return this.name;
	}
}