package org.example;

import java.util.Scanner;

public class Adventure {
    private Room currentRoom;
    Scanner scanner = new Scanner(System.in);

    public Adventure() {
        buildAdventure();
    }

    public void buildAdventure() {
        Room room1 = new Room("Room 1", "An empty room with with two doors. There's an unpleasent smell lingering in the air...");
        Room room2 = new Room("Room 2", "A bloody room with guts on the floor.");
        Room room3 = new Room("Room 3", "A room with weird symbols on the wall.");
        Room room4 = new Room("Room 4", "A room that feels ice cold");
        Room room5 = new Room("Room 5", "A smaller room");
        Room room6 = new Room("Room 6", "hej");
        Room room7 = new Room("Room 7", "med");
        Room room8 = new Room("Room 8", "dig");
        Room room9 = new Room("Room 9", "søde");
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

        System.out.println("Welcome to Adventure");
        System.out.println("You are currently in " + currentRoom.getRoomNumber());
        System.out.println(currentRoom.getRoomDescription());

        while (true) {
            System.out.println("Where do you want to go? (North/East/South/West)");
            String direction = scanner.nextLine().toLowerCase();
            move(direction);
        }
    }

    public void move(String direction) {
        switch (direction) {
            case "go north":
            case "north":
            case "n":
                if (currentRoom.getRoomNorth() != null) {
                    currentRoom = currentRoom.getRoomNorth();
                    System.out.println(currentRoom.getRoomNumber());
                    System.out.println(currentRoom.getRoomDescription());
                } else {
                    System.out.println("You can't go north from here.");
                }
                break;
            case "go east":
            case "east":
            case "e":
                if (currentRoom.getRoomEast() != null) {
                    currentRoom = currentRoom.getRoomEast();
                    System.out.println(currentRoom.getRoomNumber());
                    System.out.println(currentRoom.getRoomDescription());
                } else {
                    System.out.println("You can't go east from here.");
                }
                break;
            case "go south":
            case "south":
            case "s":
                if (currentRoom.getRoomSouth() != null) {
                    currentRoom = currentRoom.getRoomSouth();
                    System.out.println(currentRoom.getRoomNumber());
                    System.out.println(currentRoom.getRoomDescription());
                } else {
                    System.out.println("You can't go south from here.");
                }
                break;
            case "go west":
            case "west":
            case "w":
                if (currentRoom.getRoomWest() != null) {
                    currentRoom = currentRoom.getRoomWest();
                    System.out.println(currentRoom.getRoomNumber());
                    System.out.println(currentRoom.getRoomDescription());
                } else {
                    System.out.println("You can't go west from here.");
                }
                break;
            default:
                System.out.println("Invalid direction. Please enter North, East, South or West.");
                break;
        }
    }

    public void look() {
        System.out.println(currentRoom.getRoomDescription());
    }
}