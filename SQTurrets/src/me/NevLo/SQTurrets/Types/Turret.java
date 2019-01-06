package me.NevLo.SQTurrets.Types;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import me.NevLo.SQTurrets.Ammo;
import me.NevLo.SQTurrets.SQTurrets;
import net.md_5.bungee.api.ChatColor;

public abstract class Turret {
	private String name;
	private String permissioncode;
	private long cooldown;
	private ArrayList<Material> bottomBlock = new ArrayList<Material>();
	private ArrayList<Material> middleBlock = new ArrayList<Material>();
	private double velocity;
	
	private ArrayList<Ammo> ammunition = new ArrayList<Ammo>();
	
	public Turret() {}
	
	public abstract void firing(final Player p);
	public abstract void firing(final Player p, Ammo ammoType);
	
	
	public void fire(Player p) {
		if(!p.hasPermission(this.permissioncode)) {
			p.sendMessage(ChatColor.RED + "You do not have permission to use this turret type!");
			return;
		}
		if(this.isOnCooldown(p)) return;
		Ammo loaded = getLoadedAmmo(p);
		if(playerHasAmmoInInventory(p)) {
			this.firing(p, loaded);
			
		}else {
			this.firing(p);
		}
		if(SQTurrets.cooldownMap.get(p) != null) {
			SQTurrets.cooldownMap.remove(p);
			SQTurrets.cooldownMap.put(p,(System.currentTimeMillis()));
		}
		
		
		
	}
	
	private Ammo getLoadedAmmo(Player p) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isOnCooldown(Player p) {
		return false;
		
		
		
	}
	
	public static void activate(Player p, Block turretSign) {
		
		
	}
	public void deactivate(Player p) {
		
	}
	public static boolean matchesStruct(Sign s, Turret t) {
		return false;
		
	}
	public boolean playerHasAmmoInInventory(Player p) {
		return false;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCooldown() {
		return cooldown;
	}

	public void setCooldown(long cooldown) {
		this.cooldown = cooldown;
	}

	public ArrayList<Material> getBottomBlock() {
		return bottomBlock;
	}

	public void setBottomBlock(ArrayList<Material> bottomBlock) {
		this.bottomBlock = bottomBlock;
	}

	public String getPermissioncode() {
		return permissioncode;
	}

	public void setPermissioncode(String permissioncode) {
		this.permissioncode = permissioncode;
	}

	public ArrayList<Material> getMiddleBlock() {
		return middleBlock;
	}

	public void setMiddleBlock(ArrayList<Material> middleBlock) {
		this.middleBlock = middleBlock;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public ArrayList<Ammo> getAmmunition() {
		return ammunition;
	}

	public void setAmmunition(ArrayList<Ammo> ammunition) {
		this.ammunition = ammunition;
	}
	
	
	
	
	
}
