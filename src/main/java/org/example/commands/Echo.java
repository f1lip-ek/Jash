package org.example.commands;

public class Echo extends Command{


    @Override
    public String execute(String input) {
        input = input.replace("\"", "");
        return input;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
