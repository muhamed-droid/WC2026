package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.domain.Table;

import java.util.List;

public interface TableDao extends Dao<Table> {
    /**
     * Returns all groups that contains given text.
     *
     * @param text search string for groups
     * @return list of groups
     */
    //List<Table> searchByText(String text);

    /**
     * Returns all groups that contains given text.
     *
     * @param table search string for groups
     * @return list of groups
     */
    //List<Table> searchByTable(Table table);
}
