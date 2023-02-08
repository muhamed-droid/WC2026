package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Business.ConfederationManager;
import ba.unsa.etf.rpr.Business.TeamManager;
import ba.unsa.etf.rpr.dao.ConfederationDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.lang.reflect.Array;
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

        Team canada = new Team();
        canada.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        canada.setAbbreviation("CAN");
        canada.setTeamName("Canada");

        Team mexico = new Team();
        mexico.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        mexico.setAbbreviation("MEX");
        mexico.setTeamName("Mexico");

        Team usa = new Team();
        usa.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        usa.setAbbreviation("USA");
        usa.setTeamName("United states");

        listView.getItems().add(canada);
        listView.getItems().add(mexico);
        listView.getItems().add(usa);
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

    public boolean regulationsCheck(ObservableList<Team> items, Team newTeam) {
        int numOfAFC=0;
        int numOfCAF=0;
        int numOfCONCACAF=0;
        int numOfCONMEBOL=0;
        int numOfOFC=0;
        int numOfUEFA=0;

        ConfederationDaoSQLImpl dao1 = new ConfederationDaoSQLImpl();

        for(Team t : items){
            if(t.getConfederation().equals(dao1.getById(1))){
                numOfAFC++;
            }
            if(t.getConfederation().equals(dao1.getById(2))){
                numOfCAF++;
            }
            if(t.getConfederation().equals(dao1.getById(3))){
                numOfCONCACAF++;
            }
            if(t.getConfederation().equals(dao1.getById(4))){
                numOfCONMEBOL++;
            }
            if(t.getConfederation().equals(dao1.getById(5))){
                numOfOFC++;
            }
            if(t.getConfederation().equals(dao1.getById(6))){
                numOfUEFA++;
            }
        }

        if(newTeam.getConfederation().equals(dao1.getById(1))){
            if(numOfAFC==8) return false;
        }

        if(newTeam.getConfederation().equals(dao1.getById(2))){
            if(numOfCAF==9) return false;
        }
        if(newTeam.getConfederation().equals(dao1.getById(3))){
            if(numOfCONCACAF==7) return false;
        }

        if(newTeam.getConfederation().equals(dao1.getById(4))){
            if(numOfCONMEBOL==7) return false;
        }
        if(newTeam.getConfederation().equals(dao1.getById(5))){
            if(numOfOFC==1) return false;
        }
        if(newTeam.getConfederation().equals(dao1.getById(6))){
            if(numOfUEFA==16) return false;
        }
        return true;
    }


    public void onAddButtonClick(ActionEvent actionEvent) {

        Team newTeam = new Team();
        newTeam = choiceBox2.getValue();

        if(!listView.getItems().contains(newTeam)){

            if(!listView.getItems().isEmpty() && !regulationsCheck(listView.getItems(), newTeam)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("WC2026");
                alert.setHeaderText("Warning!");
                alert.setContentText("Too many teams from " + newTeam.getConfederation() + ". Check the regulations!");
                ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/icons/homeScreenIcon.jpg"));
                alert.showAndWait();
            }else{
                listView.getItems().add(newTeam);
            }

        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WC2026");
            alert.setHeaderText("Warning!");
            alert.setContentText("You have already added " + newTeam.getTeamName() + "!");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/icons/homeScreenIcon.jpg"));
            alert.showAndWait();
        }



    }
}
