package main;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotepadFileManager {

    public static File openFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setTitle("Open Document");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(stage);

        return file;
    }

    public static void saveFile(String content, File file) throws IOException{
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Stage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
