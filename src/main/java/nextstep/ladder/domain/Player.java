package nextstep.ladder.domain;

import java.util.Objects;

public class Player {
    static final int PLAYER_NAME_MAX_LENGTH = 5;

    private final String name;
    private final Point point;

    public Player(String name, Point point) {
        if (name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("사람 이름은 최대 5글자까지 입력 가능합니다.");
        }
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public Player move(Point point) {
        return new Player(name, point);
    }

    public boolean isPlayerInPosition(Point at) {
        return point.equals(at);
    }

    public Point getPoint() {
        return point;
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
