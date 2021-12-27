package ladderstep4.ladder.domain;

import java.util.Objects;

public class Player {
    public static final String INVALID_NAME_MESSAGE = "이름은 1~5글자입니다.";

    private static final int MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty() || name.trim().length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
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

        return name != null ? name.equals(player.name) : player.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
