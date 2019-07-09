package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    private Names(List<String> nameStrings) {
        this.names = nameStrings.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    public static Names of(String nameString) {
        List<String> names = Arrays.asList(nameString.split(","));
        return new Names(names);
    }

    public int size() {
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

    public int indexOf(String nameString) {
        return names.indexOf(new Name(nameString));
    }
}
