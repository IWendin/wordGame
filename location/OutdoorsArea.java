/**
 * 
 */
package location;

import lab1.Player;

/**
 * @author Ingrid Wendin
 *
 */
public class OutdoorsArea extends Location {
	private String firstIntroduction;
	private String shortDescription;
	private String weather = "sunny";
	private String path = "path";
	
	private String defaultFirstIntroduction = "There are many things here you haven't seen before";
	private String defaultShortDescription  = "You have enterd the magical outdoor area ";
	
	public OutdoorsArea() { //Default name in Location Constructor
		this.shortDescription = defaultShortDescription;
		this.firstIntroduction = defaultFirstIntroduction;
	}
	
	public OutdoorsArea(String name, String firstIntroduction, String shortDescription, String weather) {
		super(name);
		this.shortDescription = shortDescription;
		this.firstIntroduction = firstIntroduction;
		this.weather = weather;
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
		this.listPaths(player, path);		//test
		System.out.println("");
	}
	
	public boolean isRoom() {
		return false;
	}
	
	public String getWayType() {
		return path;
	}
	
	public void doCommand(String str,Player pl) {
		if(weather == "sunny") {
			System.out.println("It's a sunny day, the heat is making you drowzy and head hurt.");
			System.out.println("You loose 5 hp.");
			pl.looseHealth(5);
			System.out.println(pl.getHealth());
		} 
		else if(str.contentEquals("dig")) {
			if(pl.getPosition().getName().contentEquals("Knockturn Alley") && pl.getPosition().getItems("key")) {
				pl.getPosition().getItem("key").pickUpComment();
				pl.takeItem(pl.getPosition().getItem("key"));
				pl.getPosition().removeItem("key");
			}
		}
	}
}
