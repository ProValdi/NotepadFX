package main;

import javafx.scene.control.Alert;
import java.io.*;

public class NotepadFileManager {

    public static String readTextFromFile(File file) {
        StringBuilder text = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while((line = br.readLine()) != null) {
                text.append(line).append('\n');
            }
            return text.toString();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return null;
    }

    public static void saveTextToFile(File file, String text) {

        try(PrintWriter writer = new PrintWriter(file)) {
            writer.println(text);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }

}
