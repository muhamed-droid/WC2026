package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Business.ConfederationManager;
import ba.unsa.etf.rpr.domain.Finalist;
import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.domain.Team;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class GroupsMakingPageController {

    @FXML
    private ChoiceBox<Team> choiceBox1 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<Group> choiceBox2 = new ChoiceBox<>();

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


        choiceBox1.getItems().add(canada);
        choiceBox1.getItems().add(mexico);
        choiceBox1.getItems().add(usa);
        choiceBox1.getItems().add(jamaica);
        choiceBox1.getItems().add(panama);
        choiceBox1.getItems().add(honduras);
        choiceBox1.getItems().add(panama);

        choiceBox1.getItems().add(japan);
        choiceBox1.getItems().add(australia);
        choiceBox1.getItems().add(iran);
        choiceBox1.getItems().add(saudiArabia);
        choiceBox1.getItems().add(uae);
        choiceBox1.getItems().add(qatar);
        choiceBox1.getItems().add(southKorea);
        choiceBox1.getItems().add(china);

        choiceBox1.getItems().add(algeria);
        choiceBox1.getItems().add(angola);
        choiceBox1.getItems().add(senegal);
        choiceBox1.getItems().add(tunisia);
        choiceBox1.getItems().add(ivoryCoast);
        choiceBox1.getItems().add(ghana);
        choiceBox1.getItems().add(nigeria);
        choiceBox1.getItems().add(morocco);
        choiceBox1.getItems().add(cameroon);

        choiceBox1.getItems().add(argentina);
        choiceBox1.getItems().add(brazil);
        choiceBox1.getItems().add(colombia);
        choiceBox1.getItems().add(uruguay);
        choiceBox1.getItems().add(paraguay);
        choiceBox1.getItems().add(peru);
        choiceBox1.getItems().add(chile);

        choiceBox1.getItems().add(newZealand);

        choiceBox1.getItems().add(germany);
        choiceBox1.getItems().add(netherlands);
        choiceBox1.getItems().add(belgium);
        choiceBox1.getItems().add(england);
        choiceBox1.getItems().add(BiH);
        choiceBox1.getItems().add(croatia);
        choiceBox1.getItems().add(denmark);
        choiceBox1.getItems().add(serbia);
        choiceBox1.getItems().add(sweden);
        choiceBox1.getItems().add(switzerland);
        choiceBox1.getItems().add(spain);
        choiceBox1.getItems().add(portugal);
        choiceBox1.getItems().add(norway);
        choiceBox1.getItems().add(italy);
        choiceBox1.getItems().add(france);
        choiceBox1.getItems().add(turkey);

        Group g1 = new Group();
        g1.setId(1);
        Group g2 = new Group();
        g2.setId(2);
        Group g3 = new Group();
        g3.setId(3);
        Group g4 = new Group();
        g4.setId(4);
        Group g5 = new Group();
        g5.setId(5);
        Group g6 = new Group();
        g6.setId(6);
        Group g7 = new Group();
        g7.setId(7);
        Group g8 = new Group();
        g8.setId(8);
        Group g9 = new Group();
        g9.setId(9);
        Group g10 = new Group();
        g10.setId(10);
        Group g11 = new Group();
        g11.setId(11);
        Group g12 = new Group();
        g12.setId(12);
        Group g13 = new Group();
        g13.setId(13);
        Group g14 = new Group();
        g14.setId(14);
        Group g15 = new Group();
        g15.setId(15);
        Group g16 = new Group();
        g16.setId(16);


        choiceBox2.getItems().add(g1);
        choiceBox2.getItems().add(g2);
        choiceBox2.getItems().add(g3);
        choiceBox2.getItems().add(g4);

        choiceBox2.getItems().add(g5);
        choiceBox2.getItems().add(g6);
        choiceBox2.getItems().add(g7);
        choiceBox2.getItems().add(g8);

        choiceBox2.getItems().add(g9);
        choiceBox2.getItems().add(g10);
        choiceBox2.getItems().add(g11);
        choiceBox2.getItems().add(g12);

        choiceBox2.getItems().add(g13);
        choiceBox2.getItems().add(g14);
        choiceBox2.getItems().add(g15);
        choiceBox2.getItems().add(g16);

        pagination.setPageCount(16);
        pagination.setMaxPageIndicatorCount(16);

        pagination.setPageFactory((pageIndex) -> {

            Label label1 = new Label("Group  " + pageIndex + ": ");
            label1.setFont(new Font("Arial", 24));

            ArrayList<Finalist> list = new ArrayList<>();
            Label label2 = new Label("Main content of the page ...");

            return new VBox(label1, label2);
        });

    }


    public void onAddButtonClick(ActionEvent actionEvent) {
        choiceBox1.getValue().setGroup(choiceBox2.getValue());
    }
}
