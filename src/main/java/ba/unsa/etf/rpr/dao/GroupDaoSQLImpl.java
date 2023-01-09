package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GroupDaoSQLImpl extends AbstractDao<Group> implements GroupDao {

    /* private Connection connection;

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
        //I will add something here
    }

    @Override
    public List<Group> getAll() {
        return Collections.emptyList();
    }
*/
    /**
     * @param id for searching
     * @return specific Group for specific id from db
     * @author muhamed-droid
     */

   /* public Group returnGroupForId(int id) {
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
    } */

    private static  GroupDaoSQLImpl instance = null;
    public GroupDaoSQLImpl() {
        super("confederations");
    }

    public static GroupDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new GroupDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Group row2object(ResultSet rs) throws MyException {
        try {
            Group group = new Group();
            group.setId(rs.getInt("id"));
            return group;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Group object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        return row;
    }

}
