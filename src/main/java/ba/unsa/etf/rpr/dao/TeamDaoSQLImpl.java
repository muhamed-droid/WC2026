package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.domain.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDaoSQLImpl implements TeamDao {

    private Connection connection;

    public TeamDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_WC2026Base", "freedb_Muhamed-droid", "S#A2S3ceg*ReKGP");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Team getById(int id) {
        String query = "SELECT * FROM teams WHERE id = ?";
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

    }

    @Override
    public List<Team> getAll() {
        return null;
    }

    /**
     * @param id for searching category for teams
     * @return specific Category for specific team from db
     * @author ahajro2
     */

    public Confederation returnConfederationForId(int id){
        String query = "SELECT * FROM categories WHERE id = ?";
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
    }

    public Group returnGroupForId(int id) {
        String query = "SELECT * FROM groups WHERE id = ?";
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
    }

    /**
     * @param text search string for teams
     * @return list of teams
     * @author ahajro2
     */

    @Override
    public List<Team> searchByText(String text) {
        //mora sa concat jer inace nece raditi jer radi sa key chars
        String query = "SELECT * FROM teams WHERE team LIKE concat('%', ?, '%')";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, text);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Team> teamLista = new ArrayList<>();
            while (rs.next()) {
                Team t = new Team();
                t.setId(rs.getInt(1));
                t.setTeamName(rs.getString(2));
                t.setAbbreviation(rs.getString(3));
                t.setGroup(returnGroupForId(rs.getInt(4)));
                t.setConfederation(returnConfederationForId(rs.getInt(5)));
                teamLista.add(t);
            }
            return teamLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param confederation search string for teams
     * @return list of teams
     * @author ahajro2
     */

    @Override
    public List<Team> searchByConfederation(Confederation confederation) {
        String query = "SELECT * FROM teams WHERE confederation_id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, confederation.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Team> teamLista = new ArrayList<>();
            while (rs.next()) {
                Team t = new Team();
                t.setId(rs.getInt(1));
                t.setTeamName((rs.getString(2)));
                t.setAbbreviation(rs.getString(3));
                //t.setGroup(returnGroupForId(rs.getInt(4)));
                t.setConfederation(confederation);
                teamLista.add(t);
            }
            return teamLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Team> searchByGroup(Group group) {
        String query = "SELECT * FROM teams WHERE group_id = " + group.getId();
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
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
        return null;
    }
}
