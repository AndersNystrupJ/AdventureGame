package org.example;
import java.util.ArrayList;

public class Player {
    private String playerName;
    private Room inRoom;
    private ArrayList<Item> inventory;

    public Player(String playerName, Room inRoom, ArrayList<Item> inventory){
        this.playerName = playerName;
        this.inRoom = inRoom;
        this.inventory = inventory;
    }

    /*
    public void takeItem(String itemToTake) {
        for (Item item : adventure.getMap().getCurrentRoom().getItems()) {
            if (item.getShortName().equalsIgnoreCase(itemToTake)) {
                inventory.add(item);
                System.out.println("You took " + item.getLongName());

                adventure.getMap().getCurrentRoom().removeItem(item);
                return;
            }
        }
        System.out.println("There is no such item in this room.");
    }

     */
}
