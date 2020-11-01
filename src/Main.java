import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "data/flights.txt";

    private static HashMap<String, String[]> flights = new HashMap<>();
    private static ArrayList<String> trip = new ArrayList<>();

    private static String origin;
    private static String current;
    private static boolean isStarted;

    public static void main(String[] args) throws IOException {
        initialize();
    }

    private static void initialize() {
        readFlights();
        start();

        do {
            System.out.println("Where do you want to go from " + current + "?");
            printDestinations(current);
            current = getInput();
            trip.add(current);
        } while (!origin.equals(current));
        
        end();
    }

    private static void start() {
        System.out.println("Let's plan a round trip:");
        System.out.println("Here is a list of all the destinations in our database:");
        for (String destination : flights.keySet()) {
            System.out.println(destination);
        }

        System.out.println("Which city do you want to start in: ");
        origin = getInput();
        current = origin;
        trip.add(origin);
        isStarted = true;
    }

    private static void end() {
        System.out.println("You completed your trip!");
        System.out.println("Your trips spanned the following destinations:");
        for (int i = 0; i < trip.size(); i++) {
            String destination = trip.get(i);
            System.out.print(destination);
            if (i < trip.size() - 1) {
                System.out.print(" -> ");
            }
        }
    }

    private static String getInput() {
        String input;
        while (!isValidDestination(input = readLine())) {
            System.out.println("Not a valid destination! Please enter one from the above list!");
        }
        return input;
    }

    private static boolean isValidDestination(String destination) {
        if(isStarted){
            String[] destinations = flights.get(current);
            return Arrays.asList(destinations).contains(destination);
        }else{
            return flights.containsKey(destination);
        }
    }

    private static void printDestinations(String origin) {
        String[] destinations = flights.get(origin);

        for (String destination : destinations) {
            System.out.println(destination);
        }
    }

    /**
     * Liest die letzte Konsoleneingabe des Nutzers aus
     * 
     * @return Nutzereingabe
     */
    private static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static void readFlights() {
        String[] lines = FileReader.getLinesFromFile(FILE_PATH);
        for (String line : lines) {
            String[] originDestinations = line.split("->");
            String origin = originDestinations[0].trim();
            String[] destinations = splitDestinations(originDestinations[1]);

            flights.put(origin, destinations);
        }
    }

    private static String[] splitDestinations(String destinations) {
        String[] results = destinations.split(",");
        for (int i = 0; i < results.length; i++) {
            results[i] = results[i].trim();
        }
        return results;
    }
}
