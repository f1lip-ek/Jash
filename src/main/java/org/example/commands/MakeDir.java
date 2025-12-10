package org.example.commands;

import org.example.User;

import java.io.File;

public class MakeDir extends Command{

    @Override
    public String execute(String input) {
        String cesta = User.path + input;
        if (new File(cesta).mkdir()){
            return "Directory created";
        }
        return "Cant create";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
