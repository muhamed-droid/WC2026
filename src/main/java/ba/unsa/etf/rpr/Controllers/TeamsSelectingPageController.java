package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Business.ConfederationManager;
import ba.unsa.etf.rpr.Business.TeamManager;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Team;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class TeamsSelectingPageController {

    @FXML
    private ChoiceBox<Confederation> choiceBox1 = new ChoiceBox<Confederation>();


    @FXML
    private ChoiceBox<Team> choiceBox2 = new ChoiceBox<Team>();

    @FXML
    private Button addButton = new Button();

    @FXML
    private Label selectedTeam = new Label();

    @FXML
    public void initialize() {



        ConfederationManager confederationManager = new ConfederationManager();
        TeamManager teamManager = new TeamManager();



        choiceBox1.setValue(FXCollections.observableList(confederationManager.getAll()).get(0));
        choiceBox1.setItems(FXCollections.observableList(confederationManager.getAll()));

        //choiceBox1.setValue();
        choiceBox2.setItems(FXCollections.observableList(teamManager.searchTeamsInConfederation(choiceBox1.getValue())));
        choiceBox2.setValue(FXCollections.observableList(teamManager.searchTeamsInConfederation(choiceBox1.getValue())).get(0));
        choiceBox2.setOnAction(this::getTeam);
    }

     private void getTeam (ActionEvent event) {
        String selected = choiceBox2.getValue().toString();
        selectedTeam.setText(selected);
    }

    public void onAddButtonClick(ActionEvent actionEvent) {

    }
}
