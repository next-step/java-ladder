package nextstep.ladder.model;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public String getNameFormatted() {
        return String.format("%6s", name);
    }

    public Boolean isEquals(String playerName) {
        return name.equals(playerName);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(this.name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
