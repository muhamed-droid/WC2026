package ba.unsa.etf.rpr.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class HomeScreenController {

    //@FXML
    //private javafx.scene.control.Button buttonClick;

    //@FXML
    public void buttonClick(ActionEvent actionEvent) throws IOException {

        //Stage previusStage = (Stage) buttonClick.getScene().getWindow();
        //previusStage.close();

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TeamsSelectingPage.fxml"));
        Parent root = loader.load();
        stage.setTitle("WC2026");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(true);
        stage.getIcons().add(new Image("/icons/homeScreenIcon.jpg"));
        //Image icon = new Image(getClass().getResourceAsStream("homeScreenIcon.png"));
        //primaryStage.getIcons().add(icon);
        stage.show();

    }
}
