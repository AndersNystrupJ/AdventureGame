package org.example;

import java.util.ArrayList;

public class Adventure {
    private MapConstruction map = new MapConstruction();

    public void look() {
        Room currentRoom = map.getCurrentRoom();
        if (currentRoom != null) {
            System.out.println(currentRoom.getRoomDescription());
            System.out.println("You look around and notice:");
            ArrayList<Item> items = currentRoom.getItems();
            if (items != null) {
                for (Item item : items) {
                    System.out.println("- " + item.getLongName());
                }
            } else {
                System.out.println("There are no items in this room.");
            }
        } else {
            System.out.println("You are not in any room.");
        }
    }

    public MapConstruction getMap() {
        return map;
    }
}