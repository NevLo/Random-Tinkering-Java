package Multiblocks;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class MultiblockUtils {

	public static boolean isGlass(Block block) {
		return block.getType().equals(Material.GLASS) || block.getType().equals(Material.WHITE_STAINED_GLASS)
				|| block.getType().equals(Material.ORANGE_STAINED_GLASS)
				|| block.getType().equals(Material.MAGENTA_STAINED_GLASS)
				|| block.getType().equals(Material.LIGHT_BLUE_STAINED_GLASS)
				|| block.getType().equals(Material.YELLOW_STAINED_GLASS)
				|| block.getType().equals(Material.LIME_STAINED_GLASS)
				|| block.getType().equals(Material.PINK_STAINED_GLASS)
				|| block.getType().equals(Material.GRAY_STAINED_GLASS)
				|| block.getType().equals(Material.LIGHT_GRAY_STAINED_GLASS)
				|| block.getType().equals(Material.CYAN_STAINED_GLASS)
				|| block.getType().equals(Material.PURPLE_STAINED_GLASS)
				|| block.getType().equals(Material.BLUE_STAINED_GLASS)
				|| block.getType().equals(Material.BROWN_STAINED_GLASS)
				|| block.getType().equals(Material.GREEN_STAINED_GLASS)
				|| block.getType().equals(Material.RED_STAINED_GLASS)
				|| block.getType().equals(Material.BLACK_STAINED_GLASS);
	}

	public static boolean isGlassPane(Block block) {
		return block.getType().equals(Material.GLASS_PANE) || block.getType().equals(Material.WHITE_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.ORANGE_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.MAGENTA_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.LIGHT_BLUE_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.YELLOW_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.LIME_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.PINK_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.GRAY_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.LIGHT_GRAY_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.CYAN_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.PURPLE_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.BLUE_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.BROWN_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.GREEN_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.RED_STAINED_GLASS_PANE)
				|| block.getType().equals(Material.BLACK_STAINED_GLASS_PANE);
	}

	public static boolean isWool(Block block) {
		return block.getType().equals(Material.WHITE_WOOL) || block.getType().equals(Material.ORANGE_WOOL)
				|| block.getType().equals(Material.MAGENTA_WOOL) || block.getType().equals(Material.LIGHT_BLUE_WOOL)
				|| block.getType().equals(Material.YELLOW_WOOL) || block.getType().equals(Material.LIME_WOOL)
				|| block.getType().equals(Material.PINK_WOOL) || block.getType().equals(Material.GRAY_WOOL)
				|| block.getType().equals(Material.LIGHT_GRAY_WOOL) || block.getType().equals(Material.CYAN_WOOL)
				|| block.getType().equals(Material.PURPLE_WOOL) || block.getType().equals(Material.BLUE_WOOL)
				|| block.getType().equals(Material.BROWN_WOOL) || block.getType().equals(Material.GREEN_WOOL)
				|| block.getType().equals(Material.RED_WOOL) || block.getType().equals(Material.BLACK_WOOL);
	}

	public static boolean isRedstone(Block block) {
		return block.getType().equals(Material.REDSTONE_BLOCK);
	}

	public static boolean isIron(Block block) {
		return block.getType().equals(Material.IRON_BLOCK);
	}

	public static boolean isGold(Block block) {
		return block.getType().equals(Material.GOLD_BLOCK);
	}

	public static boolean isDiamond(Block block) {
		return block.getType().equals(Material.DIAMOND_BLOCK);
	}

	public static boolean isEmerald(Block block) {
		return block.getType().equals(Material.EMERALD_BLOCK);
	}

	public static boolean isLapis(Block block) {
		return block.getType().equals(Material.LAPIS_BLOCK);
	}

	public static boolean isLamp(Block block) {
		return block.getType().equals(Material.REDSTONE_LAMP);
	}

}
