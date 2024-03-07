package org.example;

import java.util.ArrayList;

public class Player {
    private String playerName;
    private Room inRoom;
    private ArrayList<Item> items;

    public Player(String playerName, Room inRoom, ArrayList<Item> items){
        this.playerName = playerName;
        this.inRoom = inRoom;
        this.items = items;
    }

}
