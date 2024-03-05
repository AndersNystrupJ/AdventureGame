package org.example;
public class Adventure {
    private Room currentRoom;

    public Adventure() { // konstruktør

        // i kan bare ændre descriptions til hvad i vil
        Room room1 = new Room("Room 1", "A dark, narrow room with a lingering smell...");
        Room room2 = new Room("Room 2", "A bloody room with guts on the floor...");
        Room room3 = new Room("Room 3", "A room filled with devil symbols filled");
        Room room4 = new Room("Room 4", "ousahdaisda");
        Room room5 = new Room("Room 5", "lalala");
        Room room6 = new Room("Room 6", "hej");
        Room room7 = new Room("Room 7", "med");
        Room room8 = new Room("Room 8", "dig");

        this.currentRoom = room1;
    }

    // vores metoder til go north, east, osv
    public void goNorth() {
    }

    public void goWest() {
    }

    public void goEast() {
    }

    public void goSouth() {
    }

}

