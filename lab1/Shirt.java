package lab1;

public class Shirt extends WearableItem {
	private static int position = 3;
	
	public Shirt(String itemName, double itemWeight, int itemPrice) {
		super(itemName, itemWeight, itemPrice, position);
	}
}
