package org.example.commands;

public class Nothing extends Command{

    @Override
    public String execute(String input) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
