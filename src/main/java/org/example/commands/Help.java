package org.example.commands;

public class Help extends Command {

    @Override
    public String execute(String vstup) {
        return "\u001B[32mhelp, mkdir, quit, whoami\u001B[0m";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
