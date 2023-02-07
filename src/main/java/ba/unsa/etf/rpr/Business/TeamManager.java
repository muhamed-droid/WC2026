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
    public List<Team> getAll() throws MyException {
        return DaoFactory.teamDao().getAll();
    }

    public List<Team> searchteams(String name) throws MyException {
        return DaoFactory.teamDao().searchByName(name);
    }

    public List<Team> searchTeamsInConfederation(Confederation con) throws MyException {
        return DaoFactory.teamDao().searchByConfederation(con);
    }

    public void delete(int id) throws MyException{
        DaoFactory.teamDao().delete(id);
    }

    public Team getById(int quoteId) throws MyException{
        return DaoFactory.teamDao().getById(quoteId);
    }

    public void update(Team t) throws MyException{
        DaoFactory.teamDao().update(t);
    }

    public Team add(Team t) throws MyException{
        return DaoFactory.teamDao().add(t);
    }

    /*public Team randomQuote() throws MyException{
        Team t = DaoFactory.teamDao().randomTeam();

        return t;
    }*/
}
