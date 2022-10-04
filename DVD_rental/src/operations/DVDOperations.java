package operations;

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

public class DVDOperations extends Operations{

    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public static void addDVD() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter genre (action, thriller, horror, comedy): ");
        Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Enter release date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        Date date;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Enter price: ");
        Double price = scanner.nextDouble();

        DVD dvd = new DVD(title, genre, date, price, true, " ");
        dvd.toStringList();
        System.out.println("DVD added!");
        writeToCSV(dvd, "dvd.csv");
    }

    public static void writeToCSV(DVD dvd, String fileName) {
        List<List<String>> dataFromCSV = readFromCSV(fileName);
        List<List<String>> dataLines = new ArrayList<>();
        dataLines.add(dvd.toStringList());

        List<List<String>> dataToWrite = Stream.concat(dataFromCSV.stream(), dataLines.stream())
                .collect(Collectors.toList());

        File csvOutputFile = new File(fileName);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataToWrite.stream()
                    .map(data -> convertToCSV(data))
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void listAvailableDVD() {
        List<List<String>> allDVD = readFromCSV("dvd.csv");

        allDVD.stream()
                .filter(d -> d.get(4).equals("true"))
                .forEach(System.out::println);
    }

    public static void listSortedDVD() {
        List<List<String>> allDVD = readFromCSV("dvd.csv");

        allDVD.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
        allDVD.forEach(System.out::println);

    }
}