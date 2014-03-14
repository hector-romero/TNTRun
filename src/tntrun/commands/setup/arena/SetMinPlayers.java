package tntrun.commands.setup.arena;

import org.bukkit.entity.Player;

import tntrun.TNTRun;
import tntrun.arena.Arena;
import tntrun.commands.setup.CommandHandlerInterface;

public class SetMinPlayers implements CommandHandlerInterface {
	
	private TNTRun plugin;
	public SetMinPlayers(TNTRun plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean handleCommand(Player player, String[] args) {
		Arena arena = plugin.amanager.getArenaByName(args[0]);
		if (arena != null) {
			if (arena.getStatusManager().isArenaEnabled()) {
				player.sendMessage("Disable arena first");
				return true;
			}
			arena.getStructureManager().setMinPlayers(Integer.valueOf(args[1]));
			player.sendMessage("Min Players set");
		} else {
			player.sendMessage("Arena does not exist");
		}
		return true;
	}

}