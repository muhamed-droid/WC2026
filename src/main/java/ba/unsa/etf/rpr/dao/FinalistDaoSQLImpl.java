package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Finalist;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class FinalistDaoSQLImpl  extends AbstractDao<Finalist> implements FinalistDao{

    private static  FinalistDaoSQLImpl instance = null;

    /**
     * @constructor that calls super
     *
     * @author muhamed-droid
     */
    public FinalistDaoSQLImpl() {
        super("finalists");
    }

    /**
     *
     * @return instance of FinalistDaoSQLImpl
     *
     * @author muhamed-droid
     */

    public static FinalistDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new FinalistDaoSQLImpl();
        return instance;
    }

    /**
     *
     * @return void
     * It removes Instance
     *
     * @author muhamed-droid
     */
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Finalist row2object(ResultSet rs) throws MyException {
        try {
            Finalist finalist = new Finalist();
            finalist.setId(rs.getInt("id"));
            finalist.setTeam(DaoFactory.teamDao().getById(rs.getInt("team_id")));
            return finalist;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Finalist object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("team_id", object.getTeam().getId());
        return row;
    }

}
