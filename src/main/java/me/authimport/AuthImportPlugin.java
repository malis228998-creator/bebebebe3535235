package me.authimport;

import me.authimport.auth.AuthService;
import me.authimport.db.AuthMeReader;
import me.authimport.command.LoginCommand;
import me.authimport.command.RegisterCommand;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class AuthImportPlugin extends JavaPlugin {
    private AuthService authService;

    @Override
    public void onEnable() {
        try {
            File db = new File(getDataFolder(), "authme.db");
            if (!db.exists()) getLogger().warning("authme.db not found");

            AuthMeReader reader = new AuthMeReader(db);
            authService = new AuthService(reader.loadUsers());

        } catch (Exception e) { e.printStackTrace(); }

        getCommand("login").setExecutor(new LoginCommand(authService));
        getCommand("register").setExecutor(new RegisterCommand(authService));
    }
}
