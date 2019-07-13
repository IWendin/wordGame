/**
 * 
 */
package game;

import location.*;
import lab1.*;

/**
 * @author Ingrid Wendin
 *
 */
public class GameWorldSetUp {
	
	//Building the game world
	public Game setUp(Game game) {
		String name = "Gringotts Wizarding Bank";
		int size = 100;
		String shortDescription = "You have entered Gringotts Wizarding Bank";
		String firstIntroduction = "You have stepped into the grand entrance hall of Gringotts Wizarding Bank. The room opens up into a spacy hall where wizards are lining up to have their businesses taken care of by the goblin tellers.";
		
		Location gringotts = new Room(name, size, firstIntroduction, shortDescription);
		game.addLocation(gringotts);
		
		name = "Olivander's";
		size = 3;
		shortDescription = "You have entered Olivander's";
		firstIntroduction = "You have entered the small wandshop Olivander's. Bookshelves packed tightly and rising high towards the ceiling, but looking closer you see that there are not books, but wandboxes that are neatly stacked on the narrow shelves.";
		
		Location olivanders = new Room(name, size, firstIntroduction, shortDescription);
		game.addLocation(olivanders);
		
		name = "the Leaky Culdron";
		size = 10;
		shortDescription = "You have entered the Leaky Culdron";
		firstIntroduction = "You have entered into the buzzling wizarding pub the Leaky Culdron. There are many guests sitting around the bar talking merrily";
		
		Location theLeakyCuldron = new Room(name, size, firstIntroduction, shortDescription);
		game.addLocation(theLeakyCuldron);
	
		
		name = "Diagon Alley";
		shortDescription = "You have entered Diagon Alley";
		firstIntroduction = "You have stepped into the busy wizzarding shopping street Diagon Alley. People are happily roaming around looking at different magical shops.";
		String weather = "sunny";
		
		Location DiagonAlley = new OutdoorsArea(name, firstIntroduction, shortDescription, weather);
		game.addLocation(DiagonAlley);
		
		name = "Knockturn Alley";
		shortDescription = "You have entered Knockturn Alley";
		firstIntroduction = "You have entered Knockturn Alley and all the buzzing noice from happy shoppers in Diagon Alley fade away. Some people leer at you. You are clearly not in a friendly place.";
		weather = "misty";
		
		Location KnockturnAlley = new OutdoorsArea(name, firstIntroduction, shortDescription, weather);
		game.addLocation(KnockturnAlley);
		
		name = "Unknown Vault";	
		size = 20;
		shortDescription = "You have entered the unknown vault";
		firstIntroduction = "You have entered the unknown vault. Galleons are stacked in piles stretching from the floor to the ceiling.";
		
		Location UnknownVault = new Room(name, size, firstIntroduction, shortDescription);
		game.addLocation(UnknownVault);
		
		//Paths
		DiagonAlley.addPath(theLeakyCuldron, 0);
		DiagonAlley.addPath(gringotts, 1);
		DiagonAlley.addPath(KnockturnAlley, 2); //should be hidden
		DiagonAlley.addPath(olivanders, 3);
		
		UnknownVault.addPath(gringotts, 2);	//göra addPath på gringotts gick ej intressant nog
		
		//Items
		Shovel shovel = new Shovel("shovel", 2.1, 5);
		DiagonAlley.addItem(shovel);
		game.addItem(shovel);
		
		Item wand = new Wand("wand", 0.3, 10);
		olivanders.addItem(wand);
		game.addItem(wand);
		
		Item key = new Key("key", 0.005, 1000000);
		KnockturnAlley.addItem(key);
		game.addItem(key);
		
		//Wearables		
		Shirt basicShirt = new Shirt("basic_shirt", 1.0, 0);
		game.addItem(basicShirt);
		
		Pants basicPants = new Pants("basic_pants", 1.0, 0);
		game.addItem(basicPants);
		
		Shoes basicShoes = new Shoes("basic_shoes", 1.5, 0);
		game.addItem(basicShoes);
		
		Shirt wizardShirt = new Shirt("wizard_shirt", 1.2, 1);
		theLeakyCuldron.addItem(wizardShirt);
		game.addItem(wizardShirt);
		
		return game;
	}
	
	public void tomsIntro() {
		System.out.println("Hello there, I'm Tom, wellcome to the Leaky Culdron.");
		System.out.println("You look like a Hogwarts first year");
		System.out.println("What is your name young student?");
	}
	
	public void showDiagonAlley() {
		System.out.println("Diagon Alley, where you can shop for all of your school items, is on the other side of the brick wall over there.");
		System.out.println("Here, I'll help you open it up.");
		System.out.println("--Tom knocks on a handful carefully selected bricks-- ");
		System.out.println("--With a low rumble from the moving bricks, an opening is created in the wall--");
		System.out.println("--You hear noice of humans from the opening and walk into another unknown place--");
		System.out.println("");
	}
}
