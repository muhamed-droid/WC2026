package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Group;
import ba.unsa.etf.rpr.exceptions.MyException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class GroupDaoSQLImpl extends AbstractDao<Group> implements GroupDao {





    private static  GroupDaoSQLImpl instance = null;

    /**
     * constructor that calls super
     *
     * @author muhamed-droid
     */
    public GroupDaoSQLImpl() {
        super("groups");
    }

    /**
     *
     * @return instance of GroupDaoSQLImpl
     * @author muhamed-droid
     */
    public static GroupDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new GroupDaoSQLImpl();
        return instance;
    }

    /**
     *
     * remove instance of GroupDaoSQLImpl
     * @author muhamed-droid
     */
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Group row2object(ResultSet rs) throws MyException {
        try {
            Group group = new Group();
            group.setId(rs.getInt("id"));
            return group;
        } catch (SQLException e) {
            throw new MyException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Group object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        return row;
    }

}
