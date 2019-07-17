package game;

import location.Location;

import location.OutdoorsArea;	//filerna verkar inte kommunicera med varandra
import location.Room;
import lab1.*;

/**
 * @author Ingrid Wendin
 *
 */

import java.util.Scanner;

public class Game {
	
	private Window window;

	private static String command;
	private static String[] parts;
	
	private Location[] world;
	private static int maxLocations = 10;
	private int noOfLocations = 0;
	
	private Item[] items;	//item array
	private static int maxItems = 50;
	private int noOfItems = 0;
	
	private NPC[] npcs;
	private static int maxNPCs = 20;
	private int noOfNPCs = 0;
	
	public Game() {
		world = new Location[maxLocations];
		items = new Item[maxItems];
		npcs = new NPC[maxNPCs];
		
		//Building the game world
		GameWorldSetUp setUp = new GameWorldSetUp();
		setUp.setUp(this);	//return game but this = setUp.setUp(this) is not needed and even doesn't work??
	}
	
	public void addLocation(Location loc) {
		world[noOfLocations] = loc;
		noOfLocations++;
	}
	
	public void addItem(Item item) {
		items[noOfItems] = item;
		noOfItems++;
	}
	
	public void addNPC(NPC npc) {
		npcs[noOfNPCs] = npc;
		noOfNPCs++;
	}
	
	public Location getLocation(String name) {
		Location loc = new Location();
		for(int i = 0; i < maxLocations; i++ ) {
			if(world[i].getName() == name) {
				loc = world[i];
				break;
			} else {
				//Searching next array element
			}
		} return loc;
	}
	
	public Item getItem(String name) {
		Item it = new Item();
		for(int i = 0; i < noOfItems; i++) {
			if(items[i].getName().contentEquals(name)) {
				it = items[i];
				break;
			} else {
				//
			}
		} return it;
	}
	
	private Location directionToPosition(Location pos, String direction) { //function returns location in the direction
		int dir = 4;	//not existing
		switch(direction) {
			case "north":
				dir = 0;
				break;
			case "west":
				dir = 1;
				break;
			case "east":
				dir = 2;
				break;
			case "south":
				dir = 3;
				break;
			default:
				dir = 4;	//not existing
		}
		if(dir < 4) {
			if((pos.getPath(dir) != null)) {	//there is a path in the direction
				return pos.getPath(dir);
			}
		} return pos;	//if path in the direction does not exist -> remain
	}
	
	public void tomsIntro() {
		window.print("Hello there, I'm Tom, wellcome to the Leaky Culdron.");
		window.print("You look like a Hogwarts first year");
		window.print("What is your name young student?");
	}
	
	public void showDiagonAlley() {
		window.print("Diagon Alley, where you can shop for all of your school items, is on the other side of the brick wall over there.");
		window.print("Here, I'll help you open it up.");
		window.print("--Tom knocks on a handful carefully selected bricks-- ");
		window.print("--With a low rumble from the moving bricks, an opening is created in the wall--");
		window.print("--You hear noice of humans from the opening and walk into another unknown place--");
		window.print("");
	}
	
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		window = new Window();
		//GameWorldSetUp GameSetUp = new GameWorldSetUp();
		
		/*TO DO
		ok! change every item in game file to using the objects in items array
		ok! wearable items: create default clothes in world and add to player
		-wearable items: add durability, health, protection 
		ok! control why npc is not listed when location is described
		-connect window to program, make it return inputed string
		
		*/
		
		//TEST
		
/*		System.out.println(noOfItems);
		for(int i = 0; i < noOfItems; i++) {
			System.out.println(items[i].getName());
		}
		
		System.out.println(noOfNPCs+ "in the game npc array");
		for(int i = 0; i < noOfNPCs; i++) {
			System.out.println(npcs[i].getName());
		}
*/	
		//_______________//
		
		
		//Initiating player
		tomsIntro();
		String playerName = sc.nextLine();
		parts = playerName.split(" ");
		playerName = parts[0];
		
		Player player = new Player(playerName, this.getLocation("the Leaky Culdron"), (WearableItem)this.getItem("basic_shirt"), (WearableItem)this.getItem("basic_pants"), (WearableItem)this.getItem("basic_shoes"));
		
		System.out.println("Nice to meet you "+player.getName()+".");
		showDiagonAlley();
		player.moveTo(this.getLocation("Diagon Alley"));
		
		//Game loop
		System.out.println("What do you want to do?");
		command = sc.nextLine();
		parts = command.split(" ");
		
		while(!(parts[0].equals("quit"))) {
			if(parts[0].isEmpty()) {
				player.getPosition().listPaths(player, player.getPosition().getWayType());//remain
			}
			else if(parts[0].contentEquals("north") || parts[0].contentEquals("west") || parts[0].contentEquals("east") || parts[0].contentEquals("south")) {
				player.moveTo(directionToPosition(player.getPosition(), parts[0]));
			}
			else if(parts[0].contentEquals("take") && parts.length > 1 ) {
				
				if(player.getPosition().getItems(parts[1])) { //if location has item
					player.takeItem(player.getPosition().getItem(parts[1]));
					player.getPosition().removeItem(parts[1]);

					System.out.println("You have picked up the "+parts[1]);
					player.getItem(parts[1]).pickUpComment();
				}
				else {
					System.out.println("There is no "+parts[1]+" here");
				}
			}
			else if(parts[0].contentEquals("list")) {
				player.listItems();
			}
			else if(parts[0].contentEquals("dig")) {
			//	if(player.hasShovel()) {
				if(player.hasItem("shovel")) {
				this.getItem("shovel").use(player);
				}
			} 
			else if(parts[0].contentEquals("give") && parts.length > 1) {
				if(player.hasItem(parts[1])) {
					player.giveItem(player.getItem(parts[1]));
				} 
				else {
					System.out.println("You dont have that item.");
				}
			} 
			else if(parts[0].contentEquals("wear") && parts.length > 1) {
				if(player.hasItem(parts[1]) && (player.getItem(parts[1]) instanceof WearableItem)) {
					WearableItem it = new WearableItem();
					it = (WearableItem)this.getItem(parts[1]);
					it.putOn(player);
				}
			}
			else {
				System.out.println("Something must have gone wrong. Are you tired?");
			}
			System.out.println("What do you want to do?");
			command = sc.nextLine();
			parts = command.split(" ");
		}
		sc.close();
	}


	public static void main(String[] args) {
		
		Game game = new Game();
		
		//Game starts
		game.run();
	}
}