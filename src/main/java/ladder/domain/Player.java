package ladder.domain;

import ladder.exception.InvalidNameException;

import java.util.Objects;

public class Player {

    private static final Integer MAX_NAME_SIZE = 5;
    private static final String VALIDATE_NAME_MESSAGE = "참가자 이름은 5글자를 넘을 수 없습니다.";

    private final String name;

    public Player(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new InvalidNameException(VALIDATE_NAME_MESSAGE);
        }
        this.name = name;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player1 = (Player) o;
        return Objects.equals(name, player1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
