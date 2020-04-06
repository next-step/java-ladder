package ladder.domain;

import ladder.exception.InvalidNameException;
import ladder.exception.NameLengthOutOfBoundException;

import java.util.Objects;

public class Player {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private final Position position;

    public Player(final String name, final int startPosition) {
        validName(name);
        validNameLength(name);
        this.name = name;
        this.position = new Position(startPosition);
    }

    public String getName() {
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
        final Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
