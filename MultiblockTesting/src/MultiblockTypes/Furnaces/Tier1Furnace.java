package MultiblockTypes.Furnaces;

import org.bukkit.material.Sign;

public class Tier1Furnace extends PowerFurnace {

	public static String name;

	public int getTier() {
		return 1;
	}

	public boolean matchesStructure(Sign sign) {
		return false;
	}
}
