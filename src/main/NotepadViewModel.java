package main;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.*;

public class NotepadViewModel {

    private Stage stage;
    private String initialTitle;

    public NotepadViewModel(Stage stage) {
        this.stage = stage;
        initialTitle = stage.getTitle();
    }

    public void SaveText(TextArea text) {
        File file = NotepadFileManager.chooseFile("Save").showSaveDialog(stage);

        if (file != null) {
            try {
                NotepadFileManager.saveFile(file, text);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle(initialTitle + " - " + file.getPath());
        }

    }

    public String getText() {
        File file = NotepadFileManager.chooseFile("Open").showOpenDialog(stage);
        TextArea area = null;

        if(file != null) {
            try {
                area = NotepadFileManager.readFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setTitle(initialTitle + " - " + file.getPath());
        }
        return area != null? area.getText() : null;
    }


}
