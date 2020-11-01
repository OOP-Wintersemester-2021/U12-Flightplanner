import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "data/flights.txt";

    public static void main(String[] args) throws IOException {
        initialize();
    }

    private static void initialize() {
        // Liest die Inhalte der Datei "data/flights.txt" zeilenweise in ein String-Array
        String[] lines = FileReader.getLinesFromFile(FILE_PATH);
    }

    /**
     * Liest die letzte Konsoleneingabe des Nutzers aus
     * @return Nutzereingabe
     */
    private static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
