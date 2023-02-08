package ba.unsa.etf.rpr.Controllers;

import ba.unsa.etf.rpr.domain.Team;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;

public class GroupsMakingPageController {

    @FXML
    private ListView<Team> listView = new ListView<Team>();

    @FXML
    private Pagination pagination = new Pagination();




}
