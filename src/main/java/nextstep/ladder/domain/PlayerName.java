package nextstep.ladder.domain;

import java.util.Objects;

public class PlayerName {
    public static final int LENGTH_LIMIT = 5;

    private final String name;

    private PlayerName(final String name) {
        this.name = name;
    }

    public static PlayerName of(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("invalid name: cannot be null or empty");
        }

        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("invalid name: too long " + name.length());
        }

        return new PlayerName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName name1 = (PlayerName) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
