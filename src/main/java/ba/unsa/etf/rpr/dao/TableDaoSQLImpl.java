package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Table;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class TableDaoSQLImpl extends AbstractDao<Table> implements TableDao {

    /**
     * @param id for searching table for specific id
     * @return specific table for id from db
     * @author muhamed-droid
     */


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
