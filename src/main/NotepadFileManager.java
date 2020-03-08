package main;

import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NotepadFileManager {

    public static FileChooser chooseFile(String name) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setTitle(name + " Document");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser;
    }

    public static TextArea readFile(File file) throws IOException {
        // Actually, BufferedReader is much slower. It was tested with files of size of 25 kB
        Scanner scanner = new Scanner(file);
        TextArea textArea = new TextArea();

        String line = "";
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            textArea.appendText(line + "\n");
        }
        scanner.close();
        return textArea;
    }

    public static void saveFile(File file, TextArea content) throws IOException {

        PrintWriter writer = new PrintWriter(file);
        writer.println(content.getText());
        writer.close();
    }

}
