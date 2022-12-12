package ba.unsa.etf.rpr;

import java.util.Objects;

public class Table {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table tables = (Table) o;
        return id == tables.id;
    }

    @Override
    public String toString() {
        StringBuilder povratni = new StringBuilder();
        povratni.append(id);
        return String.valueOf(povratni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
