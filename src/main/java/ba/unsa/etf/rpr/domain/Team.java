package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Team implements Idable{
    private int id;
    private String teamName;
    private String abbreviation;
    private Group group;
    private Confederation confederation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Confederation getConfederation() {
        return confederation;
    }

    public void setConfederation(Confederation confederation) {
        this.confederation = confederation;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, abbreviation, group, confederation);
    }

    @Override
    public String toString() {
        StringBuilder povratni = new StringBuilder();
        povratni.append(this.getTeamName());
        povratni.append(" (");
        povratni.append(this.getConfederation().getAbbreviation());
        povratni.append(") ");
        return String.valueOf(povratni);
    }
}
