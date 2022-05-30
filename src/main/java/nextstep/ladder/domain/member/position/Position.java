package nextstep.ladder.domain.member.position;

import nextstep.ladder.domain.line.point.Points;
import nextstep.ladder.domain.runresult.RunResult;

import java.util.List;
import java.util.Objects;

public class Position {
    public static final int DEFAULT_POSITION = 0;

    private final PositionX x;
    private final PositionY y;

    public Position() {
        this(DEFAULT_POSITION, DEFAULT_POSITION);
    }

    public Position(int x) {
        this(x, DEFAULT_POSITION);
    }

    public Position(int x, int y) {
        this(new PositionX(x), new PositionY(y));
    }

    public Position(PositionX x, PositionY y) {
        this.x = x;
        this.y = y;
    }

    public void move(Points points) {
        this.x.increaseOrDecrease(points);
        this.y.increase();
    }

    public RunResult getMatchX(List<RunResult> runResults) {
        return this.x.getFrom(runResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) && Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
