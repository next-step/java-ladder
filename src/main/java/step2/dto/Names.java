package step2.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(String[] names) {
        this.names = Arrays.stream(names)
                .map(n -> new Name(n))
                .collect(Collectors.toList());
    }

    public Names(List<Name> names) {
        this.names = names;
    }

    public List<String> names() {
        return this.names.stream()
                .map(n -> new Name(n))
                .map(name -> name.toString())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Names)) return false;
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    @Override
    public String toString() {
        return "Names{" +
                "names=" + names +
                '}';
    }
}
