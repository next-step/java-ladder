package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    private static final String NAME_OVER_LENGTH_ERROR_TEXT = "사람에 이름을 최대5글자까지 가능합니다.";
    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public Player(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_OVER_LENGTH_ERROR_TEXT);
        }
        this.name = name;
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
        return name != null ? name.hashCode() : 0;
    }

}
