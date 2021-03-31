package nextstep.ladder.domain;

import java.util.Objects;

public class Name {

    private static final int NAME_MAX_SIZE = 5;
    private final String name;

    public Name(final String name) {
        if(name.length() > NAME_MAX_SIZE) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 부여할 수 있습니다.");
        }
        this.name = name;
    }

    public static Name of(final String name) {
        return new Name(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
