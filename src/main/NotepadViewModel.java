package main;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;

public class NotepadViewModel {

    private Stage stage;
    private String initialTitle;

    public NotepadViewModel(Stage stage) {
        this.stage = stage;
        initialTitle = stage.getTitle();
    }

    public void saveText(String text) {
        File file = getFileChooser("Save").showSaveDialog(stage);

        if (file != null) {
            NotepadFileManager.saveTextToFile(file, text);
            stage.setTitle(initialTitle + " - " + file.getPath());
        }

    }

    public String fetchText() {
        File file = getFileChooser("Open").showOpenDialog(stage);
        String text = null;

        if(file != null) {
            text = NotepadFileManager.readTextFromFile(file);
            stage.setTitle(initialTitle + " - " + file.getPath());
        }
        return text;
    }

    public FileChooser getFileChooser(String name) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.setTitle(name + " Document");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser;
    }



}
