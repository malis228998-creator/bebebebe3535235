package me.authimport.command;

import me.authimport.auth.AuthService;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class LoginCommand implements CommandExecutor {
    private final AuthService service;

    public LoginCommand(AuthService s){this.service=s;}

    public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args){
        if(!(sender instanceof Player p)) return true;
        if(args.length!=1){p.sendMessage("§c/login <pass>");return true;}
        p.sendMessage(service.login(p.getName(),args[0])?"§aOK":"§cNO");
        return true;
    }
}
