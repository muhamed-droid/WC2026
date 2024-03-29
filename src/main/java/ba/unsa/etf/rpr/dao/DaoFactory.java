package ba.unsa.etf.rpr.dao;

/**
 * Implementation of design pattern
 * Working with daos in shadow
 *
 * @author muhamed-droid
 */

public class DaoFactory {
    private static final ConfederationDao confederationDao = ConfederationDaoSQLImpl.getInstance();
    private static final GroupDao groupDao = GroupDaoSQLImpl.getInstance();
    private static final TableDao tableDao = TableDaoSQLImpl.getInstance();
    private static final TeamDao teamDao = TeamDaoSQLImpl.getInstance();
    private static final FinalistDao finalistDao = FinalistDaoSQLImpl.getInstance();


    /**
     * @constructor wihout params
     *
     * @author muhamed-droid
     */
    private DaoFactory(){
    }


    /**
     *
     * @return ConfederationDao instance
     * @author muhamed-droid
     */
    public static ConfederationDao confederationDao(){
        return confederationDao;
    }


    /**
     *
     * @return GroupDao instance
     * @author muhamed-droid
     */
    public static GroupDao groupDao(){
        return groupDao;
    }

    /**
     *
     * @return TeamDao instance
     * @author muhamed-droid
     */
    public static TeamDao teamDao(){
        return teamDao;
    }

    /**
     *
     * @return TableDao instance
     * @author muhamed-droid
     */
    public static TableDao tableDao(){
        return tableDao;
    }

    /**
     *
     * @return FinalistDao instance
     * @author muhamed-droid
     */
    public static FinalistDao finalistDao() {return finalistDao;}

}
