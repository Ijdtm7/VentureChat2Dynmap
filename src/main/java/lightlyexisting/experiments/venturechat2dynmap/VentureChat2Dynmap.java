package lightlyexisting.experiments.venturechat2dynmap;

import org.bukkit.plugin.java.JavaPlugin;
import org.dynmap.DynmapAPI;
import mineverse.Aust1n46.chat.MineverseChat;

public class VentureChat2Dynmap extends JavaPlugin {
	private DynmapAPI dynmap;
	private VentureChatListener fromMC;
	private MineverseChat venturechat;

	@Override
	public void onEnable() {
		this.dynmap = (DynmapAPI) getServer().getPluginManager().getPlugin("dynmap");
		this.venturechat = (MineverseChat) getServer().getPluginManager().getPlugin("VentureChat");

		this.fromMC = new VentureChatListener(this.dynmap);
		getServer().getPluginManager().registerEvents(new VentureChatListener(this.dynmap), this);

		getLogger().info("VentureChat2Dynmap loaded successfully!");
	}

	@Override
	public void onDisable() {
		if (this.fromMC != null) {
			this.fromMC = null;
		}
	}
}
