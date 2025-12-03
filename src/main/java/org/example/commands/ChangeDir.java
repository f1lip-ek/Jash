package org.example.commands;

import org.example.User;

public class ChangeDir extends Command{

    @Override
    public String execute(String input) {
        String cesta = User.path;
        if (!input.equals("..")){
            User.path += input + "/";
        }else{
            String[] pole = cesta.split("/");
            User.path = "";
            for (int i = 0; i < pole.length - 1; i++) {
                User.path += pole[i] + "/";
            }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
