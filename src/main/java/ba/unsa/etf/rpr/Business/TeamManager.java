package ba.unsa.etf.rpr.Business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Team;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.util.List;

/**
 * Business Logic Layer for Teams
 *
 * @author Muhamed-droid
 */


public class TeamManager {
    /**
     *
     * @return list of teams
     * @throws MyException
     * @author Muhamed-droid
     */
    public List<Team> getAll() throws MyException {
        return DaoFactory.teamDao().getAll();
    }

    /**
     * @param con specifies Confederation
     * @return list of teams
     * @throws MyException
     * @author Muhamed-droid
     */
    public List<Team> searchTeamsInConfederation(Confederation con) throws MyException {
        return DaoFactory.teamDao().searchByConfederation(con);
    }

    /**
     * void function
     * @param id
     * @throws MyException
     * @author Muhamed-droid
     */
    public void delete(int id) throws MyException{
        DaoFactory.teamDao().delete(id);
    }

    /**
     * @return instance of Team
     * @param teamId
     * @throws MyException
     * @author Muhamed-droid
     */
    public Team getById(int teamId) throws MyException{
        return DaoFactory.teamDao().getById(teamId);
    }

    /**
     * void function
     * @param t, instance of team
     * @throws MyException
     * @author Muhamed-droid
     */
    public void update(Team t) throws MyException{
        DaoFactory.teamDao().update(t);
    }

    /**
     * @return Team, instance of team
     * @param t, instance of team
     * @throws MyException
     * @author Muhamed-droid
     */
    public Team add(Team t) throws MyException{
        return DaoFactory.teamDao().add(t);
    }
}
