package nextstep.ladder.domain.player;

import nextstep.ladder.domain.direction.Point;
import nextstep.ladder.domain.ladder.Ladder;

import java.util.Objects;

public class Player {

    public static final int NAME_LIMIT = 5;

    private final String name;
    private Point point;

    public Player(String name) {
        this(name, 0);
    }

    public Player(String name, int position) {
        if (name.isBlank() || name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("참가자 이름은 1 ~ 5자 사이여야 합니다.");
        }

        this.name = name;
        this.point = Point.from(position, 0);
    }

    public Player copy() {
        return new Player(name, point.getX());
    }

    public void play(Ladder ladder) {
        point = ladder.play(point);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return point.getX();
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
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
