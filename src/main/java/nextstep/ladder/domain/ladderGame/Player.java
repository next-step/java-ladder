package nextstep.ladder.domain.ladderGame;

import java.util.Objects;

public class Player {
    private final String name;

    public Player(final String name) {
        verifyPlayerName(name);
        this.name = name;
    }

    private void verifyPlayerName(final String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름 값이 존재하지 않습니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("플레이어 이름 수는 5글자를 넘길 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player user = (Player) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
