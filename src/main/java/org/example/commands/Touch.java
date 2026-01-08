package org.example.commands;

import org.example.User;

import java.io.File;
import java.io.IOException;

public class Touch extends Command {

    @Override
    public String execute(String input) {
        File file = new File(User.path + input);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Soubor vytvoren";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public boolean sudo() {
        return false;
    }
}
