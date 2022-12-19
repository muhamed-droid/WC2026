package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.dao.TableDao;
import ba.unsa.etf.rpr.domain.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableDaoSQLImpl implements TableDao {
    private Connection connection;

    public TableDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Table getById(int id) {
        String query = "SELECT * FROM quotes WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Table table = new Table();
                table.setId(rs.getInt("id"));
                rs.close();
                return table;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }


    @Override
    public Table add(Table item) {
        return null;
    }


    @Override
    public Table update(Table item) {
        return null;
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public List<Table> getAll() {
        return null;
    }

    /**
     * @param id for searching category for quotes
     * @return specific Category for specific quote from db
     * @author ahajro2
     */

    public Table returnTableForId(int id) {
        String query = "SELECT * FROM categories WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Table t = new Table();
                t.setId(rs.getInt(1));
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

    /*@Override
    public List<Table> searchByText(String text) {
        //mora sa concat jer inace nece raditi jer radi sa key chars
        String query = "SELECT * FROM quotes WHERE quote LIKE concat('%', ?, '%')";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, text);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Table> tableLista = new ArrayList<>();
            while (rs.next()) {
                Table t = new Table();
                t.setId(rs.getInt(1));
                tableLista.add(t);
            }
            return tableLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } */


    /**
     * @param table search string for quotes
     * @return list of quotes
     * @author ahajro2
     */

    /*@Override
    public List<Table> searchByTable(Table table) {
        String query = "SELECT * FROM quotes WHERE table = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, table.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Table> tableLista = new ArrayList<>();
            while (rs.next()) {
                Table t = new Table();
                t.setId(rs.getInt(1));
                tableLista.add(t);
            }
            return tableLista;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } */
}
