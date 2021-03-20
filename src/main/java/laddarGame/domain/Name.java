package laddarGame.domain;

import java.util.Objects;
import java.util.Optional;

public class Name {

    private String playerName;

    public Name(String playerName) {
        Optional.ofNullable(playerName)
                .filter(name -> name.length() < 6)
                .orElseThrow(() -> new IllegalArgumentException("플레이어 이름은 5글자를 초과할 수 없습니다."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(playerName, name.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
