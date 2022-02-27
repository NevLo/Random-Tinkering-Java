package Inventory;

public class ItemStack {
	public Item item;
	public int maxStackSize;
	public int stackSize;

	public ItemStack(Item i) {
		item = i;
		maxStackSize = item.maxStackSize;
		stackSize = 1;
	}

	public ItemStack(Item i, int num) {
		item = i;
		maxStackSize = item.maxStackSize;
		stackSize = num;
	}
}
