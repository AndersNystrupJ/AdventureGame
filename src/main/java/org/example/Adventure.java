package org.example;
public class Adventure {
    private Room currentRoom;

    public Adventure() {
        buildAdventure();
    }
    public void buildAdventure() {
        Room room1 = new Room("Room 1", "An empty room with with two doors. There's an unpleasent smell lingering in the air...");

        currentRoom = room1;

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void look() {
        System.out.println(currentRoom.getRoomDescription());
    }
}
