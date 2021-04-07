package ladder.domain;

import java.util.Objects;

public class PlayerName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String playerName;

    public PlayerName(String playerName) {
        this.playerName = validate(playerName.trim());
    }

    private String validate(String playerName) {
        if (playerName == null || playerName.isEmpty() || playerName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("참여자의 이름은 최대 5글자 이하입니다.");
        }
        return playerName;
    }

    @Override
    public String toString() {
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
}
