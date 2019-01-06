package MultiblockTypes.Generator;

import org.bukkit.block.data.type.Sign;

public class EnderGenerator extends GeneratorMultiblock {

	@Override
	public boolean matchesStruct(Sign sign) {
		// TODO Auto-generated method stub
		return false;
	}

	public EnderGenerator() {
		name = "Ender Generator";
	}
}
