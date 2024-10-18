package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    public static final int NAME_LIMIT = 5;

    private final String name;

    public Player(String name) {
        if (name.isBlank() || name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("참가자 이름은 1 ~ 5자 사이여야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
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
