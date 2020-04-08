package ladder.domain;

import ladder.exception.InvalidNameException;
import ladder.exception.NameLengthOutOfBoundException;

import java.util.Objects;

public class PlayerName {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public PlayerName(final String name) {
        validName(name);
        validNameLength(name);
        this.name = name;
    }

    public String value() {
        return name;
    }

    private void validName(final String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new InvalidNameException(name);
        }
    }

    private void validNameLength(final String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new NameLengthOutOfBoundException(name);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
