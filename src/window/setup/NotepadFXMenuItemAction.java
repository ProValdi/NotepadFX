package windowSetup;

import enums.Items;
import interfaces.WindowActioner;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotepadFXMenuItemAction implements WindowActioner {
    private final double offset = 50;

    private NotepadFXWindow window;

    public NotepadFXMenuItemAction(NotepadFXWindow window) {
        this.window = window;

    }

    @Override
    public void saveAction(MenuItem item, Items enumItem) {
        item.setAccelerator(KeyCombination.keyCombination(enumItem.getHotKey()));
        item.setOnAction(event -> {
            window.toBack();
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(window);

            if (file != null) {
                saveTextToFile(window.getTextArea().getText(), file);
            }
            window.toFront();
            window.focusedProperty();
        });
    }

    @Override
    public void openAction(MenuItem item, Items enumItem) {
        item.setAccelerator(KeyCombination.keyCombination(enumItem.getHotKey()));
        item.setOnAction(event -> {
            window.toBack();
            File file = openFile(window);

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = "";
                int i = 0;

                while ((line = reader.readLine()) != null) {
                    window.getTextArea().appendText(line + "\n");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void newFileCreating(MenuItem item, Items enumItem) {
        item.setAccelerator(KeyCombination.keyCombination(enumItem.getHotKey()));
        item.setOnAction(event -> {
            NotepadFXWindow newWindow = newFile();
            newWindow.focusedProperty();
        });
    }

    @Override
    public void exitAction(MenuItem item, Items enumItem) {
        item.setAccelerator(KeyCombination.keyCombination(enumItem.getHotKey()));
        item.setOnAction(event -> {
            window.close();
        });
    }

    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(NotepadFXMenuItemAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public File openFile(NotepadFXWindow window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Document");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("All files (*.*)", "*.*");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(window);
        if (file != null) {
            return file;
        } else {
            new NullPointerException().printStackTrace();
            return null;
        }
    }

    public NotepadFXWindow newFile() {
        NotepadFXWindow newWindow = new NotepadFXWindow();
        newWindow.setX(newWindow.getWidth() - offset);
        newWindow.setY(newWindow.getHeight() - offset);
        return newWindow;
    }

}
