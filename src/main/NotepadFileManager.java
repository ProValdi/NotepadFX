package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotepadFileManager {

    public static String readTextFromFile(File file) throws IOException {
        // Actually, BufferedReader is much slower. It was tested with files of size of 25 kB
        Scanner scanner = new Scanner(file);
        StringBuilder text = new StringBuilder();

        String line = "";
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            text.append(line).append('\n');
        }
        scanner.close();
        return text.toString();
    }

    public static void saveTextToFile(File file, String text) throws IOException {

        PrintWriter writer = new PrintWriter(file);
        writer.println(text);
        writer.close();
    }

}
