package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Business.ConfederationManager;
import ba.unsa.etf.rpr.Business.TeamManager;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Team;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TeamsSelectingPageController {

    //private ArrayList<Team> listOfTeams = new ArrayList<>();

    @FXML
    private ChoiceBox<Confederation> choiceBox1 = new ChoiceBox<Confederation>();


    @FXML
    private ChoiceBox<Team> choiceBox2 = new ChoiceBox<Team>();

    @FXML
    private Button addButton = new Button();

    @FXML
    private Label selectedTeam = new Label();

    @FXML
    private ListView<Team> listView = new ListView<>();

    @FXML
    public void initialize() {

        ConfederationManager confederationManager = new ConfederationManager();


    //
        choiceBox1.setItems(FXCollections.observableList(confederationManager.getAll()));

        //choiceBox1.setValue();
        choiceBox1.setOnAction(this::getTeams);


    }

    private void getTeams (ActionEvent event) {
        TeamManager teamManager = new TeamManager();
        choiceBox2.setItems(FXCollections.observableList(teamManager.searchTeamsInConfederation(choiceBox1.getValue())));
        choiceBox2.setValue(FXCollections.observableList(teamManager.searchTeamsInConfederation(choiceBox1.getValue())).get(0));
        choiceBox2.setOnAction(this::getTeam);
    }

     private void getTeam (ActionEvent event) {
        String selected = choiceBox2.getValue().toString();
        selectedTeam.setText(selected);
    }

    public void onAddButtonClick(ActionEvent actionEvent) {
        if(!listView.getItems().contains(choiceBox2.getValue())){
            //listOfTeams.add(choiceBox2.getValue());
            listView.getItems().add(choiceBox2.getValue());
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WC2026");
            alert.setHeaderText("Warning!");
            alert.setContentText("You have already added " + choiceBox2.getValue().getTeamName() + "!");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/icons/homeScreenIcon.jpg"));
            alert.showAndWait();
        }
    }
}
