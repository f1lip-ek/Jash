package org.example.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeDir extends Command{

    @Override
    public String execute(String nazevSlozky) {
        String cesta = "PC\\filip\\" + nazevSlozky;
        Path slozkaPath = Paths.get(cesta);
        try {
            if (!Files.exists(slozkaPath)) {
                Files.createDirectory(slozkaPath);
            } else {
                throw new IllegalArgumentException("Slozka s timto jmenem uz existuje");
            }
        } catch (IOException e) {
            System.err.println("Chyba při vytváření složky: " + e.getMessage());
        }
        return "Slozka vytvorena";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
