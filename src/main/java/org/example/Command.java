package org.example;

public abstract class Command {

    protected String prikaz;

    public void setPrikaz(String prikaz) {
        this.prikaz = prikaz;
    }

    public abstract String execute(String vstup);

    public abstract boolean exit();
}
