package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = List.copyOf(names);
    }

    public static Names from(List<String> names) {
        return new Names(names.stream()
                .map(Name::new)
                .collect(Collectors.toList()));
    }

    public List<Name> getAll() {
        return this.names;
    }

    public int size() {
        return names.size();
    }

    public Name name(int index) {
        return this.names.get(index);
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
