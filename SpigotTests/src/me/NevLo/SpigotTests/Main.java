package me.NevLo.SpigotTests;

import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
//import org.bukkit.block.data.type.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.NevLo.SpigotTests.types.Turret;

public class Main extends JavaPlugin implements Listener{
	public static ArrayList<Turret> tyrretTypes = new ArrayList<Turret>();
	
	
	
	
	
	@Override
	public void onEnable() {
		Bukkit.getLogger().log(Level.INFO, "[Spigot Tests] Enabled!");
	}
	@Override
	public void onDisable() {
		Bukkit.getLogger().log(Level.INFO, "[Spigot Tests] Disabled!");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("reloadturrets")) {
			
		}
		return false;	
	}
	@EventHandler
	public static void onSignClick(final PlayerInteractEvent e) {
		if(e.getClickedBlock().getType() == Material.WALL_SIGN && e.getAction() == Action.RIGHT_CLICK_BLOCK) {}
		Sign sign = (Sign)e.getClickedBlock();
		if(!matchesStruct(sign)) {
			return;
		}
		
	}
	private static boolean matchesStruct(Sign s) {
		BlockFace d = s.getBlock().getFace(s.getBlock()).getOppositeFace();
		Block dispenser = s.getBlock().getRelative(d);
		Block lamp = dispenser.getRelative(BlockFace.UP);
		Block glass = lamp.getRelative(BlockFace.UP);
		if(!(dispenser.getBlockData().getMaterial() == Material.DISPENSER)) return false;
		if(!(lamp.getBlockData().getMaterial() == Material.REDSTONE_LAMP)) return false;
		if(!(glass.getBlockData().getMaterial() == Material.GLASS)) return false;
		return true;
	}
}
