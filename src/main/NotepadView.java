package main;

import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

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

        viewModel.addSaveAction(itemSave);
        viewModel.addOpenAction(itemOpen);
        viewModel.addExitAction(itemExit);

    }

    public TextArea getTextArea() {
        return textArea;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

}
