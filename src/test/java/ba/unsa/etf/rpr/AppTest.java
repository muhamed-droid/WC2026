package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.ConfederationDaoSQLImpl;
import ba.unsa.etf.rpr.dao.TeamDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Team;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void databaseConnectionTest1()
    {
        TeamDaoSQLImpl dao = new TeamDaoSQLImpl();
        ConfederationDaoSQLImpl dao1 = new ConfederationDaoSQLImpl();
        Confederation c = dao1.getById(5);
        ArrayList<Team> teamsByConfederation = new ArrayList<Team>(dao.searchByConfederation(c));
        Assertions.assertEquals(11, teamsByConfederation.size());
        Assertions.assertEquals("PNG", teamsByConfederation.get(5).getAbbreviation());
    }

    @Test
    public void databaseConnectionTest2()
    {
        TeamDaoSQLImpl dao = new TeamDaoSQLImpl();
        ConfederationDaoSQLImpl dao1 = new ConfederationDaoSQLImpl();
        Confederation c = dao1.getById(5);
        ArrayList<Team> teamsByConfederation = new ArrayList<Team>(dao.searchByConfederation(c));
        Assertions.assertEquals("PNG", teamsByConfederation.get(5).getAbbreviation());
    }

    @Test
    public void databaseConnectionTest3()
    {
        TeamDaoSQLImpl dao = new TeamDaoSQLImpl();
        ConfederationDaoSQLImpl dao1 = new ConfederationDaoSQLImpl();
        Confederation c = dao1.getById(5);
        Assertions.assertEquals("OFC", c.toString());
    }




}
