package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class User {

    private String name;
    private String path;
    private String PCname;
    


    public User() {
        InetAddress adresa = null;
        try {
            adresa = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        this.name = "filip";
        this.path = "~";
        this.PCname = adresa.getHostName();
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getPCname() {
        return PCname;
    }
}
