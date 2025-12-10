package org.example.commands;

import org.example.User;

import java.io.File;

public class ViewDirs extends Command{


    @Override
    public String execute(String input) {
        File[] file = new File(User.path).listFiles();
        String[] list = new File(User.path).list();


        if (file == null) {
            return "";
        }

        String vsechnySlozky = "";
        for (int i = 0; i < file.length; i++) {
            if (file[i].isDirectory()) {
                vsechnySlozky += "\u001B[31m" + file[i].getName() + "\u001B[0m ";
            }else {
                vsechnySlozky += "\u001B[32m" + file[i].getName() + "\u001B[0m ";
            }
        }
        return vsechnySlozky;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
