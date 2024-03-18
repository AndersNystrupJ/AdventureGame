package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class UserInterface {
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Adventure adventure = new Adventure();
        Player player = adventure.getMap().player;
        Room room;


        System.out.println("Insert player name:");
        player.setPlayerName(scanner.nextLine());
        System.out.println();
        System.out.println("Welcome to The Undercroft of Forsaken Souls, " + player.getPlayerName());
        System.out.println();
        boolean gameStartTrue = false;
        while (!gameStartTrue) {
            System.out.println("Type \"start\" to start your journey");
            String gameStart = scanner.nextLine();
            if (gameStart.equalsIgnoreCase("start")) {
                gameStartTrue = true;
            } else {
                System.out.print("Invalid input. ");
            }
        }

        System.out.println("How to play:");
        System.out.println("- \"Go North/East/South/West\" to move");
        System.out.println();
        /* System.out.println("- \"look\" to look around the room");
        System.out.println("- \"take [item]\" to pick up an item");
        System.out.println("- \"drop [item]\" to drop an item");
        System.out.println("- \"eat [item]\" to eat a food item");
        System.out.println("- \"inventory\" to view your inventory");
        System.out.println(); */
        System.out.println("- \"help\" to get further instructions");
        System.out.println("- \"exit\" to quit the game");
        System.out.println();


        System.out.println("You find yourself in " + adventure.getMap().getCurrentRoom().getRoomDescription());
        System.out.println();
        adventure.getMap().player.playerHealth();
        System.out.println();

        String itemToTake;


        while (gameStartTrue) {


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
            } else if (inputArray[0].equals("equip")) {
                input = inputArray[0];
                itemToTake = inputArray[1];
            } else if (inputArray[0].equals("unequip")) {
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
                            adventure.getMap().player.playerHealth();
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
                            adventure.getMap().player.playerHealth();
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
                            adventure.getMap().player.playerHealth();
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
                            adventure.getMap().player.playerHealth();
                            System.out.println();
                        } else {
                            System.out.println("You can't go west from here.");
                        }
                        break;
                    case "take":
                        player.takeItem(adventure.getMap().getCurrentRoom(), itemToTake);
                        System.out.println();
                        break;
                    case "drop":
                        if (inputArray.length > 1) {
                            itemToTake = inputArray[1];
                            player.dropItem(adventure.getMap().getCurrentRoom(), itemToTake);
                            System.out.println();
                        } else {
                            System.out.println("Please specify an item to drop.");
                        }
                        break;
                    case "equip":
                        player.equip(adventure.getMap().getCurrentRoom(), itemToTake);
                        System.out.println();
                        break;
                    case "unequip":
                        if (inputArray.length > 1) {
                            player.unequipWeapon(adventure.getMap().getCurrentRoom(), itemToTake);
                            System.out.println();
                        } else {
                            System.out.println("Please specify an item to drop");
                        }
                        break;
                    case "eat":
                        player.eat(adventure.getMap().getCurrentRoom(), itemToTake);
                        System.out.println();
                        break;
                    case "attack":
                        player.attack();
                        break;
                    case "help":
                        System.out.println("Type \"go north\", \"north\" or \"n\" to go north");
                        System.out.println("Type \"go east\", \"east\" or \"e\" to go east");
                        System.out.println("Type \"go south\", \"south\" or \"s\" to go south");
                        System.out.println("Type \"go west\", \"west\" or \"w\" to go west");
                        System.out.println();
                        System.out.println("Type \"look\" to look around the room");
                        System.out.println("Type \"take [item]\" to pick up an item");
                        System.out.println("Type \"drop [item]\" to drop an item");
                        System.out.println("Type \"eat [item]\" to eat a food item");
                        System.out.println("Type \"inventory\" to view your inventory");
                        System.out.println();
                        System.out.println("Type \"exit\" to quit the game");
                        System.out.println();
                        break;
                    case "look":
                        adventure.look();
                        System.out.println();
                        adventure.getMap().player.playerHealth();
                        System.out.println();
                        break;
                    case "inventory":
                        player.viewInventory();
                        System.out.println();
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                        System.out.println("You cannot go that way.");
                        System.out.println();
                        break;
                }
            }
        }
    }