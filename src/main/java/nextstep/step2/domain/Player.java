package nextstep.step2.domain;

import java.util.Objects;

public class Player {
    private final static int NAME_MAX_LENGTH = 5;
    private final String name;

    public Player(String name) {
        validateNameSize(name);
        this.name = name;
    }

    public Player(Player player) {
        this(player.name);
    }

    private void validateNameSize(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Player 이름이 비었습니다.");
        }

        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Player 의 이름은 " + NAME_MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
