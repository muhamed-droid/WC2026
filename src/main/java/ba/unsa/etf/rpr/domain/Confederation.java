package ba.unsa.etf.rpr.domain;

import java.util.Objects;

public class Confederation implements Idable{
    private int id;
    private String fullName;
    private String abbreviation;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Confederation that = (Confederation) o;
        return id == that.id && Objects.equals(fullName, that.fullName) && Objects.equals(abbreviation, that.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, abbreviation);
    }

    @Override
    public String toString() {
        StringBuilder povratni = new StringBuilder();
        povratni.append(this.getAbbreviation());
        return String.valueOf(povratni);
    }

}

