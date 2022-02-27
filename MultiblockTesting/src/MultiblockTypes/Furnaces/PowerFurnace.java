package MultiblockTypes.Furnaces;

import org.bukkit.material.Sign;

import Multiblocks.Multiblock;

public abstract class PowerFurnace extends Multiblock {

	public static String name;

	public abstract int getTier();

	public abstract boolean matchesStructure(Sign sign);
}
