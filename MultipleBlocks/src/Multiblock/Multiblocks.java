package Multiblock;

import org.bukkit.block.data.type.Sign;

public abstract class Multiblocks {

	public String name;
	public String[] signText;

	public abstract boolean matchesStruct(Sign sign);

}
