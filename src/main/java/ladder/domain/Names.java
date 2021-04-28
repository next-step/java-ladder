package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(String[] names) {
        this(
                Arrays.stream(names)
                        .map(Name::new)
                        .collect(Collectors.toList())
        );
    }

    public Names(List<Name> names) {
        this.names = names;
    }

    public List<Name> names() {
        return Collections.unmodifiableList(names);
    }

    public int count() {
        return names.size();
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
