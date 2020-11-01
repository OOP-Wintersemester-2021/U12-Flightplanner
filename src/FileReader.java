import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static String[] getLinesFromFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        File inputFile = new File(filePath);
        try {
            Scanner in = new Scanner(inputFile);
            while(in.hasNext()) {
                String currentLine = in.nextLine();
                lines.add(currentLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines.toArray(new String[lines.size()]);
    }
}
