package lab1;

public class Shoes extends WearableItem{
	private static int position = 5;
	
	public Shoes(String itemName, double itemWeight, int itemPrice) {
		super(itemName, itemWeight, itemPrice, position);
	}
}
