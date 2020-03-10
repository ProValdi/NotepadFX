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
            try {
                NotepadFileManager.saveTextToFile(file, text);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            stage.setTitle(initialTitle + " - " + file.getPath());
        }

    }

    public String getText() {
        File file = getFileChooser("Open").showOpenDialog(stage);
        String text = null;

        if(file != null) {
            try {
                text = NotepadFileManager.readTextFromFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
