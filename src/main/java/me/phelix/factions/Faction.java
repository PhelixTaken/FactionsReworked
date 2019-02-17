package me.phelix.factions;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Faction {

    private String name;
    private Set<FPlayer> players = new HashSet<>();
    private UUID owner;

    public Faction(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public UUID getOwner(){
        return owner;
    }

    public void setOwner(String id){
        owner = UUID.fromString(id);
    }

    public Set<FPlayer> getPlayers(){
        return players;
    }

    public void addPlayer(FPlayer player){
        players.add(player);
    }

    public void removePlayer(FPlayer player){
        players.remove(player);
    }

    public void getAllPlayers(){

    }





}
