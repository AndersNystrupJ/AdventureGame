package org.example;
public class Adventure {
    private Room currentRoom;

    public Adventure() {
        buildAdventure();
    }

    public void buildAdventure() {
        Room room1 = new Room("Room 1", "An empty room with with two doors. There's an unpleasent smell lingering in the air...");
        Room room2 = new Room("Room 2", "A bloody room with guts on the floor...");
        Room room3 = new Room("Room 3", "A room with weird symbols on the wall");
        Room room4 = new Room("Room 4", "A room with Fie Laursen");
        Room room5 = new Room("Room 5", "lalala");
        Room room6 = new Room("Room 6", "hej");
        Room room7 = new Room("Room 7", "med");
        Room room8 = new Room("Room 8", "dig");

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void look() {
        System.out.println(currentRoom.getRoomDescription());
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
