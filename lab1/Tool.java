package lab1;

public class Tool extends Item {
	
	//Constructor
	public Tool(String itemName, double itemWeight, int itemPrice) {
		super(itemName, itemWeight, itemPrice);
	}
	
	public Tool() {
		super();
	}
	
	public void use(Player player) {
		System.out.println("You use the tool but nothing seems to happen.");
	}
	
	public void pickUpComment() {
		System.out.println("The tool feels a bit awkeward.");
	}
}
