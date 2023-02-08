package ba.unsa.etf.rpr.domain;

public class Finalist implements Idable{
    private int id;
    private Team team;

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
