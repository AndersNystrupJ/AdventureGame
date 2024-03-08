package org.example;
import java.util.ArrayList;

public class MapConstruction {

    private Room currentRoom;

    public MapConstruction(){
        buildMap();
    }

    public void buildMap() {
        ArrayList<Item> room1items = new ArrayList<>();
        room1items.add(new Item("Shiny brass lamp","lamp"));
        room1items.add(new Item("Big sword with engraved details", "sword"));
        room1items.add(new Item("Bloody book with weird symbols on it", "book"));

        Room room1 = new Room("Room 1", "An empty room with two doors. There's an unpleasent smell lingering in the air...",room1items);
        Room room2 = new Room("Room 2", "A room with bloody walls and guts scattered on the floor.", null);
        Room room3 = new Room("Room 3", "A room with filled with candles and with some kind of shrine in the middle. There's weird symbols covering all the walls.. It looks like some kind of ceremony have taken place recently.",null);
        Room room4 = new Room("Room 4", "A room that feels ice cold",null);
        Room room5 = new Room("Room 5", "A smaller room",null);
        Room room6 = new Room("Room 6", "A room with a blue sofa",null);
        Room room7 = new Room("Room 7", "A room with ",null);
        Room room8 = new Room("Room 8", "A dusty library filled with cobwebs",null);
        Room room9 = new Room("Room 9", "An eerie room filled with cobwebs. A strange noise echoes from the darkness.",null);
        currentRoom = room1;


        // Room 1 (set neighbors):
        room1.setRoomEast(room2);
        room1.setRoomSouth(room4);
        // Room 2 (set neighbors):
        room2.setRoomEast(room3);
        room2.setRoomWest(room1);
        // Room 3 (set neighbors):
        room3.setRoomSouth(room6);
        room3.setRoomWest(room2);
        // Room 4 (set neighbors):
        room4.setRoomNorth(room1);
        room4.setRoomSouth(room7);
        // Room 5 (set neighbors):
        room5.setRoomSouth(room8);
        // Room 6 (set neighbors):
        room6.setRoomNorth(room3);
        room6.setRoomSouth(room9);
        // Room 7 (set neighbors):
        room7.setRoomNorth(room4);
        room7.setRoomEast(room8);
        // Room 8 (set neighbors):
        room8.setRoomWest(room7);
        room8.setRoomNorth(room5);
        room8.setRoomEast(room9);
        // Room 9 (set neighbors):
        room9.setRoomNorth(room6);
        room9.setRoomWest(room8);
    }
    ArrayList<Item> playerInventory = new ArrayList<>();
    Player player = new Player("player1", currentRoom, playerInventory);

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
