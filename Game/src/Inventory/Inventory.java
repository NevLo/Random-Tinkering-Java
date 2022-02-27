package Inventory;

public class Inventory {
	private ItemStack[] inv;
	private int numItemStacks;

	public Inventory() {
		inv = new ItemStack[100];
		numItemStacks = 0;
	}

	public void addItemToInventory(ItemStack i) {
		// If there is no room for an item try to stack it with other items.

		if (numItemStacks >= this.inv.length) {

		}
	}

}
