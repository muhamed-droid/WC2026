package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDaoSQLImpl implements TeamDao{

    private Connection connection;

    public TeamDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Team getById(int id) {
        String query = "SELECT * FROM quotes WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Team team = new Team();
                team.setId(rs.getInt("id"));
                team.setTeamName(rs.getString("team_name"));
                team.setAbbreviation(rs.getString("abbreviation"));
                team.setGroupId(rs.getInt("group_id"));
                team.setConfederationId(rs.getInt("confederation_id"));
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
     * @param id for searching category for quotes
     * @return specific Category for specific quote from db
     * @author ahajro2
     */

    public Team returnTeamForId(int id) {
        String query = "SELECT * FROM categories WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Team t = new Team();
                t.setId(rs.getInt(1));
                t.setTeamName(rs.getString(2));
                t.setAbbreviation(rs.getString(3));
                t.setGroupId(rs.getInt(4));
                t.setConfederationId(rs.getInt(5));
                return t;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param text search string for quotes
     * @return list of quotes
     * @author ahajro2
     */

    @Override
    public List<Team> searchByText(String text) {
        //mora sa concat jer inace nece raditi jer radi sa key chars
        String query = "SELECT * FROM quotes WHERE quote LIKE concat('%', ?, '%')";
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
                t.setGroupId(rs.getInt(4));
                t.setConfederationId(rs.getInt(5));
                teamLista.add(t);
            }
            return teamLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param team search string for quotes
     * @return list of quotes
     * @author ahajro2
     */

    @Override
    public List<Team> searchByTeam(Team team) {
        String query = "SELECT * FROM quotes WHERE team = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, team.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Team> teamLista = new ArrayList<>();
            while (rs.next()) {
                Team t = new Team();
                t.setId(rs.getInt(1));
                t.setTeamName(rs.getString(2));
                t.setAbbreviation(rs.getString(3));
                t.setGroupId(rs.getInt(4));
                t.setConfederationId(rs.getInt(5));
                teamLista.add(t);
            }
            return teamLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
