package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Names {
    private final List<String> names;
    private static final int MAX_NAME_LENGTH = 5;

    public Names(String... names) {
        this(Arrays.asList(names));
    }

    public Names(List<String> names) {
        validateNameMaxLength(names);
        this.names = List.copyOf(names);
    }

    private void validateNameMaxLength(List<String> names) {
        if (names.stream().anyMatch(name -> name.length() > MAX_NAME_LENGTH))
            throw new IllegalArgumentException("The name should be up to 5 letters.");
    }

    public String get(int index) {
        return names.get(index);
    }

    public List<String> getAll() {
        return names;
    }

    public int connectSize() {
        return names.size() - 1;
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
        return Objects.hashCode(names);
    }
}
