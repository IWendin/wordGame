package lab1;
//import location.Location;

public class Item {
	private String name;
	private double weight;
	private int price;
	
	//Constructor
	public Item() {
		//empty
	}
	
	public Item(String itemName, double itemWeight, int itemPrice) {
		name = itemName;
		weight = itemWeight;
		price = itemPrice;
	}
	
	public void use(Player pl) {
		//Empty
	}
	
	public void printYourself() {
		System.out.println(name+" ("+weight+") kg");
	}
	
	public void introduceYourself() {	//Control method, can be removed
		System.out.println("There is something on the ground.");
	}
	
	public void pickUpComment() {
		System.out.println("The item feels a bit awekward.");
	}
	
	public String getName() {
		return this.name;
	}
}
