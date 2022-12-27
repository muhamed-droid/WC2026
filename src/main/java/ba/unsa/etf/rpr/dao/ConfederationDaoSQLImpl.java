package ba.unsa.etf.rpr.dao;



import ba.unsa.etf.rpr.dao.ConfederationDao;
import ba.unsa.etf.rpr.domain.Confederation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfederationDaoSQLImpl implements ConfederationDao {

    private Connection connection;

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
        String insert = "INSERT INTO confederations(abbreviation, fullName) VALUES(?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getFullName());
            stmt.setString(2, item.getAbbreviation());
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
            stmt.setObject(3, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public List<Confederation> getAll() {
        return null;
    }

    /**
     * @param id for searching
     * @return specific Confederation for specific id from db
     * @author muhamed-droid
     */

    public Confederation returnConfederationForId(int id) {
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
}