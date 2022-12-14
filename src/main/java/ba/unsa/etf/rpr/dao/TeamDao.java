package ba.unsa.etf.rpr.dao;



import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Group;
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
     * @param confederation search string for quotes
     * @return list of quotes
     */
    List<Team> searchByConfederation(Confederation confederation);

    /**
     * Returns all quotes that contains given text.
     *
     * @param group search string for quotes
     * @return list of quotes
     */
    List<Team> searchByGroup(Group group);
}