package ba.unsa.etf.rpr.domain;

public class Team {
    private int id;
    private String teamName, abbreviation;
    int groupId, confederationId;

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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getConfederationId() {
        return confederationId;
    }

    public void setConfederationId(int confederationId) {
        this.confederationId = confederationId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


}
