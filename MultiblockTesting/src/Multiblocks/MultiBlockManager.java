package Multiblocks;

import java.util.ArrayList;

import MultiblockTypes.Furnaces.Tier1Furnace;

public class MultiBlockManager {

	ArrayList<Multiblock> multiblocks;

	public MultiBlockManager() {
		multiblocks = new ArrayList<Multiblock>();

		multiblocks.add(new Tier1Furnace());

	}

}
