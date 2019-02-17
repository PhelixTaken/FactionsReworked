package me.phelix.factions;

import me.phelix.factions.commands.FMainCommand;
import me.phelix.factions.utils.FactionManager;
import me.phelix.factions.utils.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.UUID;

public class Main extends JavaPlugin {

    private FactionManager factionManager;
    private PlayerManager playerManager;

    public void onEnable(){
        factionManager = new FactionManager(this);
        playerManager = new PlayerManager();


        File[] files = new File(getDataFolder() + File.separator + "Factions").listFiles();
        if(files == null) return;

        for(File file : files){
            String name = file.getName().replace(".yml", "");
            factionManager.factionMap.put(name, new Faction(name));
        }

        //Checks the config and adds all the players from the config to the HashSet
        for(Faction faction : factionManager.factionMap.values()){
            factionManager.checkConfig(faction.getName());
            for(UUID uuid : factionManager.getPlayers(faction.getName())){
                faction.getPlayers().add(new FPlayer(uuid.toString()));
            }
        }

        getCommand("f").setExecutor(new FMainCommand(this));

    }

    public FactionManager getFactionManager() {
        return factionManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
