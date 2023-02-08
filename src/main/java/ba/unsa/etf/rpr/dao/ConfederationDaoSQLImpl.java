package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class where DaoSQLImplementation is written for domain class Confederation
 * @author muhamed-droid
 */

public class ConfederationDaoSQLImpl extends AbstractDao<Confederation> implements ConfederationDao {

    private static  ConfederationDaoSQLImpl instance = null;

    /**
     * constructor that calls super constructor
     * @author muhamed-droid
     */

    public ConfederationDaoSQLImpl() {
        super("confederations");
    }


    /**
     * no params
     * @return instance of ConfederationDaoSQLImpl
     * @author muhamed-droid
     */
    public static ConfederationDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ConfederationDaoSQLImpl();
        return instance;
    }

    /**
     * Method for removing Instance
     * void function
     * @author muhamed-droid
     */
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