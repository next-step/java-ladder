package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    private final String name;

    public Player(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 1 ~ 5자 사이여야 합니다.");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
