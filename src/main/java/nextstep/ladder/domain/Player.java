package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    public static final int MAX_LENGTH = 5;
    public static final int MIN_LENGTH = 1;
    private final String name;

    private Player(String name) {
        validPlayerNameLength(name);
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(name);
    }

    private void validPlayerNameLength(String name) {
        if (name == null || name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("Player 이름은 공백 혹은 NULL이 될 수 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Player 이름은 " + MAX_LENGTH + "글자가 넘으면 안됩니다. 현재 : " + name.length() + "글자");
        }
    }

    @Override
    public String toString() {
        return String.format("%5s", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
