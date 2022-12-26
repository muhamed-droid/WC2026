package ba.unsa.etf.rpr.dao;



import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.domain.Team;

import java.util.List;

/**
 * Dao interface for Team domain bean
 *
 * @author Dino Keco
 */
public interface TeamDao extends Dao<Team> {

    /**
     * Returns all teams that contains given text.
     *
     * @param text search string for teams
     * @return list of teams
     */
    List<Team> searchByText(String text);

    /**
     * Returns all teams that contains given text.
     *
     * @param confederation search string for teams
     * @return list of teams
     */
    List<Team> searchByConfederation(Confederation confederation);

    /**
     * Returns all teams that contains given text.
     *
     * @param group search string for teams
     * @return list of teams
     */
    List<Team> searchByGroup(Group group);
}