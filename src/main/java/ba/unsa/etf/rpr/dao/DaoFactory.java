package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final ConfederationDao confederationDao = ConfederationDaoSQLImpl.getInstance();
    private static final GroupDao groupDao = GroupDaoSQLImpl.getInstance();
    private static final TableDao tableDao = TableDaoSQLImpl.getInstance();
    private static final TeamDao teamDao = TeamDaoSQLImpl.getInstance();

    private DaoFactory(){
    }

    public static ConfederationDao confederationDao(){
        return confederationDao;
    }

    public static GroupDao groupDao(){
        return groupDao;
    }

    public static TeamDao teamDao(){
        return teamDao;
    }

    public static TableDao tableDao(){
        return tableDao;
    }
}
