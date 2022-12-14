package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.domain.Table;

import java.util.List;

public interface TableDao extends Dao<Table> {
    /**
     * Returns all quotes that contains given text.
     *
     * @param text search string for quotes
     * @return list of quotes
     */
    List<Table> searchByText(String text);

    /**
     * Returns all quotes that contains given text.
     *
     * @param table search string for quotes
     * @return list of quotes
     */
    //List<Table> searchByTable(Table table);
}
