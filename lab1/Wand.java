package lab1;

public class Wand extends Tool{
	public Wand(String itemName, double itemWeight, int itemPrice) {
		super(itemName, itemWeight, itemPrice);
	}
	
	public void introduceYourself() {
		System.out.println("There is a magic wand with a slight shimmer to it on the table. It seems to be made out of rosewood");
	}
	
	public void pickUpComment() {
		System.out.println("The wand is warm in your hand and you kan feel something changing.");
		System.out.println("Is there a new path somewhere?.");
	}
}
