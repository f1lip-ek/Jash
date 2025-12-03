package org.example;

public class Nothing extends Command{

    @Override
    public String execute(String vstup) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
