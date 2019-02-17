package me.phelix.factions.events;

import me.phelix.factions.FPlayer;
import me.phelix.factions.Main;
import me.phelix.factions.utils.Role;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinQuit implements Listener {

    private Main plugin;
    public JoinQuit(Main plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        FPlayer player = plugin.getPlayerManager().getByPlayer(event.getPlayer());
        if(!player.hasFaction()){
            player.setRole(Role.NONE);
            plugin.getPlayerManager().fPlayers.put(event.getPlayer().getUniqueId().toString(), new FPlayer(event.getPlayer().getUniqueId().toString()));
        } else {

        }
    }

}
