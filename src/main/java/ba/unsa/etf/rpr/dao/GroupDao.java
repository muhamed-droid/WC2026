package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Group;

import java.util.List;

public interface GroupDao extends Dao<Group> {
    /**
     * Returns all quotes that contains given text.
     *
     * @param text search string for quotes
     * @return list of quotes
     */
    //List<Group> searchByText(String text);

    /**
     * Returns all quotes that contains given text.
     *
     * @param group search string for quotes
     * @return list of quotes
     */
    //List<Group> searchByGroup(Group group);
}
