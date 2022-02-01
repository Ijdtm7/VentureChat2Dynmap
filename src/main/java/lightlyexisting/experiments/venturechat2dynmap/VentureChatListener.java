package lightlyexisting.experiments.venturechat2dynmap;

import org.dynmap.DynmapAPI;
import mineverse.Aust1n46.chat.MineverseChat;
import mineverse.Aust1n46.chat.api.MineverseChatPlayer;
import mineverse.Aust1n46.chat.api.events.VentureChatEvent;
import mineverse.Aust1n46.chat.channel.ChatChannel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class VentureChatListener implements Listener {
	private DynmapAPI dynmap;
	public VentureChatListener(DynmapAPI dynmap) {
		this.dynmap = dynmap;
	}

	@EventHandler
	public void onVentureChat(VentureChatEvent event) {
		ChatChannel chatChannel = event.getChannel();
		if (chatChannel == null) return;

		String message = event.getChat();
		MineverseChatPlayer chatPlayer = event.getMineverseChatPlayer();
		//System.out.println("Received VentureChat event for player " + event.getMineverseChatPlayer() + "!");
		String name = event.getNickname();
		dynmap.postPlayerMessageToWeb(name, null, message);
	}
}
