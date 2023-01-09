package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.domain.Table;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TableDaoSQLImpl extends AbstractDao<Table> implements TableDao {
    /*private Connection connection;

    public TableDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_WC2026Base", "freedb_Muhamed-droid", "S#A2S3ceg*ReKGP");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Table getById(int id) {
        String query = "SELECT * FROM tables WHERE id = ?";
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
        //I will add something here
    }

    @Override
    public List<Table> getAll() {
        return Collections.emptyList();
    } */

    /**
     * @param id for searching table for specific id
     * @return specific table for id from db
     * @author muhamed-droid
     */

    /*public Table returnTableForId(int id) {
        String query = "SELECT * FROM tables WHERE id = ?";
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
    } */

    private static  TableDaoSQLImpl instance = null;
    public TableDaoSQLImpl() {
        super("tables");
    }

    public static TableDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new TableDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Table row2object(ResultSet rs) throws MyException {
        try {
            Table table = new Table();
            table.setId(rs.getInt("id"));
            return table;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Table object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        return row;
    }



}
