package lab1;
//import location.*;

public class Shovel extends Tool {

	//constructor
	public Shovel(String itemName, double itemWeight, int itemPrice) {
		super(itemName, itemWeight, itemPrice);
	}
	
	public Shovel() {
		super();
	}
	
	public void introduceYourself() {
		System.out.println("There is a shovel on the ground and nobody is around. Someone must have forgotten it.");
	}
	
	public void use(Player player) {
		if(player.getPosition().isRoom()) {
			System.out.println("It's considred bad customs to dig inside a wizarding building.");
			System.out.println("You are afraid people will hex you and put away the shovel, but you were not quick enough.");
			player.getPosition().doCommand("dig", player);
		} else {
			System.out.println("You take the shovel and start digging.");
			player.getPosition().doCommand("dig", player);
		}
	}
	
	public void pickUpComment() {
		System.out.println("The shovel is heavy and you look awkeward walking around with a muggle item.");
	}
}
