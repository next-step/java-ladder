package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    private static final String CHECK_NAME_LENGTH = "이름이 5자를 초과하는지 확인해주세요.";
    private static final int NAME_LENGTH_MIN = 5;

    private final String name;

    public Player(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(CHECK_NAME_LENGTH);
        }
    }

    public String name() {
        return this.name;
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
