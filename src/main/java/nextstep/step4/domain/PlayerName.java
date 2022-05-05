package nextstep.step4.domain;

import java.util.Objects;

public class PlayerName {

    private static final int MAXIMUM_PLAYER_NAME_LENGTH = 5;

    private final String playerName;

    private PlayerName(String playerName) {
        if (isNullOrEmpty(playerName)) {
            throw new IllegalArgumentException("참여자의 이름은 공백일 수 없습니다.");
        }

        if (tooLongPlayerName(playerName)) {
            throw new IllegalArgumentException("참여자의 이름은 최대 5글자 입니다. 입력하신 이름 : " + playerName);
        }

        this.playerName = playerName;
    }

    private boolean isNullOrEmpty(String playerName) {
        return playerName == null || playerName.isEmpty();
    }

    private boolean tooLongPlayerName(String playerName) {
        return playerName.length() > MAXIMUM_PLAYER_NAME_LENGTH;
    }

    public static PlayerName from(String playerName) {
        return new PlayerName(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
