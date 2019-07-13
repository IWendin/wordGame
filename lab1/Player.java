/**
 * 
 */
package lab1;

import location.Location;


/**
 * @author Ingrid Wendin
 *
 */
public class Player {
	private String name;
	private Location position;
	private int gold;
	private int health;
	private Item items[];
	private WearableItem clothes[];
/*	
	private boolean hasShovel;
	private boolean hasWand;
	private boolean hasKey;
*/
	
	//Default
	private static int startingGold = 10;
	private static int startingHealth = 100;
	private static int maxNumberOfItems = 100;
	private static int numberOfItems = 0;
	private static int maxNumberOfClothes = 6;	//0: hat, 1: shoulder pads, gloves, shirt, pants, 5: shoes
//	private static int numberOfClothes = 3;		//shirt, pants, shoes
/*	private static boolean initHasShovel = false;
	private static boolean initHasWand = false;
	private static boolean initHasKey = false;
*/
	
	public Player(String playerName, Location startPosition, WearableItem shirt, WearableItem pants, WearableItem shoes) {
		
		this.name = playerName;
		this.position = startPosition;
		this.gold = startingGold;
		this.health = startingHealth;
		this.items = new Item[maxNumberOfItems];
		this.clothes = new WearableItem[maxNumberOfClothes];

		clothes[3] = shirt;
		clothes[4] = pants;
		clothes[5] = shoes;
	}
	
	//Clothes
	public void putOnClothes(WearableItem cloth) {
		if(clothes[cloth.getPosition()] != null) {
			takeOffClothes(cloth.getPosition());	//takes off existing wearable item from clothes[]
		}
		removeItem(cloth);							//removes new from inventory
		clothes[cloth.getPosition()] = cloth;		//adds new to clothes[]
		System.out.println("You have put on "+cloth.getName());
	}
	
	public void takeOffClothes(int position) {
		takeItem(clothes[position]);
		System.out.println("You have removed "+clothes[position].getName());
	}
	
	//items
	public void takeItem(Item it) {	//player.takeItem(player.getPosition().getItem(parts[1]));
		items[numberOfItems] = it;
		numberOfItems++;
	}
	
	public void listItems() {
		System.out.println("You have the following items: ");
		for(int i = 0; i < numberOfItems; i++) {
			items[i].printYourself();
		}
	}
	
	public void removeItem(Item item) {
		for(int i = 0; i < numberOfItems; i++) {
			if(items[i] == item) {
				for(int j = i; j < numberOfItems -1; j++) {	
					items[j] = items[j+1];
				}
				numberOfItems--;
			}
		}
	}
	
	public void giveItem(Item item) {
		for(int i = 0; i < numberOfItems; i++) {
			if(items[i] == item) {
				for(int j = i; j < numberOfItems -1; j++) {	
					items[j] = items[j+1];
				}
				numberOfItems--;
				System.out.println("You give away "+item.getName());
			}
		}
	}
	
	public Item getItem(String itemName) {
		Item it = new Item();
		for(int i = 0; i < numberOfItems; i++) {
			if(itemName.equals(items[i].getName())) {
				it = items[i];
				break;
			} else {
				//do nothing
			}
		}
		return it;
	}
	
	public boolean hasItem(String itemName) {
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
	
	//Other
	public void moveTo(Location newPosition) {
		if(this.position == newPosition) {	//no path -> remain at same position
			this.noPathExplaination();
		} else {
		this.position = newPosition;
		position.describeYourself(this);
		}
	}
	
	
	public void looseHealth(int reduction) {
		this.health = this.health - reduction;
	}
	
	//Helpers
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getGoldAmount() {
		return this.gold;
	}
	
	public void showPosition() {
		System.out.println(this.position.getName());
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public Location getPosition() {
		return this.position;
	}
	
	public void noPathExplaination() {
		System.out.println("There is no path in that direction.");
		System.out.println("You remain at "+position.getName());
//		position.listPaths(this);		//TEST
	}
}
