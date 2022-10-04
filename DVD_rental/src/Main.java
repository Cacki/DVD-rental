import operations.ClientOperations;
import operations.DVDOperations;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome on DVD Rental application!");

        while(true) {
            System.out.println("1 - ADD TITLE");
            System.out.println("2 - REMOVE TITLE");
            System.out.println("3 - READ TITLES");
            System.out.println("4- LIST AVAILABLE DVD");
            System.out.println("5- LIST SORTED");
            System.out.println("6- ADD CLIENT");
            System.out.println("7- READ CLIENTS");
            System.out.println("0 - EXIT");

            int x = scanner.nextInt();

            switch (x) {
                case 1:
                    //ADD TITLE
                    DVDOperations.addDVD();
                    break;
                case 2:
                    //REMOVE TITLE
                    System.out.println("Title to remove: ");
                    String title = scanner.nextLine();
                    DVDOperations.removeFromCSV(title, "dvd.csv");
                    break;
                case 3:
                    //SHOW TITLES
                    System.out.println(DVDOperations.readFromCSV("dvd.csv"));
                    break;
                case 4:
                    //LIST AVAILABLE DVD
                    DVDOperations.listAvailableDVD();
                    break;
                case 5:
                    //LIST SORTED DVD
                    DVDOperations.listSortedDVD();
                    break;
                case 6:
                    //ADD CLIENT
                    ClientOperations.addClient();
                    break;
                case 7:
                    //READ CLIENTS
                    System.out.println(ClientOperations.readFromCSV("client.csv"));
                    break;
                case 0:
                    exit(0);
                default:
                    System.out.println("Enter number again");
            }
        }
    }
}