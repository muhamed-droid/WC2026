package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.domain.Team;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.*;
import java.util.*;

public class TeamDaoSQLImpl extends AbstractDao<Team> implements TeamDao {

    /*private Connection connection;
    private String query;

    //We make connections in constructor
    public TeamDaoSQLImpl(){
        try {
            query = "SELECT * FROM teams WHERE id = ?";
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_WC2026Base", "freedb_Muhamed-droid", "S#A2S3ceg*ReKGP");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Team getById(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Team team = new Team();
                team.setId(rs.getInt("id"));
                team.setTeamName(rs.getString("team_name"));
                team.setAbbreviation(rs.getString("abbreviation"));
                team.setGroup(returnGroupForId(rs.getInt("group_id")));
                team.setConfederation(returnConfederationForId(rs.getInt("confederation_id")));
                rs.close();
                return team;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }


    @Override
    public Team add(Team item) {
        return null;
    }


    @Override
    public Team update(Team item) {
        return null;
    }


    @Override
    public void delete(int id) {
        //I will do something here
    }

    @Override
    public List<Team> getAll() {
        return Collections.emptyList();
    } */

    /**
     * @param id for searching confederation for teams
     * @return specific Confederation for specific team from db
     * @author muhamed-droid
     */

    /*public Confederation returnConfederationForId(int id){
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Confederation c = new Confederation();
                c.setId(rs.getInt(1));
                c.setFullName(rs.getString(2));
                c.setAbbreviation(rs.getString(3));
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } */

    /**
     * @param id for searching group for teams
     * @return specific Group for specific team from db
     * @author muhamed-droid
     */

    /*public Group returnGroupForId(int id) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Group g = new Group();
                g.setId(rs.getInt(1));
                return g;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } */

    /**
     * @param confederation search confederation for teams
     * @return list of teams
     * @author muhamed-droid
     */

    @Override
    public List<Team> searchByConfederation(Confederation confederation) {
        //String q = "SELECT * FROM teams WHERE confederation_id = ?";

        return executeQuery("SELECT * FROM teams WHERE confederation_id = ?", new Object[]{confederation.getId()});

        /*try {
            PreparedStatement stmt = this.connection.prepareStatement(q);
            stmt.setInt(1, confederation.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Team> teamLista = new ArrayList<>();
            while (rs.next()) {
                Team t = new Team();
                t.setId(rs.getInt(1));
                t.setTeamName((rs.getString(2)));
                t.setAbbreviation(rs.getString(3));
                t.setConfederation(confederation);
                teamLista.add(t);
            }
            return teamLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList(); */
    }

    /**
     * @param group search group for teams
     * @return list of teams
     * @author muhamed-droid
     */

    @Override
    public List<Team> searchByGroup(Group group) {

        return executeQuery("SELECT * FROM teams WHERE group_id = ?", new Object[]{group});

        /*String q = "SELECT * FROM teams WHERE group_id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(q);
            stmt.setInt(1, group.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Team> teamLista = new ArrayList<>();
            while (rs.next()) {
                Team t = new Team();
                t.setId(rs.getInt(1));
                t.setTeamName((rs.getString(2)));
                t.setAbbreviation(rs.getString(3));
                t.setGroup(group);
                t.setConfederation(returnConfederationForId(rs.getInt(5)));
                teamLista.add(t);
            }
            return teamLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList(); */
    }

    @Override
    public List<Team> searchByName(String name) {
        //Treba implementirati searchByName
        return null;
    }

    private static  TeamDaoSQLImpl instance = null;
    public TeamDaoSQLImpl() {
        super("teams");
    }

    public static TeamDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new TeamDaoSQLImpl();
        return instance;
    }

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
        return row;
    }

}
