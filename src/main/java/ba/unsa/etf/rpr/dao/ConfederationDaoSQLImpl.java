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
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Confederation getById(int id) {
        String query = "SELECT * FROM quotes WHERE id = ?";
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
        return null;
    }


    @Override
    public Confederation update(Confederation item) {
        return null;
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public List<Confederation> getAll() {
        return null;
    }

    /**
     * @param id for searching category for quotes
     * @return specific Category for specific quote from db
     * @author ahajro2
     */

    public Confederation returnCategoryForId(int id) {
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
     * @param text search string for quotes
     * @return list of quotes
     * @author ahajro2
     */

    @Override
    public List<Confederation> searchByText(String text) {
        //mora sa concat jer inace nece raditi jer radi sa key chars
        String query = "SELECT * FROM quotes WHERE quote LIKE concat('%', ?, '%')";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, text);
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
    }


    /**
     * @param confederation search string for quotes
     * @return list of quotes
     * @author ahajro2
     */

    /*@Override
    public List<Confederation> searchByConfederation(Confederation confederation) {
        String query = "SELECT * FROM quotes WHERE confederation = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, confederation.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Confederation> quoteLista = new ArrayList<>();
            while (rs.next()) {
                Confederation q = new Confederation();
                q.setId(rs.getInt(1));
                q.setFullName(rs.getString(2));
                q.setAbbreviation(rs.getString(3));
                quoteLista.add(q);
            }
            return quoteLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } */
}