
package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.dao.TeamDao;
import ba.unsa.etf.rpr.dao.TeamDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Table;
import ba.unsa.etf.rpr.domain.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Hello world!
 * comment by dino
 * saso mange
 */
        public class App {
            public static void main(String[] args) {
//    {
//        CategoryDao dao = new CategoryDaoSQLImpl();
//
//
//        List<Category> categories = dao.getAll();
//        System.out.println(categories);
//
//        Category c2 = new Category();
//        c2.setId(2);
//        c2.setName("Courage");
//        dao.delete(2);
//        categories = dao.getAll();
//        System.out.println(categories);
//    }

                TeamDao dao = new TeamDaoSQLImpl() ;

                Confederation confederation = new Confederation();
                confederation.setId(1);
                confederation.setAbbreviation("UEFA");
                confederation.setFullName("The Union of European Football Associations");
                ArrayList<Team> teamsByConfederation = new ArrayList<Team>(dao.searchByConfederation(confederation));
                System.out.println("Treba ispisati 2 konfedera po ovoj kategoriji: ");
                //teamsByConfederation.forEach(q -> System.out.println(q.getTeamName()));


                System.out.println("\n Jedan quote sa inside word \"gora\": ");
                //ArrayList<Quote> quotes = new ArrayList<Quote>(dao.searchByText("gora"));
                //for (Quote q : quotes) {
                  //  System.out.println(q.getQuote());
                //}
            }
        }
