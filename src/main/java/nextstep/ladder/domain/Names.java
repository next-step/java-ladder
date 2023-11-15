package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Names {
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = List.copyOf(names);
    }

    public List<Name> getAll() {
        return this.names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
