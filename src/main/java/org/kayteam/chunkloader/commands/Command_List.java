package org.kayteam.chunkloader.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.kayteam.chunkloader.main.ChunkLoader;
import org.kayteam.chunkloader.main.ChunkManager;

import java.util.ArrayList;
import java.util.List;

public class Command_List {

    private final ChunkLoader plugin;

    public Command_List(ChunkLoader plugin) {
        this.plugin = plugin;
    }

    public void chunkList(Player player){
        ChunkManager chunkManager = plugin.getChunkManager();

        List<String> chunkList = new ArrayList<>();
        for(String key : plugin.data.getStringList("chunks-list")){
            int chunkLocationX = Integer.parseInt(chunkManager.formatChunk(key)[0]);
            int chunkLocationZ = Integer.parseInt(chunkManager.formatChunk(key)[1]);
            String chunkLocationWorld = chunkManager.formatChunk(key)[2];

            String chunkCoords = "X: "+chunkLocationX+"; Z: "+chunkLocationZ;

            chunkList.add(plugin.messages.getString("chunkloader.list", new String[][]{
                    {"%chunk_coords%", chunkCoords},
                    {"%chunk_world%", chunkLocationWorld}
                })
            );
        }
        for (int i = 0; i < chunkList.size(); i++) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7(&l"+(i)+"&7)"+chunkList.get(i)));
        }
    }
}
