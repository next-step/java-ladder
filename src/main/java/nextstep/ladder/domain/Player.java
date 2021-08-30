package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private static final int NAME_LENGTH = 5;
    private final String name;

    public Player(final String name) {
        if (name.length() > NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름은 최소 1글자, 최대 5글자 입니다.");
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
        return Objects.hash(name);
    }
}
