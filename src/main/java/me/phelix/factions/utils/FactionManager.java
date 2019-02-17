package me.phelix.factions.utils;

import me.phelix.factions.Faction;
import me.phelix.factions.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class FactionManager {

    public Map<String, Faction> factionMap = new HashMap<>();
    public Map<UUID, Faction> factionPlayers = new HashMap<>();
    private FileConfiguration configuration;


    private Main plugin;
    public FactionManager(Main plugin){
        this.plugin = plugin;
    }

    public Faction getFactionByName(String name){
        return factionMap.get(name);
    }

    public FileConfiguration getConfig(){
        return configuration;
    }

    public void checkConfig(String name){
        File[] factions = new File(plugin.getDataFolder() + "/Factions").listFiles();
        if (factions == null) {
            return;
        }
        for (File file : factions) {
            if(file.getName().replace(".yml", "").equalsIgnoreCase(name)){
                this.configuration = YamlConfiguration.loadConfiguration(file);
            }
        }
    }

    public Set<UUID> getPlayers(String name){
        Set<UUID> allPlayers = new HashSet<>();
        List<UUID> coleader = getConfig().getStringList("CO-Leader").stream().map
                (UUID::fromString).collect(Collectors.toList());
        List<UUID> moderators = getConfig().getStringList("Moderators").stream().map
                (UUID::fromString).collect(Collectors.toList());
        List<UUID> members = getConfig().getStringList("Members").stream().map
                (UUID::fromString).collect(Collectors.toList());
        List<UUID> recruit = getConfig().getStringList("Recruit").stream().map
                (UUID::fromString).collect(Collectors.toList());
        UUID leader = UUID.fromString(getConfig().getString("Leader"));
        allPlayers.addAll(coleader);
        allPlayers.addAll(moderators);
        allPlayers.addAll(members);
        allPlayers.addAll(recruit);
        allPlayers.add(leader);
        return allPlayers;
    }



}
