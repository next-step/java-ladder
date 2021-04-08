package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private static final String NAME_VALIDATE_MESSAGE = "이름은 1글자 이상, 5글자 이하입니다";
    private static final int NAME_LENGTH_BOUND = 5;
    private static final String NAME_OUTPUT_FORMAT = "%5s";

    private final String name;

    public Player(final String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (name.trim().isEmpty() || name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException(NAME_VALIDATE_MESSAGE);
        }
    }

    public String getName() {
        return String.format(NAME_OUTPUT_FORMAT, this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
