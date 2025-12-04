package org.example.commands;

import org.example.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeDir extends Command{

    @Override
    public String execute(String input) {
        String cesta = User.path + input;
        Path slozkaPath = Paths.get(cesta);
        try {
            if (!Files.exists(slozkaPath)) {
                Files.createDirectory(slozkaPath);
            } else {
                throw new IllegalArgumentException("Directory with this name already exists");
            }
        } catch (IOException e) {
            System.err.println("Error creating folder: " + e.getMessage());
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
