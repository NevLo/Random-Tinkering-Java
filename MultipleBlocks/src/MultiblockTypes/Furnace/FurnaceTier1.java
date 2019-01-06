package MultiblockTypes.Furnace;

import org.bukkit.block.data.type.Sign;

public class FurnaceTier1 extends FurnaceMultiblock {

	public FurnaceTier1() {
		name = "Furnace Tier 1";
		signText = new String[4];
		signText[1] = "Electro-Furnace";
		signText[2] = "Tier: 1";

	}

	@Override
	public boolean matchesStruct(Sign sign) {
		// BlockFace sign1;
		return false;
	}
}
