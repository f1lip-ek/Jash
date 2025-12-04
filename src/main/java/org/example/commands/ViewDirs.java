package org.example.commands;

import org.example.User;

import java.io.File;

public class ViewDirs extends Command{


    @Override
    public String execute(String input) {
        String[] list = new File(User.path).list();

        if (list == null) {
            return "";
        }

        String vsechnySlozky = "";
        for (int i = 0; i < list.length; i++) {
            vsechnySlozky += list[i] + " ";
        }
        return vsechnySlozky;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
