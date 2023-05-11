package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {

    public static final String DELIMITER = ",";

    private final List<String> names;

    private Names(List<String> names) {
        this.names = names;
    }

    public static Names of(String names) {
        return of(Arrays.stream(splitString(names))
            .map(String::trim)
            .collect(Collectors.toList()));
    }

    private static String[] splitString(String names) {
        return names.split(DELIMITER);
    }

    public static Names of(List<String> names) {
        return new Names(names);
    }

    public List<String> names() {
        return List.copyOf(names);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    public int count() {
        return names.size();
    }

    public int properWidth() {
        return names.stream()
            .map(x -> x.length())
            .reduce(0, (a,b) -> a + b) / count();
    }

}
