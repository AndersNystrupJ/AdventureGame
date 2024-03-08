package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Adventure adventure = new Adventure();
        Player player = adventure.getMap().player;

        System.out.println("Welcome to THE BACKROOMS");
        System.out.println();
        System.out.println("Type \"Go North/East/South/West\" to move that direction");
        System.out.println("Type \"look\" to look around the room");
        System.out.println("Type \"take\" to pick up an item");
        System.out.println("Type \"inventory\" to see your inventory");
        System.out.println("Type \"help\" to get instructions");
        System.out.println("Type \"exit\" to exit the game");
        System.out.println();
        System.out.println("You find yourself in " + adventure.getMap().getCurrentRoom().getRoomDescription());
        System.out.println("What will you do?");

        String itemToTake;

        while (true) {

            String input = scanner.nextLine().toLowerCase();
            String[] inputArray = input.split(" ");
            itemToTake = "";
            if (inputArray[0].equals("take")) {
                input = inputArray[0];
                itemToTake = inputArray[1];
            } else if (inputArray[0].equals("drop")) {
                input = inputArray[0];
                itemToTake = inputArray[1];
            }
            switch (input) {
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

                    /*
                case "take":
                    String itemName = inputArray[1];
                    player.takeItem(itemName);
                    break;

                     */

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
                        System.out.println("You look around, and notice some items in the room:");
                        for (int i = 0; i < adventure.getMap().getCurrentRoom().getItems().size(); i++) {
                            System.out.println(adventure.getMap().getCurrentRoom().getItems().get(i).getLongName());
                        }
                    } catch (Exception e) {
                    }
                    System.out.println();
                    break;

                    /*
                case "take": // Take (remove item from room and put it in player inventory)
                    for (int i = 0; i < adventure.getMap().getCurrentRoom().getItems().size();i++) {
                        System.out.println("Type in what you would like to take:");
                        String take = scanner.nextLine();
                        if (adventure.getMap().getCurrentRoom().getItems().get(i).getShortName().equals(take.toLowerCase())) {
                            adventure.getMap().getPlayer().getItems().add(adventure.getMap().getCurrentRoom().getItems().get(i));
                            adventure.getMap().getCurrentRoom().getItems().remove(adventure.getMap().getCurrentRoom().getItems().get(i));
                            break;
                        }
                        else {
                            System.out.println("There is no " + take + " to pick up");
                        }


                    }
                        break;
                case "inventory":
                    for (int i = 0; i < adventure.getMap().playerInventory.size(); i++)
                    System.out.println(adventure.getMap().playerInventory.get(i).getLongName());
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("You cannot go that way.");
                    break;
            }



                     */
            }
        }
    }
}