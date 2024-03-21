package org.example;
import java.util.ArrayList;

public class MapConstruction {

    private Room currentRoom;

    public MapConstruction(){
        buildMap();
    }

    public void buildMap() {


        // room 1
        Room room1 = new Room("Room 1", "An empty room with two doors. There's an unpleasent smell lingering in the air...");
        room1.addItem(new Item("Shiny brass lamp", "lamp"));
        room1.addItem(new MeleeWeapon("Large two-handed sword", "sword", 5, 1));
        room1.addItem(new RangedWeapon("Wooden crossbow", "Crossbow", 10, 6));
        room1.addEnemy(new Enemy("Bandit", "Human", 20, (new MeleeWeapon("Broken dagger", "dagger", 10, 1))));


        // room 2
        Room room2 = new Room("Room 2", "A room with bloody walls and guts scattered on the floor.");
        room2.addItem(new Food("Strange dotted mushroom", "mushroom",-10));
        room2.addEnemy(new Enemy("Bandit", "Human", 20, (new MeleeWeapon("Broken dagger", "dagger", 10, 1))));
        room2.addEnemy(new Enemy("Mage", "Human", 10, (new MeleeWeapon("Wooden staff", "staff", 15, 1))));

        // room 3
        Room room3 = new Room("Room 3", "A room filled with candles and some kind of shrine in the middle. There's weird symbols covering all the walls.. It looks like some kind of ceremony have taken place recently.");
        room3.addItem(new Food("Red shiny apple", "apple", 40));

        // room 4
        Room room4 = new Room("Room 4", "A room that feels ice cold. There's ice on the walls and big chains hanging from the ceiling.");
        room4.addEnemy(new Enemy("Spirit", "A purple glooming shadow spirit with evil eyes", 40, (new MeleeWeapon("Shadow Blade", "Blade", 20, 1))));

        // room 5
        Room room5 = new Room("Room 5", "A dark room filled with dolls. You hear small light steps around you ");
        room5.addItem(new Item("Doll with missing body parts", "doll"));

        // room 6
        Room room6 = new Room("Room 6", "A room that starts getting filled with water");

        // room 7
        Room room7 = new Room("Room 7", "A lightly lit room with an ominous shadowy figure standing in the corner");
        room7.addItem(new Food("Red shiny apple", "apple", 40));

        // room 8
        Room room8 = new Room("Room 8", "A room with a locked door to the north..");

        // room 9
        Room room9 = new Room("Room 9", "An eerie room filled with cobwebs. A strange noise echoes from the darkness.");
        room9.addItem(new Item("Mysterious looking key", "Key"));

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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
