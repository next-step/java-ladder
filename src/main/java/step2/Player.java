package step2;

import java.util.Objects;

public class Player {

    private static final String NULL_PLAYER_MESSAGE = "참가자 명은 1자리 이상이어야 합니다.";
    private static final String MAXIMUM_PLAYER_MESSAGE = "참가자 명은 5자 이하이어야 합니다.";
    private static final int LIMIT_LENGTH = 5;

    private final String name;

    private Player(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException(NULL_PLAYER_MESSAGE);
        }

        if (name.trim().length() > LIMIT_LENGTH) {
            throw new IllegalArgumentException(MAXIMUM_PLAYER_MESSAGE);
        }
    }

    public static Player newPlayer(String name) {
        return new Player(name);
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
        return Objects.hash(name);
    }
}
