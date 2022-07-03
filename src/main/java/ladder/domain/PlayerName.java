package ladder.domain;

import java.util.Objects;

public class PlayerName {
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String playerName;

    public PlayerName(String playerName) {
        if (playerName == null || playerName.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값을 입력 할 수 없습니다.");
        }

        if (playerName.length() < MINIMUM_NAME_LENGTH  || playerName.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MINIMUM_NAME_LENGTH + " ~ " + MAXIMUM_NAME_LENGTH + " 글자만 허용됩니다.");
        }

        this.playerName = playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerName that = (PlayerName) o;
        return Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }

    @Override
    public String toString() {
        return "" + playerName;
    }
}
