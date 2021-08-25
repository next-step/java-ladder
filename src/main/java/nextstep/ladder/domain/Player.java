package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    public static final int MAX_LENGTH = 5;
    private final String name;

    private Player(String name) {
        validPlayerNameLength(name);
        this.name = name;
    }

    private void validPlayerNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Player 이름은 " + MAX_LENGTH + "글자가 넘으면 안됩니다. 현재 : " + name.length() + "글자");
        }
    }

    public static Player from(String name) {
        return new Player(name);
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
