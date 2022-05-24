package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

import java.util.List;
import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public static Coordinate of(int x, int y) {
        validate(x, y);
        return new Coordinate(x,y);
    }

    private static void validate(int x, int y) {
        if (negativeNumber(x, y)) {
            throw new LadderException(LadderExceptionCode.INVALID_COORDINATE_FORMAT);
        }
    }

    private static boolean negativeNumber(int x, int y) {
        return x < 0 || y < 0;
    }

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(List<Line> lines) {
        // TODO(jack.comeback) : 이 검증은 Ladder에 맡기기?
        if (leftBarMovable(lines) && rightBarMovable(lines))  {
            throw new LadderException(LadderExceptionCode.INVALID_LADDER_FORMAT);
        }

        if (leftBarMovable(lines)) {
            x -= 1;
            y += 1;
        }

        else if (rightBarMovable(lines)) {
            x += 1;
            y += 1;
        }

        else {
            y += 1;
        }
    }

    private boolean rightBarMovable(List<Line> lines) {
        return x < lines.size() && lines.get(x).bar(y);
    }

    private boolean leftBarMovable(List<Line> lines) {
        return x - 1 >= 0 && lines.get(x - 1).bar(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean done(int lineLength) {
        return y >= lineLength;
    }

    public int x() {
        return x;
    }
}
