package me.NevLo.SQTurrets;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import me.NevLo.SQTurrets.Types.APTurret;
import me.NevLo.SQTurrets.Types.NormalTurret;
import me.NevLo.SQTurrets.Types.Turret;

public class SQTurrets extends JavaPlugin implements Listener {

	public static HashMap<Player, Long> cooldownMap = new HashMap<Player, Long>();
	public static ArrayList<Turret> turretTypes = new ArrayList<Turret>();
	public static List<Ammo> ammoTypes = new ArrayList<Ammo>();
	public static SQTurrets instance;
	public static ArrayList<Projectile> proj = new ArrayList<Projectile>();
	public static FileConfiguration config;

	public SQTurrets() {
	}

	@Override
	public void onEnable() {
		Bukkit.getLogger().log(Level.INFO, "[SQTurrets] Enabled!");
		instance = this;
		instance.saveDefaultConfig();
		config = instance.getConfig();
		loadAmmos();
		loadTurrets();

		getServer().getPluginManager().registerEvents(this, this);

	}

	private static void loadAmmos() {

		for (String name : config.getConfigurationSection("ammos").getKeys(false)) {
			Ammo a = new Ammo();
			a.setName(name);
			a.setItem(new ItemStack(Material.matchMaterial(config.getString("ammos." + name + ".id")),
					config.getInt("ammos." + name + ".quantity")));
			a.setFire(config.getBoolean("ammos." + name + ".fire"));
			a.setVel(config.getDouble("ammos." + name + ".velocity"));

			ammoTypes.add(a);
		}
	}

	private static void loadTurrets() {
		turretTypes.add(new APTurret());

		// turretTypes.add(new BeamTurret());
		turretTypes.add(new NormalTurret());
		Iterator<Turret> it = turretTypes.iterator();
		while (it.hasNext()) {
			Turret turret = it.next();
			turret.setPermissioncode(config.getString("turrets." + turret.getName() + ".permission"));
			turret.setCooldown(config.getLong("turrets." + turret.getName() + ".cooldown"));
			List<String> base = config.getStringList("turrets." + turret.getName() + ".basematerials");
			ArrayList<Material> baseMaterials = new ArrayList<Material>();
			for (String material : base) {
				baseMaterials.add(Material.matchMaterial(material));
			}
			turret.setBottomBlock(baseMaterials);
			List<String> top = config.getStringList("turrets." + turret.getName() + ".topmaterials");
			ArrayList<Material> topMaterials = new ArrayList<Material>();
			for (String material : top) {
				topMaterials.add(Material.matchMaterial(material));
			}
			turret.setMiddleBlock(topMaterials);
			ArrayList<Ammo> turretAmmo = new ArrayList<Ammo>();
			List<String> turretAmmoStrings = config.getStringList("turrets." + turret.getName() + ".ammo");
			for (Ammo a : ammoTypes) {
				for (String s : turretAmmoStrings) {
					if (a.getName().equalsIgnoreCase(s)) {
						turretAmmo.add(a);
					}
				}
			}
			turret.setAmmunition(turretAmmo);
			turret.setVelocity(config.getDouble("turrets." + turret.getName() + ".velocity"));
		}
	}

	@Override
	public void onDisable() {
		Bukkit.getLogger().log(Level.INFO, "[SQTurrets] Disabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("reloadturrets")) {
			config = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "config.yml"));
			turretTypes.clear();
			ammoTypes.clear();
			loadAmmos();
			loadTurrets();

			sender.sendMessage(ChatColor.GREEN + "Turrets have been reloaded successfully!");

			Bukkit.broadcastMessage(ChatColor.GREEN + "All turrets have been reloaded");
			return true;
		}
		return false;
	}

	@EventHandler
	public static void onSignClick(final PlayerInteractEvent event) {

		if ((event.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& (event.getClickedBlock().getType() == Material.WALL_SIGN)) {
			Sign s = (Sign) event.getClickedBlock().getState();

			// Begin checking if the turret is a registered type and is an
			// uncreated turret
			for (Turret t : turretTypes) {
				if (s.getLine(0).equalsIgnoreCase("[" + t.getName() + "]")) {
					s.setLine(0, ChatColor.BLUE + t.getName().toUpperCase());
					s.setLine(1, ChatColor.GREEN + "UNOCCUPIED");
					s.update(true);
					return;
				}
			}

			// Checking an existing turret construction so the player can enter
			// a turret
			for (Turret t : turretTypes) {
				if ((s.getLine(0).equalsIgnoreCase(ChatColor.BLUE + t.getName().toUpperCase()))
						&& (s.getLine(1).equals(ChatColor.GREEN + "UNOCCUPIED"))) {
					// if the construction is a turret
					if (Turret.matchesStruct(s, t)) {
						if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.CLOCK) {
							if (!DirectionUtils.playerOffsetLocation(event.getPlayer(), s)) {
								event.getPlayer().sendMessage(
										ChatColor.RED + "You must be standing next to the turret sign to use it!");
								return;
							}

							s.setLine(1, ChatColor.RED + "OCCUPIED");
							s.setLine(2, event.getPlayer().getName());
							int pX = (int) Math.floor(event.getPlayer().getLocation().getY());
							int sX = (int) Math.floor(s.getLocation().getY());
							s.setLine(3, Integer.toString(sX - pX));
							s.update(true);
							Turret.activate(event.getPlayer(), event.getClickedBlock());
							continue;
						}
						event.getPlayer().sendMessage("You must be holding a ship controller to enter the turret.");
						continue;
					}
					event.getPlayer().sendMessage("Improperly built turret");
					continue;
				}
			}
			return;

		}

		if ((event.getAction() == Action.LEFT_CLICK_BLOCK)
				&& (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.CLOCK)
				&& (isInTurret(event.getPlayer()))) {

			Turret t = detectTurretType((Player) event.getPlayer());
			if (t == null) {
				return;
			} else {
				t.fire(event.getPlayer());
			}
			return;
		}

		if ((event.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.CLOCK)
				&& (isInTurret(event.getPlayer()))) {

			Turret t = detectTurretType((Player) event.getPlayer());
			if (t == null) {

			} else {
				t.deactivate(event.getPlayer());
			}

			return;
		}

	}

	private static Turret detectTurretType(Player player) {
		return null;
	}

	private static boolean isInTurret(Player player) {
		return false;
	}
}
