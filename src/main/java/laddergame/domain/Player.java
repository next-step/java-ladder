package laddergame.domain;

import java.util.Objects;

import static laddergame.domain.PlayersAndWinningContents.MAX_LENGTH_OF_PLAYER_AND_WINNING_CONTENT;
import static laddergame.exception.ExceptionMessage.WRONG_PLAYER_NAME_MESSAGE;
import static laddergame.util.Validator.isNonBlank;

public class Player {
    private final String name;

    private Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (!isNonBlank(name) || name.length() > MAX_LENGTH_OF_PLAYER_AND_WINNING_CONTENT) {
            throw new IllegalArgumentException(String.format(WRONG_PLAYER_NAME_MESSAGE.message(), name, MAX_LENGTH_OF_PLAYER_AND_WINNING_CONTENT));
        }
    }

    public static Player valueOf(String name) {
        return new Player(name);
    }

    public int lengthOfName() {
        return name.length();
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

    public String name() {
        return name;
    }
}
