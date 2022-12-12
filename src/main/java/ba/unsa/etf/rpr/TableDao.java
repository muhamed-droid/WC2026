package ba.unsa.etf.rpr;

import jdk.jfr.Category;

import java.util.List;

public interface TableDao extends Dao<Table>{
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
    List<Table> searchByTable(Table table);
}
