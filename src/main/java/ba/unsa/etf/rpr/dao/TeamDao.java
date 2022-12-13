package ba.unsa.etf.rpr.dao;



import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.domain.Team;

import java.util.List;

/**
 * Dao interface for Quote domain bean
 *
 * @author Dino Keco
 */
public interface TeamDao extends Dao<Team> {

    /**
     * Returns all quotes that contains given text.
     *
     * @param text search string for quotes
     * @return list of quotes
     */
    List<Team> searchByText(String text);

    /**
     * Returns all quotes that contains given text.
     *
     * @param team search string for quotes
     * @return list of quotes
     */
    List<Team> searchByTeam(Team team);
}