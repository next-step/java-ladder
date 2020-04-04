package ladder.domain;

import ladder.exception.PlayerException;

import java.util.Objects;

public class Player {

    private static final String NAME_LENGTH_ERR_MSG = "참가자의 이름은 5글자 이하여야 합니다.";

    private final String name;

    public Player(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() > 5) {
            throw new PlayerException(NAME_LENGTH_ERR_MSG);
        }
    }

    public String getName() {
        return name;
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
