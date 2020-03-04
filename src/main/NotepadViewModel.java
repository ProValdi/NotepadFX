package main;

import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.w3c.dom.events.EventException;

import java.io.*;
import java.util.Scanner;

public class NotepadViewModel {

    private Stage stage;
    private String initialName;

    public NotepadViewModel(Stage stage) {
        this.stage = stage;
        initialName = stage.getTitle();
    }

    public void addSaveAction(MenuItem item) {
        item.setAccelerator(KeyCombination.keyCombination(Hotkeys.SAVE.getKey()));
        item.setOnAction(event -> {
            stage.toBack();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(stage);

            if (file != null) {
                try {
                    if (stage.getScene().getRoot().getClass().equals(NotepadView.class)) {
                        NotepadFileManager.saveFile(((NotepadView) stage.getScene().getRoot()).getTextArea().getText(), file);
                    } else {
                        throw new ClassNotFoundException();
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                stage.setTitle(initialName + " - " + file.getPath());
            }

            stage.toFront();
            stage.focusedProperty();
        });
    }

    public void addOpenAction(MenuItem item) {
        item.setAccelerator(KeyCombination.keyCombination(Hotkeys.OPEN.getKey()));
        item.setOnAction(event -> {
            stage.toBack();
            File file = NotepadFileManager.openFile(stage);

            if(file != null) {
                try {
                    // Actually, BufferedReader is much slower. It was tested with files of size of 25 kB
                    Scanner scanner = new Scanner(file);

                    String line = "";
                    if (stage.getScene().getRoot().getClass().equals(NotepadView.class)) {
                        ((NotepadView) stage.getScene().getRoot()).getTextArea().setText("");

                        while(scanner.hasNextLine()) {
                            line = scanner.nextLine();
                            ((NotepadView) stage.getScene().getRoot()).getTextArea().appendText(line + "\n");
                        }

                    } else {
                        throw new ClassNotFoundException();
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                stage.setTitle(initialName + " - " + file.getPath());
            }
            stage.toFront();
            stage.focusedProperty();
        });
    }

    public void addExitAction(MenuItem item) {
        item.setAccelerator(KeyCombination.keyCombination(Hotkeys.EXIT.getKey()));
        item.setOnAction(event -> {
            System.exit(0);
        });
    }
}

enum Hotkeys {
    OPEN("CTRL+O"),
    SAVE("CTRL+S"),
    EXIT("CTRL+ESC");

    private String key;

    Hotkeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}