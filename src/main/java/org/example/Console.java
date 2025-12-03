package org.example;

import org.example.commands.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private boolean exit = false;
    private final HashMap<String, Command> commands = new HashMap<>();
    public static String commandFile = "commandFile.txt";
    private final Scanner sc = new Scanner(System.in);
    private User user;

    private void initialization() {
        commands.put("mkdir", new MakeDir());
        commands.put("quit", new Quit());
        commands.put("help", new Help());
        commands.put("", new Nothing());
        commands.put("whoami", new WhoIAm());
    }

    private void proved() {
        String init = user.getName() + "@" + user.getPCname() + ":" + user.getPath() + "$ ";
        System.out.print(init);
        String command = sc.nextLine();
        try {
            if (command != null) {
                String[] pole = command.split(" ");
                pole[0] = pole[0].trim().toLowerCase();
                if (pole.length != 1) {
                    if (commands.containsKey(pole[0])) {
                        System.out.print(commands.get(pole[0]).execute(pole[1]) + "\n");
                        exit = commands.get(pole[0]).exit();
                    } else {
                        throw new Exception();
                    }
                }else {
                    if (commands.containsKey(pole[0])) {
                        System.out.print(commands.get(pole[0]).execute(user.getName()) + "\n");
                        exit = commands.get(pole[0]).exit();
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
        initialization();
        try {
            user = new User();
            do {
                proved();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveCommand(String command) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(commandFile, true))) {
            bw.write(command);
            bw.newLine();
        } catch (Exception e) {}
    }

    private void commandFileReset() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(commandFile, false))) {} catch (Exception e) {}
    }
}
