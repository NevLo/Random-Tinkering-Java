package Multiblocks;

import org.bukkit.material.Sign;

public abstract class Multiblock {

	private String name;

	public abstract boolean matchesStructure(Sign sign);

}
