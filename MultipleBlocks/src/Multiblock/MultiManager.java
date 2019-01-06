package Multiblock;

import java.util.ArrayList;

import MultiblockTypes.Furnace.FurnaceTier1;
import MultiblockTypes.Furnace.FurnaceTier2;
import MultiblockTypes.Furnace.FurnaceTier3;
import MultiblockTypes.Generator.EnderGenerator;
import MultiblockTypes.Generator.MagmaticGenerator;
import MultiblockTypes.Generator.SurvivalGenerator;
import MultiblockTypes.Generator.WaterMill;
import MultiblockTypes.Pulverizer.PulverizerTier1;
import MultiblockTypes.Pulverizer.PulverizerTier2;
import MultiblockTypes.Pulverizer.PulverizerTier3;

public class MultiManager {
	static ArrayList<Multiblocks> types;

	public static void init() {
		types = new ArrayList<Multiblocks>();

		types.add(new FurnaceTier1());
		types.add(new FurnaceTier2());
		types.add(new FurnaceTier3());

		types.add(new PulverizerTier1());
		types.add(new PulverizerTier2());
		types.add(new PulverizerTier3());

		types.add(new SurvivalGenerator());
		types.add(new MagmaticGenerator());
		types.add(new EnderGenerator());
		types.add(new WaterMill());

	}

	public static ArrayList<Multiblocks> getTypes() {
		return types;
	}

	public static void clear() {
		types.clear();

	}

}
