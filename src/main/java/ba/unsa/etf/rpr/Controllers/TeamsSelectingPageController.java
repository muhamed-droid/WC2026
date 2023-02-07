package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Business.ConfederationManager;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Team;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class TeamsSelectingPageController {

    @FXML
    private ChoiceBox<Confederation> choiceBox1 = new ChoiceBox<Confederation>();

    @FXML
    private ChoiceBox<Team> choiceBox2 = new ChoiceBox<>();

    @FXML
    public void initialize() {



        ConfederationManager confederationManager = new ConfederationManager();

        choiceBox1.setValue(FXCollections.observableList(confederationManager.getAll()).get(0));
        choiceBox1.setItems(FXCollections.observableList(confederationManager.getAll()));
        //choiceBox1.setValue();

    }

}
