package step2;

import java.util.Objects;

public class Player {

    private static final String NULL_PLAYER_MESSAGE = "참가자 명은 1자리 이상이어야 합니다.";
    private static final String MAXIMUM_PLAYER_MESSAGE = "참가자 명은 5자를 초과할 수 없습니다.";

    private String name;

    private Player(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NULL_PLAYER_MESSAGE);
        }

        if (name.trim().length() > 5) {
            throw new IllegalArgumentException(MAXIMUM_PLAYER_MESSAGE);
        }

        this.name = name;
    }

    public static Player newPlayer(String name) {
        return new Player(name);
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
