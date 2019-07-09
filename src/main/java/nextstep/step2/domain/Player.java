package nextstep.step2.domain;

import java.util.List;
import java.util.Objects;

public class Player {
    private final static int NAME_MAX_LENGTH = 5;
    private final Integer startPoint;
    private final String name;

    public Player(int startPoint, String name) {
        validateStartPoint(startPoint);
        validateNameSize(name);
        this.startPoint = startPoint;
        this.name = name;
    }

    public Player(Player player) {
        this(player.startPoint, player.name);
    }

    public Result getPlayerReward(final GameResults gameResults, List<Line> lines) {
        var position = getStartPoint();
        for (Line line : lines) {
            final var point = line.getPoint(position);
            position = point.move();
        }

        return gameResults.findByPosition(position);
    }

    private void validateStartPoint(final int startPoint) {
        if (startPoint < 0) {
            throw new IllegalArgumentException("사다리 게임의 시작 지점은 0부터 입니다.");
        }
    }

    private void validateNameSize(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Player 이름이 비었습니다.");
        }

        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Player 의 이름은 " + NAME_MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    public Integer getStartPoint() {
        return startPoint;
    }

    public boolean equalsName(final String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
