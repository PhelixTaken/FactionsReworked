package me.phelix.factions.utils;

import me.phelix.factions.FPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerManager {

    public Map<String, FPlayer> fPlayers = new HashMap<>();

    public FPlayer getByPlayer(Player player){
        return fPlayers.get(player.getUniqueId().toString());
    }

    public void setPlayer(Player player){
        fPlayers.put(player.getUniqueId().toString(), new FPlayer(player.getUniqueId().toString()));
    }


}
