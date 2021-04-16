package nextstep.ladder.domain;

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
}
