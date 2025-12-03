package org.example.commands;

public class Quit extends Command{
    @Override
    public String execute(String vstup) {
        return "Program ukoncen";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
