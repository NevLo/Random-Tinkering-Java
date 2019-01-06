package MultiblockTypes.Furnace;

import org.bukkit.block.data.type.Sign;

public class FurnaceTier2 extends FurnaceMultiblock {

	public FurnaceTier2() {
		name = "Furnace Tier 2";
		signText = new String[4];
		signText[1] = "Electro-Furnace";
		signText[2] = "Tier: 2";

	}

	@Override
	public boolean matchesStruct(Sign sign) {
		// BlockFace sign1;
		return false;
	}
}
