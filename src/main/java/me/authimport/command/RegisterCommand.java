package me.authimport.command;

import me.authimport.auth.AuthService;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class RegisterCommand implements CommandExecutor {
    private final AuthService service;

    public RegisterCommand(AuthService s){this.service=s;}

    public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args){
        if(!(sender instanceof Player p)) return true;
        if(args.length!=1){p.sendMessage("§c/register <pass>");return true;}
        p.sendMessage(service.register(p.getName(),args[0])?"§aOK":"§cEXISTS");
        return true;
    }
}
