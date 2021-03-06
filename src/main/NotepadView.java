package main;

import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;

public class NotepadView extends BorderPane {

    private MenuBar menuBar;
    private TextArea textArea;
    private NotepadViewModel viewModel;

    public NotepadView(NotepadViewModel viewModel) {
        this.viewModel = viewModel;

        menuBar = new MenuBar();
        textArea = new TextArea();

        setTop(menuBar);
        setCenter(textArea);

        Menu menuFile = new Menu("File");
        Menu menuView = new Menu("View");

        MenuItem itemOpen = new MenuItem("Open");
        MenuItem itemSave = new MenuItem("Save");
        MenuItem itemExit = new MenuItem("Exit");

        SeparatorMenuItem separator = new SeparatorMenuItem();

        menuFile.getItems().addAll(itemOpen, itemSave, separator, itemExit);
        menuBar.getMenus().addAll(menuFile, menuView);

        itemOpen.setAccelerator(KeyCombination.keyCombination(Hotkeys.OPEN.getKey()));
        itemOpen.setOnAction(actionEvent -> textArea.setText(viewModel.fetchText()));

        itemSave.setAccelerator(KeyCombination.keyCombination(Hotkeys.SAVE.getKey()));
        itemSave.setOnAction(actionEvent -> viewModel.saveText(textArea.getText()));

        itemExit.setAccelerator(KeyCombination.keyCombination(Hotkeys.EXIT.getKey()));
        itemExit.setOnAction(actionEvent -> System.exit(0));

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
