package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static int width = 600;
    public static int height = 800;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("NotepadFX");
        NotepadView view = new NotepadView(new NotepadViewModel(primaryStage));

        Scene scene = new Scene(view, width, height);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
