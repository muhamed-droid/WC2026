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

        Team angola = new Team();
        angola.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(1));
        angola.setAbbreviation("ANG");
        angola.setTeamName("Angola");

        Team ghana = new Team();
        ghana.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(1));
        ghana.setAbbreviation("GHA");
        ghana.setTeamName("Ghana");

        Team cameroon = new Team();
        cameroon.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(1));
        cameroon.setAbbreviation("CAM");
        cameroon.setTeamName("Cameroon");

        Team algeria = new Team();
        algeria.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(1));
        algeria.setAbbreviation("ALG");
        algeria.setTeamName("Algeria");

        Team tunisia = new Team();
        tunisia.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(1));
        tunisia.setAbbreviation("TUN");
        tunisia.setTeamName("Tunisia");

        Team morocco = new Team();
        morocco.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(1));
        morocco.setAbbreviation("MAR");
        morocco.setTeamName("Morocco");

        Team ivoryCoast = new Team();
        ivoryCoast.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(1));
        ivoryCoast.setAbbreviation("CIV");
        ivoryCoast.setTeamName("Ivory Coast");

        Team senegal = new Team();
        senegal.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(1));
        senegal.setAbbreviation("SEN");
        senegal.setTeamName("Senegal");

        Team nigeria = new Team();
        nigeria.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(1));
        nigeria.setAbbreviation("NGA");
        nigeria.setTeamName("Nigeria");

        Team argentina = new Team();
        argentina.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(3));
        argentina.setAbbreviation("ARG");
        argentina.setTeamName("Argentina");

        Team brazil = new Team();
        brazil.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(3));
        brazil.setAbbreviation("BRA");
        brazil.setTeamName("Brazil");

        Team uruguay = new Team();
        uruguay.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(3));
        uruguay.setAbbreviation("URU");
        uruguay.setTeamName("Uruguay");

        Team paraguay = new Team();
        paraguay.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(3));
        paraguay.setAbbreviation("PAR");
        paraguay.setTeamName("Paraguay");

        Team chile = new Team();
        chile.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(3));
        chile.setAbbreviation("CHI");
        chile.setTeamName("Chile");

        Team colombia = new Team();
        colombia.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(3));
        colombia.setAbbreviation("COL");
        colombia.setTeamName("Colombia");

        Team peru = new Team();
        peru.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(3));
        peru.setAbbreviation("PER");
        peru.setTeamName("Peru");


        Team newZealand = new Team();
        newZealand.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(4));
        newZealand.setAbbreviation("NZE");
        newZealand.setTeamName("New Zealand");


        Team italy = new Team();
        italy.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        italy.setAbbreviation("ITA");
        italy.setTeamName("Italy");

        Team france = new Team();
        france.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        france.setAbbreviation("FRA");
        france.setTeamName("France");

        Team spain = new Team();
        spain.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        spain.setAbbreviation("SPA");
        spain.setTeamName("Spain");

        Team germany = new Team();
        germany.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        germany.setAbbreviation("GER");
        germany.setTeamName("Germany");


        Team england = new Team();
        england.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        england.setAbbreviation("ENG");
        england.setTeamName("England");

        Team BiH = new Team();
        BiH.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        BiH.setAbbreviation("BIH");
        BiH.setTeamName("Bosnia and Herzegovina");

        Team croatia = new Team();
        croatia.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        croatia.setAbbreviation("CRO");
        croatia.setTeamName("Croatia");

        Team serbia = new Team();
        serbia.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        serbia.setAbbreviation("SER");
        serbia.setTeamName("Serbia");

        Team denmark = new Team();
        denmark.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        denmark.setAbbreviation("DEN");
        denmark.setTeamName("Denmark");

        Team netherlands = new Team();
        netherlands.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        netherlands.setAbbreviation("NED");
        netherlands.setTeamName("Netherlands");

        Team belgium = new Team();
        belgium.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        belgium.setAbbreviation("BEL");
        belgium.setTeamName("Belgium");

        Team sweden = new Team();
        sweden.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        sweden.setAbbreviation("SWE");
        sweden.setTeamName("Sweden");


        Team portugal = new Team();
        portugal.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        portugal.setAbbreviation("POR");
        portugal.setTeamName("Portugal");

        Team switzerland = new Team();
        switzerland.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        switzerland.setAbbreviation("SWI");
        switzerland.setTeamName("Switzerland");

        Team turkey = new Team();
        turkey.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        turkey.setAbbreviation("TUR");
        turkey.setTeamName("Turkey");

        Team norway = new Team();
        norway.setConfederation(FXCollections.observableList(confederationManager.getAll()).get(5));
        norway.setAbbreviation("NOR");
        norway.setTeamName("Norway");


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

        listView.getItems().add(algeria);
        listView.getItems().add(angola);
        listView.getItems().add(senegal);
        listView.getItems().add(tunisia);
        listView.getItems().add(ivoryCoast);
        listView.getItems().add(ghana);
        listView.getItems().add(nigeria);
        listView.getItems().add(morocco);
        listView.getItems().add(cameroon);

        listView.getItems().add(argentina);
        listView.getItems().add(brazil);
        listView.getItems().add(colombia);
        listView.getItems().add(uruguay);
        listView.getItems().add(paraguay);
        listView.getItems().add(peru);
        listView.getItems().add(chile);

        listView.getItems().add(newZealand);

        listView.getItems().add(germany);
        listView.getItems().add(netherlands);
        listView.getItems().add(belgium);
        listView.getItems().add(england);
        listView.getItems().add(BiH);
        listView.getItems().add(croatia);
        listView.getItems().add(denmark);
        listView.getItems().add(serbia);
        listView.getItems().add(sweden);
        listView.getItems().add(switzerland);
        listView.getItems().add(spain);
        listView.getItems().add(portugal);
        listView.getItems().add(norway);
        listView.getItems().add(italy);
        listView.getItems().add(france);
        listView.getItems().add(turkey);



        for (int i = 0; i < DaoFactory.finalistDao().getAll().size(); i++){
            listView.getItems().add(DaoFactory.finalistDao().getAll().get(i).getTeam());
        }
    }


}
