package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Group;

import java.util.List;

public interface GroupDao extends Dao<Group> {
    /**
     * Returns all groups that contains given text.
     *
     * @param text search string for groups
     * @return list of groups
     */
    //List<Group> searchByText(String text);

    /**
     * Returns all groups that contains given text.
     *
     * @param group search string for groups
     * @return list of groups
     */
    //List<Group> searchByGroup(Group group);
}
