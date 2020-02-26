package windowSetup;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class NotepadFXWindow extends Stage {

    private double width;
    private double height;
    private TextArea textArea;
    private NotepadFXMenuBar menuBar;
    private BorderPane root;

    public NotepadFXWindow() {

        this(600, 800);
    }

    public NotepadFXWindow(double width, double height) {
        this.width = width;
        this.height = height;
        setupPane();
    }

    private void setupPane() {
        textArea = new TextArea();
        menuBar = new NotepadFXMenuBar(this);

        root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(textArea);

        Scene scene = new Scene(root, width, height);
        setScene(scene);

        setTitle("NotepadFX");
        show();
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public NotepadFXMenuBar getMenuBar() {
        return menuBar;
    }

}
