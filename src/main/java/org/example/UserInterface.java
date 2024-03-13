package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Adventure adventure = new Adventure();
        Player player = adventure.getMap().player;
        Room room;

        System.out.println();
        System.out.println("Welcome to THE BACKROOMS");
        System.out.println();
        System.out.println("Type commands to explore the rooms:");
        System.out.println("- \"Go North/East/South/West\" to move");
        System.out.println();
        System.out.println("- \"look\" to look around the room");
        System.out.println("- \"take [item]\" to pick up an item");
        System.out.println("- \"drop [item]\" to drop an item");
        System.out.println("- \"eat [item]\" to eat a food item");
        System.out.println("- \"inventory\" to view your inventory");
        System.out.println();
        System.out.println("- \"help\" to get instructions");
        System.out.println("- \"exit\" to quit the game");
        System.out.println();

        System.out.println("You find yourself in " + adventure.getMap().getCurrentRoom().getRoomDescription());

        String itemToTake;

        while (true) {
           // adventure.getMap().player.playerHealth();

            String input = scanner.nextLine().toLowerCase();
            String[] inputArray = input.split(" "); // det der split
            itemToTake = "";
            if (inputArray[0].equals("take")) {
                input = inputArray[0];
                itemToTake = inputArray[1];
            } else if (inputArray[0].equals("drop")) {
                input = inputArray[0];
                itemToTake = inputArray[1];
            } else if (inputArray[0].equals("eat")) {
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
                    case "take":
                        player.takeItem(adventure.getMap().getCurrentRoom(), itemToTake);
                        break;
                    case "drop":
                        if (inputArray.length > 1) {
                            itemToTake = inputArray[1];
                            player.dropItem(adventure.getMap().getCurrentRoom(), itemToTake);
                        } else {
                            System.out.println("Please specify an item to drop.");
                        }
                        break;
                    case "eat":
                        player.eat(adventure.getMap().getCurrentRoom(), itemToTake);
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
                        break;
                    case "inventory":
                        player.viewInventory();
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                        System.out.println("You cannot go that way.");
                        break;
                }

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

                     */
            }
        }
    }