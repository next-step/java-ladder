package nextstep.ladder.domain.player;

import java.util.Objects;
import java.util.Optional;

public class Player {

    private static final int MAX_OF_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        int length = Optional.ofNullable(name)
            .map(String::trim)
            .map(String::length)
            .filter(integer -> integer > 0)
            .orElseThrow(() -> new IllegalArgumentException("name is empty"));

        if (length > MAX_OF_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
