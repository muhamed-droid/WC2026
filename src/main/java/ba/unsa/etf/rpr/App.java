
package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.dao.ConfederationDaoSQLImpl;
import ba.unsa.etf.rpr.dao.TeamDao;
import ba.unsa.etf.rpr.dao.TeamDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Confederation;
import ba.unsa.etf.rpr.domain.Team;

import java.util.ArrayList;

/**
 * Writing all teams by confederations
 */
        public class App {
            public static void main(String[] args) {

                //initialization of dao objects
                TeamDao dao = new TeamDaoSQLImpl();
                ConfederationDaoSQLImpl dao1 = new ConfederationDaoSQLImpl();

                //list of confederations
                ArrayList<Confederation> confederations = new ArrayList<Confederation>();

                //adding confederations from database to list
                for(int i = 0; i<6; i++){
                    confederations.add(dao1.getById(i+1));
                }

                //writing teams
                for(Confederation c : confederations){
                    ArrayList<Team> teamsByConfederation = new ArrayList<Team>(dao.searchByConfederation(c));
                    int i=1;
                    System.out.println(c);
                    for(Team t : teamsByConfederation){
                        System.out.println(i + ". " + t);
                        i++;
                    }
                }

            }
        }
