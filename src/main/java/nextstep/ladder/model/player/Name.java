package nextstep.ladder.model.player;

import nextstep.ladder.exception.NameLengthExceedException;

import java.util.Objects;
import java.util.Optional;

public class Name {

    private static final int MINIMUM_NAME_LENGTH = 0;
    private static final int MAXIMUM_NAME_LENGTH = 6;
    private static final String OUT_OF_LENGTH_MESSAGE = "이름의 길이를 초과했습니다. 이름은 최대 5자까지 허용합니다.";

    private final String value;

    private Name(String name) {
        this.value = verify(name);
    }

    private static String verify(String name) {
        return Optional.ofNullable(name)
                .filter(n -> MINIMUM_NAME_LENGTH < n.length())
                .filter(n -> n.length() < MAXIMUM_NAME_LENGTH)
                .orElseThrow(() -> new NameLengthExceedException(OUT_OF_LENGTH_MESSAGE));
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
