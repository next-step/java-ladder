package ladder;

import java.text.MessageFormat;
import java.util.Objects;

public class Player {

    static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        validateNameIsNotNullOrBlank(name);
        validateNameNotExceedMaxLength(name);

        this.name = name;
    }

    private void validateNameIsNotNullOrBlank(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("플레이어의 이름은 null이거나 비어있을 수 없습니다. 이름: " + name);
        }
    }

    private void validateNameNotExceedMaxLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "플레이어의 이름은 {0}자를 초과할 수 없습니다. 이름 : {1}", MAXIMUM_NAME_LENGTH, name));
        }
    }

    @Override
    public boolean equals(final Object otherPlayer) {
        if (this == otherPlayer) {
            return true;
        }

        if (otherPlayer == null || getClass() != otherPlayer.getClass()) {
            return false;
        }

        final Player player = (Player)otherPlayer;

        return Objects.equals(this.name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
