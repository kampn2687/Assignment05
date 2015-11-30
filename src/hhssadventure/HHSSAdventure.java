/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhssadventure;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NathanKampzEtAndrewSSS
 */
public class HHSSAdventure {

    private ArrayList<Location> locations = new ArrayList<>();
    private String location;
    private int dir;
    private Location currentLocation;
    private Scene currentScene;
    private Interface GUI;

    public HHSSAdventure() {
        FileReader file = null;
        try {
            file = new FileReader("images/pics.txt");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        Scanner in = new Scanner(file);
        location = in.nextLine();
        String temp = in.nextLine();
        if (temp.equals("N")) {
            dir = 0;
        } else if (temp.equals("E")) {
            dir = 1;
        } else if (temp.equals("S")) {
            dir = 2;
        } else {
            dir = 3;
        }
        while (in.hasNext()) {
            Location l = new Location(in);
            if (location.equals(l.getLocation())) {
                currentLocation = l;
                currentScene = currentLocation.getCurrentScene(dir);
            }
            locations.add(l);
        }
        GUI = new Interface(this);
        GUI.setVisible(true);

    }

    public void forward() {
        location = currentScene.getNextLocation();
        dir = currentScene.getNextDir();
        switchLocation();
    }
    
    public void right() {
        if (dir < 3) {
            dir++;
        } else {
            dir = 0;
        }
        currentScene = currentLocation.getCurrentScene(dir);
    }

    public void switchLocation() {
        for (int i = 0; i < locations.size(); i++) {
            if (location.equals(locations.get(i).getLocation())) {
                currentLocation = locations.get(i);
                for (int j = 0; j < 4; j++) {
                }
                break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HHSSAdventure adv = new HHSSAdventure();
    }
}
