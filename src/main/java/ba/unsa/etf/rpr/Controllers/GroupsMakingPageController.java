package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Business.ConfederationManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Team;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;

public class GroupsMakingPageController {

    @FXML
    private ListView<Team> listView = new ListView<>();

    @FXML
    private Pagination pagination = new Pagination();

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

        Team jamaica = new Team();
        canada.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        canada.setAbbreviation("JAM");
        canada.setTeamName("Jamaica");

        Team honduras = new Team();
        mexico.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        mexico.setAbbreviation("HON");
        mexico.setTeamName("Honduras");

        Team costaRica = new Team();
        usa.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        usa.setAbbreviation("CRC");
        usa.setTeamName("Costa Rica");

        Team panama = new Team();
        usa.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        usa.setAbbreviation("PAN");
        usa.setTeamName("Panama");

        Team japan = new Team();
        usa.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        usa.setAbbreviation("JAP");
        usa.setTeamName("Japan");

        Team australia = new Team();
        usa.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        usa.setAbbreviation("AUS");
        usa.setTeamName("Australia");


        listView.getItems().add(canada);
        listView.getItems().add(mexico);
        listView.getItems().add(usa);
        listView.getItems().add(jamaica);
        listView.getItems().add(panama);
        listView.getItems().add(honduras);
        listView.getItems().add(panama);
        listView.getItems().add(mexico);
        listView.getItems().add(usa);

        for (int i = 0; i < DaoFactory.finalistDao().getAll().size(); i++){
            listView.getItems().add(DaoFactory.finalistDao().getAll().get(i).getTeam());
        }
    }


}
