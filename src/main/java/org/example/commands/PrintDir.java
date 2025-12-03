package org.example.commands;

public class PrintDir extends Command{

    @Override
    public String execute(String input) {
        return input;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
