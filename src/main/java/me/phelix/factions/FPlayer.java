package me.phelix.factions;

import me.phelix.factions.utils.FactionManager;
import me.phelix.factions.utils.Role;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FPlayer {

    private String uuid;
    private Faction faction;
    private Map<FPlayer, Role> roleMap = new HashMap<>();

    public FPlayer(String uuid){
        this.uuid = uuid;
    }

    public Player getPlayer(){
        return Bukkit.getPlayer(UUID.fromString(uuid));
    }

    public Role getRole(){
        return roleMap.get(this);
    }

    public void setRole(Role role){
        roleMap.put(this, role);
    }

    public void setFaction(Faction faction){
        Faction oldFaction = this.getFaction();
        if(oldFaction != null){
            oldFaction.removePlayer(this);
        }
        faction.addPlayer(this);
        this.faction = faction;
    }

    public Faction getFaction(){
        return faction;
    }

    public boolean hasFaction(){
        return faction != null;
    }

    public String getFactionName(){
        return faction.getName();
    }

    public void sendMessage(String s){
        getPlayer().sendMessage(s);
    }

}
