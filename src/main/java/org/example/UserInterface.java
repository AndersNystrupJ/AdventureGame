package org.example;
import java.util.Scanner;
public class UserInterface {

        public void startGame() {
            Adventure adventure = new Adventure();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Velkommen til Adventure Game");
            System.out.println("Skriv 'help' for intruktioner til spillet");
            System.out.println();

            System.out.println("You wake up in " + adventure.getCurrentRoom().getRoomDescription());
            System.out.println("On the door it says " + adventure.getCurrentRoom().getRoomNumber());

            System.out.println("Where do you choose to go?");
            while (true) { //infinite loop til break; bruges
                String menuOption = scanner.nextLine();

                if (menuOption.equals("n")) {
                    adventure.goNorth();
                } else if (menuOption.equals("w")) {
                    adventure.goWest();
                } else if (menuOption.equals("e")) {
                    adventure.goEast();
                } else if (menuOption.equals("s")) {
                    adventure.goSouth();
                } else if (menuOption.equals("look")) {
                    adventure.look();
                } else if (menuOption.equals("help")) {
                    System.out.println("Kommandoer:");
                    System.out.println(" 'n' for at gå mod nord");
                    System.out.println(" 'w' for at gå mod vest");
                    System.out.println(" 'e' for at gå mod øst");
                    System.out.println(" 's' for at gå mod syd");
                    System.out.println(" 'exit' for at gå ud af spillet");
                    System.out.println(" 'look' for at kigge rundt i dit rum");
                } else if (menuOption.equals("exit")) {
                    System.out.println("Du har afsluttet spillet");
                    break;
                } else {
                    System.out.println("Ugyldigt. Skriv 'help' for instruktioner til spillet.");
                }
            }
        }
    }

        /*
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
