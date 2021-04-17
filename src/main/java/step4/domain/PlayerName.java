package step4.domain;

import java.util.Objects;

import step4.exception.MaximumNameLengthException;
import step4.exception.MinimumNameLengthException;

public class PlayerName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String playerName;

    public PlayerName(String playerName) {
        this.playerName = validate(playerName.trim());
    }

    private String validate(String playerName) {
        if (playerName == null || playerName.isEmpty()) {
            throw new MinimumNameLengthException("이름의 길이가 유효하지 않습니다.");
        }
        if (playerName.length() > MAX_NAME_LENGTH) {
            throw new MaximumNameLengthException("참여자의 이름은 최대 5글자 이하입니다.");
        }
        return playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PlayerName that = (PlayerName)o;
        return Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }

    @Override
    public String toString() {
        return playerName;
    }
}
