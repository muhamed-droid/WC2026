package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.domain.Team;

import java.util.List;

/**
 * Dao interface for Team domain bean
 *
 * @author muhamed-droid
 */
public interface TeamDao extends Dao<Team> {


    /**
     * Returns all teams form specific confederation.
     *
     * @param confederation is given as specific confederation
     * @return list of teams
     */
    List<Team> searchByConfederation(Confederation confederation);

    /**
     * Returns all teams from specific group.
     *
     * @param group is given as specific group
     * @return list of teams
     */
    List<Team> searchByGroup(Group group);

}