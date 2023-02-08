package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.domain.Team;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.*;
import java.util.*;

public class TeamDaoSQLImpl extends AbstractDao<Team> implements TeamDao {

    /**
     * @param confederation search confederation for teams
     * @return list of teams
     * @author muhamed-droid
     */

    @Override
    public List<Team> searchByConfederation(Confederation confederation) {

        return executeQuery("SELECT * FROM teams WHERE confederation_id = ?", new Object[]{confederation.getId()});
    }

    /**
     * @param group search group for teams
     * @return list of teams
     * @author muhamed-droid
     */

    @Override
    public List<Team> searchByGroup(Group group) {

        return executeQuery("SELECT * FROM teams WHERE group_id = ?", new Object[]{group});
    }


    private static  TeamDaoSQLImpl instance = null;
    /**
     * @constructor that calles super
     *
     * @author muhamed-droid
     */
    public TeamDaoSQLImpl() {
        super("teams");
    }

    /**
     *
     * @return instance of TeamDaoSQLImpl
     * @author muhamed-droid
     */
    public static TeamDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new TeamDaoSQLImpl();
        return instance;
    }

    /**
     *
     * remove instance of TeamDaoSQLImpl
     * @author muhamed-droid
     */
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Team row2object(ResultSet rs) throws MyException {
        try {
            Team team = new Team();
            team.setId(rs.getInt("id"));
            team.setTeamName(rs.getString("team_name"));
            team.setAbbreviation(rs.getString("abbreviation"));
            team.setConfederation(DaoFactory.confederationDao().getById(rs.getInt("confederation_id")));
            return team;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Team object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("team_name", object.getTeamName());
        row.put("abbreviation", object.getAbbreviation());
        row.put("confederation_id", object.getConfederation().getId());
        return row;
    }

}
