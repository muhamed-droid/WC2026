
package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.dao.ConfederationDaoSQLImpl;
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

                TeamDao dao = new TeamDaoSQLImpl();
                ConfederationDaoSQLImpl dao1 = new ConfederationDaoSQLImpl();

                ArrayList<Confederation> confederations = new ArrayList<Confederation>();

                for(int i = 0; i<6; i++){
                    confederations.add(dao1.getById(i+1));
                }

                for(Confederation c : confederations){
                    ArrayList<Team> teamsByConfederation = new ArrayList<Team>(dao.searchByConfederation(c));
                    int i=1;
                    System.out.println(c);
                    for(Team t : teamsByConfederation){
                        System.out.println(i + " " + t.getTeamName());
                        i++;
                    }
                }



                //ArrayList<Quote> quotes = new ArrayList<Quote>(dao.searchByText("gora"));
                //for (Quote q : quotes) {
                  //  System.out.println(q.getQuote());
                //}
            }
        }
