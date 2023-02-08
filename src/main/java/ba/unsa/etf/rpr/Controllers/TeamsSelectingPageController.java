package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Business.ConfederationManager;
import ba.unsa.etf.rpr.Business.TeamManager;
import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Finalist;
import ba.unsa.etf.rpr.domain.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class TeamsSelectingPageController {


    @FXML
    private ChoiceBox<Confederation> choiceBox1 = new ChoiceBox<Confederation>();


    @FXML
    private ChoiceBox<Team> choiceBox2 = new ChoiceBox<Team>();

    @FXML
    private Button finishButton = new Button();

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


    public void onAddButtonClick(ActionEvent actionEvent) throws IOException {

        Team newTeam = choiceBox2.getValue();
        //newTeam.setConfederation(choiceBox1.getValue());

        if(listView.getItems().size()<48){

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

        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WC2026");
            alert.setHeaderText("Warning!");
            alert.setContentText("You already added 48 teams, press finish!");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/icons/homeScreenIcon.jpg"));
            alert.showAndWait();

        }
    }

    public void onClickRandomButton(ActionEvent actionEvent) throws IOException {
        if (listView.getItems().size() < 48) {
            int numOfAFC = 0;
            int numOfCAF = 0;
            int numOfCONCACAF = 0;
            int numOfCONMEBOL = 0;
            int numOfOFC = 0;
            int numOfUEFA = 0;

            ConfederationDaoSQLImpl dao1 = new ConfederationDaoSQLImpl();
            TeamDao dao = new TeamDaoSQLImpl();

            for (Team t : listView.getItems()) {
                if (t.getConfederation().equals(dao1.getById(1))) {
                    numOfAFC++;
                }
                if (t.getConfederation().equals(dao1.getById(2))) {
                    numOfCAF++;
                }
                if (t.getConfederation().equals(dao1.getById(3))) {
                    numOfCONCACAF++;
                }
                if (t.getConfederation().equals(dao1.getById(4))) {
                    numOfCONMEBOL++;
                }
                if (t.getConfederation().equals(dao1.getById(5))) {
                    numOfOFC++;
                }
                if (t.getConfederation().equals(dao1.getById(6))) {
                    numOfUEFA++;
                }
            }

            int diffAFC = 8 - numOfAFC;
            int diffCAF = 9 - numOfCAF;
            int diffCONCACAF = 7 - numOfCONCACAF;
            int diffCONMEBOL = 7 - numOfCONMEBOL;
            int diffOFC = 1 - numOfOFC;
            int diffUEFA = 16 - numOfUEFA;

            for (int i = 0; i < diffAFC; i++) {
                Random rand = new Random();
                int int_random = rand.nextInt(45);
                Team newTeam = new Team();
                newTeam = dao.searchByConfederation(dao1.getById(1)).get(int_random);
                if (listView.getItems().contains(newTeam)) {
                    i--;
                } else {
                    listView.getItems().add(newTeam);
                }
            }
            for (int i = 0; i < diffCAF; i++) {
                Random rand = new Random();
                int int_random = rand.nextInt(55);
                Team newTeam = new Team();
                newTeam = dao.searchByConfederation(dao1.getById(2)).get(int_random);
                if (listView.getItems().contains(newTeam)) {
                    i--;
                } else {
                    listView.getItems().add(newTeam);
                }
            }
            for (int i = 0; i < diffCONCACAF; i++) {
                Random rand = new Random();
                int int_random = rand.nextInt(34);
                Team newTeam = new Team();
                newTeam = dao.searchByConfederation(dao1.getById(3)).get(int_random);
                if (listView.getItems().contains(newTeam)) {
                    i--;
                } else {
                    listView.getItems().add(newTeam);
                }

            }
            for (int i = 0; i < diffCONMEBOL; i++) {
                Random rand = new Random();
                int int_random = rand.nextInt(9);
                Team newTeam = new Team();
                newTeam = dao.searchByConfederation(dao1.getById(4)).get(int_random);
                if (listView.getItems().contains(newTeam)) {
                    i--;
                } else {
                    listView.getItems().add(newTeam);
                }

            }
            for (int i = 0; i < diffOFC; i++) {
                Random rand = new Random();
                int int_random = rand.nextInt(11);
                Team newTeam = new Team();
                newTeam = dao.searchByConfederation(dao1.getById(5)).get(int_random);
                if (listView.getItems().contains(newTeam)) {
                    i--;
                } else {
                    listView.getItems().add(newTeam);
                }

            }
            for (int i = 0; i < diffUEFA; i++) {
                Random rand = new Random();
                int int_random = rand.nextInt(55);
                Team newTeam = dao.searchByConfederation(dao1.getById(6)).get(int_random);
                if (listView.getItems().contains(newTeam)) {
                    i--;
                } else {
                    listView.getItems().add(newTeam);
                }
            }

        }

        for (int i = 0; i < 48; i++) {
            Finalist finalist = new Finalist();
            finalist.setId(i);
            finalist.setTeam(listView.getItems().get(i));
            DaoFactory.finalistDao().add(finalist);
        }

    }

    public void onClickFinishButton(ActionEvent actionEvent) throws IOException {

        Stage previusStage = (Stage) finishButton.getScene().getWindow();
        previusStage.close();

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GroupsMakingPage.fxml"));
        Parent root = loader.load();
        stage.setTitle("WC2026");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.getIcons().add(new Image("/icons/homeScreenIcon.jpg"));
        stage.show();
    }
}
