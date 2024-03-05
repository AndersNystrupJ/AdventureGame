import java.util.Scanner;
public class UserInterface {
    Adventure adventure = new Adventure();

    public UserInterface() {
    }

    public void gameStart() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Velkommen til Adventure Game");
        System.out.println("Skriv 'hjælp' for intruktioner til spillet");
        System.out.println();

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
            } else if (menuOption.equals("hjælp")) {
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
                System.out.println("Ugyldigt. Skriv 'hjælp' for instruktioner til spillet.");
            }
        }
    }
}
