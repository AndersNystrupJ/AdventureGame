package org.example;
import java.util.Scanner;

public class Adventure {
    MapConstruction map = new MapConstruction();
    Scanner scanner = new Scanner(System.in);

    public Adventure() {
        map.buildAdventure();
    }


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