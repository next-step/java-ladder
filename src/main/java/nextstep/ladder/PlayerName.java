package nextstep.ladder;

import java.util.Objects;

public class PlayerName {

    private static final int MAXIMUM_USER_NAME_LENGTH = 5;

    private final String playerName;

    public PlayerName(String playerName) {
        if (isEmptyOrNull(playerName)) {
            throw new IllegalArgumentException("사용자의 이름은 공백일 수 없습니다.");
        }
        if (isInvalidPlayerName(playerName)) {
            throw new IllegalArgumentException("사용자의 이름은 최대 5글자입니다. 입력 한 이름:" + playerName);
        }
        this.playerName = playerName;
    }

    private boolean isEmptyOrNull(String playerName) {
        return playerName == null || playerName.isEmpty();
    }

    private boolean isInvalidPlayerName(String playerName) {
        return playerName.length() > MAXIMUM_USER_NAME_LENGTH;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName playerName1 = (PlayerName) o;
        return Objects.equals(playerName, playerName1.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
