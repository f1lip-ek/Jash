package org.example.commands;

import org.example.User;

import java.io.File;

public class ChangeDir extends Command{

    @Override
    public String execute(String input) {
        String cesta = User.path;
        if (input.equals("..")){
            String[] pole = cesta.split("/");
            User.path = "";
            for (int i = 0; i < pole.length - 1; i++) {
                User.path += pole[i] + "/";
            }
        }else{
            if (exist(input)){
                User.path += input + "/";
            }else {
                return "Directory does not exist";
            }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    public boolean exist(String input){
        boolean exist = false;
        String[] nazvy = new File(User.path).list();
        for (int i = 0; i < nazvy.length; i++) {
            if (nazvy[i].equals(input)){
                exist = true;
            }
        }
        return exist;
    }
}
