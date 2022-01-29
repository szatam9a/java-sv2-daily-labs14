package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StreetView {
    private Map<String, List<Integer>> streetView = new TreeMap<>();

    public Map<String, List<Integer>> fillTheStreet(Path path) {
        String line;
        String street;
        int number;

        try (BufferedReader br = Files.newBufferedReader(path)) {
            while ((line = br.readLine()) != null) {
                int length = line.length();
                street = line.substring(0, length - 2);
                number = Integer.parseInt(line.substring(length - 1));
                putAddressInCorrectList(street, number);
            }
        } catch (IOException io) {
            System.out.println("i ate in exception");
        }
        return streetView;
    }

    private void putAddressInCorrectList(String street, int number) {
        validateTheStreetIn(street);
        if (number % 2 == 0) {
            int streetNumber = countEven(street);
            streetView.get(street).add(streetNumber);
            return;
        }
        int streetNumber = countOdd(street);
        streetView.get(street).add(streetNumber);
    }

    private int countEven(String street) {
        long number = streetView.get(street).stream().mapToInt(e -> e).filter(e -> e % 2 == 0).count();
        return (int) (number + 1) * 2;
    }

    private int countOdd(String street) {
        long number = streetView.get(street).stream().mapToInt(e -> e).filter(e -> e % 2 == 1).count();
        return (int) number * 2 + 1;
    }

    private void validateTheStreetIn(String street) {
        if (!streetView.containsKey(street)) {
            streetView.put(street, new LinkedList<>());
        }
    }

    public static void main(String[] args) {
        System.out.println(new StreetView().fillTheStreet(Path.of("src/main/resources/streets.txt")));
    }
}
