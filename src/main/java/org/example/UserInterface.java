package org.example;
import java.util.Scanner;
public class UserInterface {
    public void startGame() {

    Scanner scanner = new Scanner(System.in);
    Adventure adventure = new Adventure();

        System.out.println("Welcome to Adventure");
        System.out.println();
        System.out.println("You are currently in " + adventure.getMap().getCurrentRoom().getRoomNumber());
        System.out.println(adventure.getMap().getCurrentRoom().getRoomDescription());
        System.out.println();
        System.out.println("Items in room:");
        for (Item item : adventure.getMap().getCurrentRoom().getItems()) {
            System.out.println(item.getLongName());
        }

        System.out.println();

        while (true) {
            System.out.println("Where do you want to go? (North/East/South/West)");
            System.out.println("Type \"look\" to look around the room");
            System.out.println();
            System.out.println("Type \"help\" to get instructions");
            System.out.println("Type \"exit\" to exit the game");

            switch (scanner.nextLine().toLowerCase()) {
                case "go north":
                case "north":
                case "n":
                    if (adventure.getMap().getCurrentRoom().getRoomNorth() != null) {
                        adventure.getMap().setCurrentRoom(adventure.getMap().getCurrentRoom().getRoomNorth());
                        System.out.println(adventure.getMap().getCurrentRoom().getRoomNumber());
                        System.out.println(adventure.getMap().getCurrentRoom().getRoomDescription());
                        System.out.println();
                    } else {
                        System.out.println("You can't go north from here.");
                    }
                    break;
                case "go east":
                case "east":
                case "e":
                    if (adventure.getMap().getCurrentRoom().getRoomEast() != null) {
                        adventure.getMap().setCurrentRoom(adventure.getMap().getCurrentRoom().getRoomEast());
                        System.out.println(adventure.getMap().getCurrentRoom().getRoomNumber());
                        System.out.println(adventure.getMap().getCurrentRoom().getRoomDescription());
                        System.out.println();
                    } else {
                        System.out.println("You can't go east from here.");
                    }
                    break;
                case "go south":
                case "south":
                case "s":
                    if (adventure.getMap().getCurrentRoom().getRoomSouth() != null) {
                        adventure.getMap().setCurrentRoom(adventure.getMap().getCurrentRoom().getRoomSouth());
                        System.out.println(adventure.getMap().getCurrentRoom().getRoomNumber());
                        System.out.println(adventure.getMap().getCurrentRoom().getRoomDescription());
                        System.out.println();
                    } else {
                        System.out.println("You can't go south from here.");
                    }
                    break;
                case "go west":
                case "west":
                case "w":
                    if (adventure.getMap().getCurrentRoom().getRoomWest() != null) {
                        adventure.getMap().setCurrentRoom(adventure.getMap().getCurrentRoom().getRoomWest());
                        System.out.println(adventure.getMap().getCurrentRoom().getRoomNumber());
                        System.out.println(adventure.getMap().getCurrentRoom().getRoomDescription());
                        System.out.println();
                    } else {
                        System.out.println("You can't go west from here.");
                    }
                    break;
                case "help":
                    System.out.println("Type \"go north\", \"north\" or \"n\" to go north");
                    System.out.println("Type \"go east\", \"east\" or \"e\" to go east");
                    System.out.println("Type \"go south\", \"south\" or \"s\" to go south");
                    System.out.println("Type \"go west\", \"west\" or \"w\" to go west");
                    System.out.println();
                    break;
                case "look":
                    adventure.look();
                    try {
                        System.out.println();
                        System.out.println("Items in room:");
                        for (int i = 0; i < adventure.getMap().getCurrentRoom().getItems().size(); i++){
                            System.out.println(adventure.getMap().getCurrentRoom().getItems().get(i).getLongName());
                        }
                    } catch (Exception e){
                    }
                    System.out.println();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("You cannot go that way.");
                    break;
            }
        }
    }
}