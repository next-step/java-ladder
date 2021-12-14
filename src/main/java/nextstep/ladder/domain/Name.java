package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.InputNullPointerException;
import nextstep.ladder.exception.NameSizeOverBoundException;

public class Name {

    private static final int STRING_MAXIMUM_SIZE = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        valid(name);
        return new Name(name);
    }

    public int length() {
        return name.length();
    }

    private static void valid(String name) {
        if (name == null || name.isEmpty()) {
            throw new InputNullPointerException();
        }

        if (name.length() > STRING_MAXIMUM_SIZE) {
            throw new NameSizeOverBoundException(STRING_MAXIMUM_SIZE);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
