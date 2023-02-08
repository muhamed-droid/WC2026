package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Finalist;
import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class FinalistDaoSQLImpl  extends AbstractDao<Finalist> implements FinalistDao{

    private static  GroupDaoSQLImpl instance = null;
    public FinalistDaoSQLImpl() {
        super("finalists");
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
    public Finalist row2object(ResultSet rs) throws MyException {
        try {
            Finalist finalist = new Finalist();
            finalist.setId(rs.getInt("id"));
            return finalist;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Finalist object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        return row;
    }

}
