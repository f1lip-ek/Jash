package org.example;

import org.example.commands.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Konzole {

    private boolean exit = false;
    private HashMap<String, Command> mapa = new HashMap<>();
    public static String souborPrikazu = "souborPrikazu.txt";
    private Scanner sc = new Scanner(System.in);
    private User user;

    private void inicializace() {
        mapa.put("mkdir", new MakeDir());
        mapa.put("quit", new Quit());
        mapa.put("help", new Help());
        mapa.put("", new Nothing());
        mapa.put("whoami", new WhoIAm());
    }

    private void proved() {
        String init = user.getName() + "@" + user.getPCname() + ":" + user.getPath() + "$ ";
        System.out.print(init);
        String prikaz = sc.nextLine();
        try {
            if (prikaz != null) {
                String[] pole = prikaz.split(" ");
                pole[0] = pole[0].trim().toLowerCase();
                if (pole.length != 1) {
                    if (mapa.containsKey(pole[0])) {
                        System.out.print(mapa.get(pole[0]).execute(pole[1]) + "\n");
                        exit = mapa.get(pole[0]).exit();
                    } else {
                        throw new Exception();
                    }
                }else {
                    if (mapa.containsKey(pole[0])) {
                        System.out.print(mapa.get(pole[0]).execute(user.getName()) + "\n");
                        exit = mapa.get(pole[0]).exit();
                    } else {
                        throw new Exception();
                    }
                }
            }else {
                proved();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        inicializace();
        try {
            user = new User();
            do {
                proved();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void ulozPrikaz(String prikaz) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, true))) {
            bw.write(prikaz);
            bw.newLine();
        } catch (Exception e) {

        }
    }

    private void resetSouboruProPrikazy() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(souborPrikazu, false))) {
        } catch (Exception e) {
        }
    }
}
