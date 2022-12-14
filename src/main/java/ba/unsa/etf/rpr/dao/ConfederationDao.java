package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Confederation;

import java.util.List;

public interface ConfederationDao extends Dao<Confederation> {
    /**
     * Returns all quotes that contains given text.
     *
     * @param text search string for quotes
     * @return list of quotes
     */
    List<Confederation> searchByText(String text);

    /**
     * Returns all quotes that contains given text.
     *
     * @param confederation search string for quotes
     * @return list of quotes
     */
    //List<Confederation> searchByConfederation(Confederation confederation);
}
