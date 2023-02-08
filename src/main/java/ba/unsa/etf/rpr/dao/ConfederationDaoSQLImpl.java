package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ConfederationDaoSQLImpl extends AbstractDao<Confederation> implements ConfederationDao {

    /* private Connection connection;

    public ConfederationDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_WC2026Base", "freedb_Muhamed-droid", "S#A2S3ceg*ReKGP");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Confederation getById(int id) {
        String query = "SELECT * FROM confederations WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Confederation confederation = new Confederation();
                confederation.setId(rs.getInt("id"));
                confederation.setFullName(rs.getString("full_name"));
                confederation.setAbbreviation(rs.getString("abbreviation"));
                rs.close();
                return confederation;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }


    @Override
    public Confederation add(Confederation item) {
        String insert = "INSERT INTO confederations VALUES(?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getFullName());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            item.setId(rs.getInt(1)); //set id to return it back
            return item;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Confederation update(Confederation item) {
        String insert = "UPDATE confederations SET name = ? WHERE id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, item.getFullName());
            stmt.setObject(2, item.getAbbreviation());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void delete(int id) {
        //Something will be implemented here
    }

    @Override
    public List<Confederation> getAll() {
        //Something will be implemented here
        return Collections.emptyList();
    }
 */
    /**
     * @param id for searching
     * @return specific Confederation for specific id from db
     * @author muhamed-droid
     */

    /*public Confederation returnConfederationForId(int id) {
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
    }*/

    private static  ConfederationDaoSQLImpl instance = null;
    public ConfederationDaoSQLImpl() {
        super("confederations");
    }

    public static ConfederationDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ConfederationDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Confederation row2object(ResultSet rs) throws MyException {
        try {
            Confederation conf = new Confederation();
            conf.setId(rs.getInt("id"));
            conf.setFullName(rs.getString("full_name"));
            conf.setAbbreviation(rs.getString("abbreviation"));
            return conf;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Confederation object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("full_name", object.getFullName());
        row.put("abbreviation", object.getAbbreviation());

        return row;
    }
}