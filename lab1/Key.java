package lab1;

public class Key extends Tool {
	
	public Key(String itemName, double itemWeight, int itemPrice) {
		super(itemName, itemWeight, itemPrice);
	}
	
	public void introduceYourself() {
		System.out.println("The dirt is pressed flat, but there is an uneven spot by the corner to your left.");
		System.out.println("Could there be something there?.");
	}
	
	public void pickUpComment() {
		System.out.println("The dirt is hard to get through, but you quickly see something glimmering by the shovel");
		System.out.println("You take cover while a hooded man quickly pass by and then stretch out your hand to pick upp the object");
		System.out.println("You have found a small, golden key. It looks like one from Gringotts");
		System.out.println("Is the owner around?.");
		System.out.println("You don't dare speaking to anyone in the alley.");
	}
}
