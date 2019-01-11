package Multiblock;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	private static Logger Console = Bukkit.getLogger();
	private static ArrayList<Multiblocks> Types;

	@Override
	public void onEnable() {
		Console.log(Level.INFO, "[MBTests] Running!");
		Bukkit.getBanList(Type.NAME).addBan("MicleBrick", "Reasons", null, "Console");
		Bukkit.getBanList(Type.NAME).addBan("Arulaun", "Reasons", null, "Console");

		MultiManager.init();
		Types = MultiManager.getTypes();
		displayMachineNames();

	}

	@Override
	public void onDisable() {
		Types.clear();
		MultiManager.clear();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		String com = cmd.getName();
		if (com.equalsIgnoreCase("yelp")) {
			Console.log(Level.INFO, "Yelp!");
		}
		if (com.equalsIgnoreCase("mblist")) {
			displayMachineNames();
		}
		return false;

	}

	@EventHandler
	public static void onSignClick(final PlayerInteractEvent event) {
		Console.log(Level.INFO, "A sign has been clicked!");
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getClickedBlock().getType() == Material.WALL_SIGN) {

				Sign eventSign = (Sign) event.getClickedBlock().getState();
				// Checks to see if it is a multiblock that needs to be made
				for (Multiblocks mb : Types) {
					if (eventSign.getLine(0).equalsIgnoreCase("[" + mb.name + "]")) {
						event.getPlayer().sendMessage("You have made a new " + mb.name);
					}
				}
				// checks to see if it is a multiblock that needs to be messed with

			}

		} else if (event.getAction() == Action.LEFT_CLICK_BLOCK) {

		} else if (event.getAction() == Action.RIGHT_CLICK_AIR) {
			return;
		} else if (event.getAction() == Action.LEFT_CLICK_AIR) {
			return;
		}
	}

	public static void displayMachineNames() {
		for (Multiblocks m : Types) {
			System.out.println("[" + m.name + "]");
		}
	}
}
