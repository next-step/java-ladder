package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Player(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("게이머 이름이 없습니다.");
        }

        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(String.format("게이머 이름은 %s자를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }

        this.name = name;
    }

    String getName() {
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
