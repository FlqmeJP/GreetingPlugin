package com.example.greeting;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Greeting extends JavaPlugin{
    //↓ onEnableはロードされた時に実行されるメソッド
    @Override
    public void onEnable() {
        // ↓ サーバー上にログを残す
        getLogger().info("Greeting Plugin is enabled");
    }

    // onCommand は plugin.yml に記載されたコマンドが呼ばれた時に実行
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String commandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("greet")){
            if(!(sender instanceof Player)){
                sender.sendMessage("This command must not be used by non-humans!");
                return true;
            }
            else if(args.length != 0){
                sender.sendMessage("No arguments required.");
                return true;
            }

            sender.sendMessage("Hello World");
            return true;
        }
        return false;
    }
}

