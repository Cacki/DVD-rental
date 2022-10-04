package operations;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Operations {
    private static final String COMMA_DELIMITER = ",";

    public static String convertToCSV(List<String> data) {
        String joinedData = data.stream().collect(Collectors.joining(","));
        return joinedData;
    }

    public static List<List<String>> readFromCSV(String fileName) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }

    public static void writeToCSV(List<List<String>> listToWrite, String fileName) {
        File csvOutputFile = new File(fileName);

        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            listToWrite.stream()
                    .map(data -> convertToCSV(data))
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeFromCSV(String title, String fileName) {
        List<List<String>> records = readFromCSV(fileName);

        List<String> rowToRemove = records.stream()
                .filter(r -> r.get(0).equals(title))
                .findFirst().get();

        records.remove(rowToRemove);
        writeToCSV(records, fileName);
    }
}