package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;

import java.util.Objects;

import static nextstep.ladder.exception.LadderExceptionMessage.CHECK_NAME_LENGTH;

public class Player {
    private static final int NAME_LENGTH_MIN = 5;

    private final String name;

    public Player(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_LENGTH_MIN) {
            throw new LadderException(CHECK_NAME_LENGTH);
        }
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
