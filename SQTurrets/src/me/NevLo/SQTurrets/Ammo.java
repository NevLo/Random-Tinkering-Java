package me.NevLo.SQTurrets;


import org.bukkit.inventory.ItemStack;
public class Ammo {
	private String name;
	private ItemStack item;
	private boolean fire;
	private double vel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ItemStack getItem() {
		return item;
	}
	public void setItem(ItemStack item) {
		this.item = item;
	}
	public boolean isFire() {
		return fire;
	}
	public void setFire(boolean fire) {
		this.fire = fire;
	}
	public double getVel() {
		return vel;
	}
	public void setVel(double vel) {
		this.vel = vel;
	}
	
	
	
	
	
	
	
	
}
