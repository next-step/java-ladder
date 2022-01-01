package nextstep.ladder.domain;

import java.util.Objects;

/**
 * @author han
 */
public class Name {

    private static final int MAXIMUM_SIZE = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        valid(name);
        return new Name(name);
    }

    private static void valid(String name) {
        if (name == null || name.isEmpty() || name.length() > MAXIMUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
