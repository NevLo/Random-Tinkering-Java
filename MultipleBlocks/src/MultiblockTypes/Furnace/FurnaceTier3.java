package MultiblockTypes.Furnace;

import org.bukkit.block.data.type.Sign;

public class FurnaceTier3 extends FurnaceMultiblock {

	public FurnaceTier3() {
		name = "Furnace Tier 3";
		signText = new String[4];
		signText[1] = "Electro-Furnace";
		signText[2] = "Tier: 3";

	}

	@Override
	public boolean matchesStruct(Sign sign) {
		// BlockFace sign1;
		return false;
	}
}
