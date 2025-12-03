package org.example.commands;

public class Quit extends Command{
    @Override
    public String execute(String input) {
        return "";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
