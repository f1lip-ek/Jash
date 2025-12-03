package org.example.commands;

public abstract class Command {

    protected String command;

    public void setCommand(String command) {
        this.command = command;
    }

    public abstract String execute(String input);

    public abstract boolean exit();
}
