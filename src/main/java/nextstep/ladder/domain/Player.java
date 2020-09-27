package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    public static final int LENGTH_LIMIT = 5;

    private final String name;
    private Lane lane;

    private Player(String name, Lane lane) {
        this.name = name;
        this.lane = lane;
    }

    public static Player of(String name, Lane lane) {
        validateName(name);
        return new Player(name, lane);
    }

    private static void validateName(String name) {
        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 허용합니다.");
        }
    }

    public void move(Line line) {
        this.lane = lane.move(line);
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name) &&
                lane.equals(player.lane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lane);
    }

    @Override
    public String toString() {
        return name;
    }
}
