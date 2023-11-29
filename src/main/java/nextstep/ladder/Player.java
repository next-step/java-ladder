package nextstep.ladder;

import java.util.Objects;

public class Player {

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player from(String name) {
        if (5 < name.length()) {
            throw new IllegalArgumentException("사용자 이름은 5글자를 넘어가면 안됩니다.");
        }
        return new Player(name);
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
