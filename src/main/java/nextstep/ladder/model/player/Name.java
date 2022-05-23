package nextstep.ladder.model.player;

import nextstep.ladder.exception.NameLengthExceedException;

import java.util.Objects;
import java.util.Optional;

public class Name {

    private static final int MINIMUM_NAME_LENGTH = 0;
    private static final int MAXIMUM_NAME_LENGTH = 6;

    private final String value;

    private Name(String name) {
        this.value = verify(name);
    }

    private static String verify(String name) {
        return Optional.ofNullable(name)
                .filter(n -> MINIMUM_NAME_LENGTH < n.length())
                .filter(n -> n.length() < MAXIMUM_NAME_LENGTH)
                .orElseThrow(NameLengthExceedException::new);
    }

    public static Name of(String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return this.value;
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(this.value, name.value);
    }

    public boolean equals(String name) {
        return Objects.equals(this.value, name);
    }
}
