package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.Business.ConfederationManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Team;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;

import java.util.ArrayList;

public class GroupsMakingPageController {

    @FXML
    private ListView<Team> listView = new ListView<Team>();

    @FXML
    private Pagination pagination = new Pagination();

    @FXML
    public void initialize() {

        for (int i = 0; i < DaoFactory.finalistDao().getAll().size(); i++){
            listView.getItems().add(DaoFactory.finalistDao().getAll().get(i).getTeam());
        }
    }


}
