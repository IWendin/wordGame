package lab1;

public class WearableItem extends Item {
	
	private int position;
	
	public WearableItem(String itemName, double itemWeight, int itemPrice, int position) {
		super(itemName, itemWeight, itemPrice);
		this.position = position;
	}
	
	public WearableItem() {
		super();
	}
	
	public void putOn(Player player) {
		player.putOnClothes(this);
	}
	
	public int getPosition() {
		return this.position;
	}
}
