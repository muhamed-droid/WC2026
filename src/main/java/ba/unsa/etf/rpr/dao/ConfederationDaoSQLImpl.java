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
     * @param id for searching category for confederations
     * @return specific Category for specific team from db
     * @author ahajro2
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

    /**
     * @param abbreviation search string for confederations
     * @return list of confederations
     * @author ahajro2
     */

    /*@Override
    public List<Confederation> searchByAbbreviation(String abbreviation) {
        String query = "SELECT * FROM confederations";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, abbreviation);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Confederation> confederationLista = new ArrayList<>();
            while (rs.next()) {
                Confederation q = new Confederation();
                q.setId(rs.getInt(1));
                q.setFullName(rs.getString(2));
                q.setAbbreviation(rs.getString(3));
                confederationLista.add(q);
            }
            return confederationLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } */


    /**
     * @param confederation search string for confederations
     * @return list of confederations
     * @author ahajro2
     */

    /*@Override
    public List<Confederation> searchByConfederation(Confederation confederation) {
        String query = "SELECT * FROM confederations WHERE confederation = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, confederation.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Confederation> teamLista = new ArrayList<>();
            while (rs.next()) {
                Confederation q = new Confederation();
                q.setId(rs.getInt(1));
                q.setFullName(rs.getString(2));
                q.setAbbreviation(rs.getString(3));
                teamLista.add(q);
            }
            return teamLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } */
}