package lab1;

public class Pants extends WearableItem {
	private static int position = 4;
	
	public Pants(String itemName, double itemWeight, int itemPrice) {
		super(itemName, itemWeight, itemPrice, position);
	}
}
