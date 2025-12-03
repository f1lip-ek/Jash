package org.example.commands;

import org.example.User;

import java.io.File;

public class ViewDirs extends Command{


    @Override
    public String execute(String input) {
        String[] nazvy = new File(User.path).list();

        if (nazvy == null) {
            return "";
        }

        String vsechnySlozky = "";
        for (int i = 0; i < nazvy.length; i++) {
            vsechnySlozky += nazvy[i];
        }
        return vsechnySlozky;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
