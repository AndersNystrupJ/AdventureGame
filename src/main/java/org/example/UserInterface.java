package org.example;
import java.util.Scanner;
public class UserInterface {

    private Adventure adventure;
    private Scanner scanner;

    public UserInterface() {
        this.adventure = new Adventure();
        this.scanner = new Scanner(System.in);
    }

  System.out.println("Welcome to Adventure");
        System.out.println("You are currently in " + MapConstruction.currentRoom.getRoomNumber());
        System.out.println(currentRoom.getRoomDescription());

    public void startGame() {
        System.out.println("Welcome to the adventure game");
        System.out.println("Type 'help' for instructions on how to play.");

        while (true) {
            System.out.println("Enter your command: ");
            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "n":
                case "north":
                case "e":
                case "east":
                case "s":
                case "south":
                case "w":
                case "west":
                    adventure.move(command);
                    break;
                case "look":
                    adventure.look();
                    break;
                case "help":
                    printInstructions();
                    break;
                case "exit":
                    System.out.println("Exiting the game.");
                    return;
                default:
                    System.out.println("Invalid command. Type 'help' for instructions.");
            }
        }


    }

    private void printInstructions() {
        System.out.println("Commands:");
        System.out.println("'n' or 'North': Go North.");
        System.out.println("'e' or 'East': Go East.");
        System.out.println("'s' or 'South': Go south.");
        System.out.println("'w' or 'West': Go West.");
    }
}
            /*
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to Adventure Game");
            System.out.println("Type 'help' for instructions on how to play");
            System.out.println();
            System.out.println("Where do you choose to go?");
            String directionOption;
            while (true) { //infinite loop til break; bruges

                directionOption = scanner.nextLine();

                if (directionOption.equalsIgnoreCase("Go north")) {

                } else if (directionOption.equalsIgnoreCase("Go west")) {

                } else if (directionOption.equalsIgnoreCase("Go east")) {

                } else if (directionOption.equalsIgnoreCase("Go south")) {

                } else if (directionOption.equalsIgnoreCase("look")) {
                    adventure.look();
                } else if (directionOption.equalsIgnoreCase("help")) {
                    System.out.println("Commands:");
                    System.out.println(" 'Go north' to go North");
                    System.out.println(" 'Go west' to go West");
                    System.out.println(" 'Go east' to go East");
                    System.out.println(" 'Go south' to go South");
                    System.out.println(" 'exit' to exit the game");
                    System.out.println(" 'look' to look around the room");
                } else if (directionOption.equals("exit")) {
                    System.out.println("Game over.");
                    break;
                } else {
                    System.out.println("Invalid input. Type 'help' for instructions on how to play the game.");
                }
            }

        }
    }


        System.out.println(AdventureGame.getCurrentRoom().getRoomNumber());
        System.out.println(AdventureGame.getCurrentRoom().getRoomDescription());
        System.out.println("1. Go North");
        System.out.println("2. Go East");
        System.out.println("3. Go South");
        System.out.println("4. Go West");
        System.out.println("5. Look");
        System.out.println("6. to exit");

        while (true) {
            int menuOption = input.nextInt();
            if (menuOption == 1) {
                System.out.println("Going North");
                // metode til at gå north
            } else if (menuOption == 2) {
                System.out.println("Going East");
            } else if (menuOption == 3) {
                System.out.println("Going South");
            } else if (menuOption == 4) {
                System.out.println("Going West");
            } else if (menuOption == 5) {
                AdventureGame.look();
            } else if (menuOption == 6) {
                System.out.println("You have chosen to exit.");
                break;
            }
        }

         */
