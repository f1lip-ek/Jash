package org.example.commands;

import org.example.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Concatenate extends Command{


    @Override
    public String execute(String input) {
        String text = "";
        try(BufferedReader br = new BufferedReader(new FileReader(User.path + input))){
            String line;
            while ((line = br.readLine()) != null){
                text += line;
            }
        }catch (IOException e){
            throw new IllegalArgumentException("Soubor neexistuje");
        }

        return text;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
