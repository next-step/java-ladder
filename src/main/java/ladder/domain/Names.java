package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Names {
    private final List<String> names;

    public Names(String... names) {
        this(Arrays.asList(names));
    }

    public Names(List<String> names) {
        this.names = names;
        validateNameMaxLength(names);
    }

    private void validateNameMaxLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > 5))
            throw new IllegalArgumentException("The name should be up to 5 letters.");
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(names);
    }

    public int connectSize() {
        return names.size() - 1;
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
        return Objects.hashCode(names);
    }
}
