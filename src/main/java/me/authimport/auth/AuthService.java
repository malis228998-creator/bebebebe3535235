package me.authimport.auth;

import org.mindrot.jbcrypt.BCrypt;
import java.util.*;

public class AuthService {
    private final Map<String,String> users = new HashMap<>();

    public AuthService(Map<String,String> imported){
        users.putAll(imported);
    }

    public boolean login(String p, String pass){
        String h = users.get(p.toLowerCase());
        return h != null && BCrypt.checkpw(pass,h);
    }

    public boolean register(String p,String pass){
        if(users.containsKey(p.toLowerCase())) return false;
        users.put(p.toLowerCase(), BCrypt.hashpw(pass, BCrypt.gensalt()));
        return true;
    }
}
