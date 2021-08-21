package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_SIZE = 5;
    private final String value;

    public Player(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("사람 이름은 최대 5글자까지 입력 가능합니다.");
        }
        this.value = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(value, player.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
