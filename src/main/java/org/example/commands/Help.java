package org.example.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Help extends Command {

    @Override
    public String execute(String input) {
        return "\u001B[32m" + text() + "\u001B[0m";
    }

    public String text(){
        String text = "";
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\help"))){
            String line;
            while ((line = br.readLine()) != null){
                text += line;
            }
        }catch(IOException e){
            throw new IllegalArgumentException("File does not exist");
        }
        return text;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
