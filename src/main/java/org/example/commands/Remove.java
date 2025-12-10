package org.example.commands;

import org.example.User;

import java.io.File;

public class Remove extends Command{

    @Override
    public String execute(String input) {
        if (new File(User.path + input).delete()) {
            return "Odstraneno";
        }else {
            return "File does not exist";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
