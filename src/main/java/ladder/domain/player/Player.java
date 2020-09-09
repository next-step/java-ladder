package ladder.domain.player;

import java.util.Objects;

import static java.util.Objects.isNull;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    public static final String MORE_THAN_SIZE_MESSAGE = "이름의 최대 글자수는 %d 입니다. : %s";
    public static final String NOT_EMPTY_NAME_MESSAGE = "이름의 값이 공백 또는 존재하지 않습니다.";

    private final String name;

    public Player(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }

    public boolean isMatchesName(String name) {
        return this.name.equals(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(MORE_THAN_SIZE_MESSAGE, MAX_NAME_LENGTH, name));
        }
    }

    private void validateEmpty(String name) {
        if (isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_NAME_MESSAGE);
        }
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
