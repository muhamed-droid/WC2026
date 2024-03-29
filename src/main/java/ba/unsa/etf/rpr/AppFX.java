package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class AppFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/HomeScreen.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("WC2026");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(true);
        primaryStage.getIcons().add(new Image("/icons/homeScreenIcon.jpg"));
        //Image icon = new Image(getClass().getResourceAsStream("homeScreenIcon.png"));
        //primaryStage.getIcons().add(icon);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
