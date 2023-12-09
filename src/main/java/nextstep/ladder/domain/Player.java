package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    public static final Player NONE = new Player("None");
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        checkNameLengthIsValid(name);
    }

    private void checkNameLengthIsValid(String name) {
        if (name == null || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("이름 길이는 %d ~ %d 사이어야 합니다.", MIN_LENGTH, MAX_LENGTH)
            );
        }
    }

    public boolean isSame(String inputPlayer) {
        return this.name.equals(inputPlayer);
    }

    @Override
    public String toString() {
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
