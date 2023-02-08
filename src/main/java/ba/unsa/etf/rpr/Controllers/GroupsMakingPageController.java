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
        //canada.setId(1);
        canada.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        canada.setAbbreviation("CAN");
        canada.setTeamName("Canada");

        Team mexico = new Team();
        //mexico.setId(2);
        mexico.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        mexico.setAbbreviation("MEX");
        mexico.setTeamName("Mexico");

        Team usa = new Team();
        //usa.setId(3);
        usa.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        usa.setAbbreviation("USA");
        usa.setTeamName("United states");

        Team jamaica = new Team();
        //jamaica.setId(4);
        jamaica.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        jamaica.setAbbreviation("JAM");
        jamaica.setTeamName("Jamaica");

        Team honduras = new Team();
        //honduras.setId(5);
        honduras.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        honduras.setAbbreviation("HON");
        honduras.setTeamName("Honduras");

        Team costaRica = new Team();
        //costaRica.setId(6);
        costaRica.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        costaRica.setAbbreviation("CRC");
        costaRica.setTeamName("Costa Rica");

        Team panama = new Team();
        panama.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(2));
        panama.setAbbreviation("PAN");
        panama.setTeamName("Panama");

        Team japan = new Team();
        japan.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        japan.setAbbreviation("JAP");
        japan.setTeamName("Japan");

        Team australia = new Team();
        australia.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        australia.setAbbreviation("AUS");
        australia.setTeamName("Australia");

        Team china = new Team();
        china.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        china.setAbbreviation("CHI");
        china.setTeamName("China");

        Team iran = new Team();
        iran.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        iran.setAbbreviation("IRA");
        iran.setTeamName("Iran");

        Team qatar = new Team();
        qatar.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        qatar.setAbbreviation("QAT");
        qatar.setTeamName("Qatar");

        Team saudiArabia = new Team();
        saudiArabia.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        saudiArabia.setAbbreviation("KSA");
        saudiArabia.setTeamName("Saudi Arabia");

        Team southKorea = new Team();
        southKorea.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        southKorea.setAbbreviation("KOR");
        southKorea.setTeamName("South Korea");

        Team uae = new Team();
        uae.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(0));
        uae.setAbbreviation("UAE");
        uae.setTeamName("United Arab Emirates");


        listView.getItems().add(canada);
        listView.getItems().add(mexico);
        listView.getItems().add(usa);
        listView.getItems().add(jamaica);
        listView.getItems().add(panama);
        listView.getItems().add(honduras);
        listView.getItems().add(panama);

        listView.getItems().add(japan);
        listView.getItems().add(australia);
        listView.getItems().add(iran);
        listView.getItems().add(saudiArabia);
        listView.getItems().add(uae);
        listView.getItems().add(qatar);
        listView.getItems().add(southKorea);
        listView.getItems().add(china);




        for (int i = 0; i < DaoFactory.finalistDao().getAll().size(); i++){
            listView.getItems().add(DaoFactory.finalistDao().getAll().get(i).getTeam());
        }
    }


}
