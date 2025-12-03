package org.example.commands;

public class WhoIAm extends Command{

    @Override
    public String execute(String vstup) {
        return vstup;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
