package operations;

import client.Client;
import dvd.DVD;
import dvd.Genre;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClientOperations extends Operations{

    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static void addClient() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine(); //sprawdz czy juz nie ma takiego
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine(); //sprawdz czy juz nie ma takiego
        System.out.print("Enter birth date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        Date date;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
            //podaj date w prawidlowym formacie
        }

        Client client = new Client(firstName, lastName, date);

        List<List<String>> allClients = readFromCSV("client.csv");
        List<String> clientToAdd = client.toStringList();

        boolean isClientAvailable = allClients.stream()
                .anyMatch(c -> c.equals(clientToAdd));

        if(isClientAvailable) {
            System.out.println("Such a client already exist!");
        } else {
            System.out.println("Client added!");
            writeToCSV(client, "client.csv");
        }
    }

    public static void writeToCSV(Client client, String fileName) {
        List<List<String>> dataFromCSV = readFromCSV(fileName);// if file is not empty!
        List<List<String>> dataLines = new ArrayList<>();//param
        dataLines.add(client.toStringList());//
        List<List<String>> dataToWrite = Stream.concat(dataFromCSV.stream(), dataLines.stream())//
                .collect(Collectors.toList());//
        File csvOutputFile = new File(fileName);

        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataToWrite.stream()
                    .map(data -> convertToCSV(data))//
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
