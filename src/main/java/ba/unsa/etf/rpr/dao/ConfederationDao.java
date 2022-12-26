package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Confederation;

import java.util.List;

public interface ConfederationDao extends Dao<Confederation> {
    /**
     * Returns all confederations that contains given text.
     *
     * @param text search string for confederations
     * @return list of confederations
     */
    //List<Confederation> searchByAbbreviation(String text);

    /**
     * Returns all confederations that contains given text.
     *
     * @param confederation search string for confederations
     * @return list of confederations
     */
}
