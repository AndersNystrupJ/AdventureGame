package org.example;
import java.util.ArrayList;

public class Player {
    private String playerName;
    private Room inRoom;
    private ArrayList<Item> inventory;

    public Player(String playerName, Room inRoom, ArrayList<Item> inventory) {
        this.playerName = playerName;
        this.inRoom = inRoom;
        this.inventory = inventory;
    }

    public Room getInRoom() {
        return inRoom;
    }

    public void setInRoom(Room inRoom) {
        this.inRoom = inRoom;
    }

    public void takeItem(Room room, String itemToTake) {
        boolean found = false;
        for (Item item : new ArrayList<>(room.getItems())) {
            if (item.getShortName().equalsIgnoreCase(itemToTake)) {
                inventory.add(item);
                System.out.println("I've picked up " + item.getLongName());
                room.removeItem(item);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("There is no such item in this room.");
        }
    }

    public void dropItem(Room room, String itemName) {
        for (Item item : inventory) {
            if (item.getShortName().equals(itemName)) {
                room.addItem(item);
                inventory.remove(item);
                System.out.println("I dropped " + item.getLongName());
            }
        }
    }

    public void viewInventory() {
        if (!inventory.isEmpty()) {
            System.out.println("I check my bag and I see:");
            for (Item item : inventory) {
                System.out.println("- " + item.getLongName());
            }
        } else {
            System.out.println("I don't have anything in my bag.");
        }
    }
}