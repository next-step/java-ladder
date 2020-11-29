package step04.domain;

import java.util.List;
import java.util.Objects;

public class Participants {
    private static final String ALL = "all";
    private final Names names;

    private Participants(Names names) {
        names.validateUnique();
        names.validateProhibitNames(ALL);
        this.names = names;
    }

    public static Participants of(String names) {
        return new Participants(Names.of(names));
    }

    public List<String> getNames() {
        return names.getNames();
    }

    public int size() {
        return names.size();
    }

    public int indexOf(String name) {
        return names.indexOf(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
