package ba.unsa.etf.rpr.domain;

import java.util.ArrayList;

public class Tournament {

    private static Tournament worldCup =  new Tournament();

    private Tournament() {}

    public static Tournament getInstance()
    {
        return worldCup;
    }

    private  ArrayList<Team> teams;

    public void addTeam(Team t){
        teams.add(t);
    }

    public ArrayList<Team> getAll() {
        return teams;
    }
}
