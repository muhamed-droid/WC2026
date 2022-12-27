package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Group;

import java.sql.*;
import java.util.List;

public class GroupDaoSQLImpl implements GroupDao {

    private Connection connection;

    public GroupDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_WC2026Base", "freedb_Muhamed-droid", "S#A2S3ceg*ReKGP");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Group getById(int id) {
        String query = "SELECT * FROM groups WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Group group = new Group();
                group.setId(rs.getInt("id"));
                rs.close();
                return group;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }


    @Override
    public Group add(Group item) {
        return null;
    }


    @Override
    public Group update(Group item) {
        return null;
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public List<Group> getAll() {
        return null;
    }

    /**
     * @param id for searching
     * @return specific Group for specific id from db
     * @author muhamed-droid
     */

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

}
