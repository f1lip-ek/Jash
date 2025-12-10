package org.example.commands;

import org.example.User;

import java.io.File;

public class ViewDirs extends Command{


    @Override
    public String execute(String input) {
        File[] file = new File(User.path).listFiles();

        if (file == null) {
            return "";
        }

        StringBuilder allThings = new StringBuilder();
        for (File f : file) {
            if (f.isDirectory()) {
                allThings.append(/*RED*/"\u001B[31m").append(f.getName()).append("\u001B[0m ");
            }else {
                allThings.append(/*GREEN*/"\u001B[32m").append(f.getName()).append("\u001B[0m ");
            }
        }
        return allThings.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
