import org.example.Adventure;
import org.example.Room;
import java.util.Scanner;
public class UserInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Adventure AdventureGame = new Adventure();

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

    }

}
