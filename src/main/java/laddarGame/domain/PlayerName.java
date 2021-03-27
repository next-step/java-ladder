package laddarGame.domain;

import laddarGame.exception.OverMaxNameLengthException;

import java.util.Objects;
import java.util.Optional;

public class PlayerName {

    private final String playerName;

    private static final int MAX_NAME_LENGTH = 5;

    public PlayerName(String playerName) {
        this.playerName = Optional.ofNullable(playerName)
                .filter(name -> name.length() <= MAX_NAME_LENGTH)
                .orElseThrow(() -> new OverMaxNameLengthException("플레이어 이름은 5글자를 초과할 수 없습니다."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName name = (PlayerName) o;
        return Objects.equals(playerName, name.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }

    public String name() {
        return playerName;
    }
}
