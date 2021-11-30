package nextstep.step2.vo;

import nextstep.step2.domain.Point;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public enum Bridge {
    DOWN((p) -> p),
    RIGHT((p) -> p.right()),
    LEFT((p) -> p.left());

    private final UnaryOperator<Point> op;

    Bridge(UnaryOperator<Point> op) {
        this.op = op;
    }

    public static Bridge firstBridge(boolean isRight) {
        if (isRight) {
            return RIGHT;
        }

        return DOWN;
    }

    public Bridge next(boolean isRight, boolean isLast) {
        if (this.equals(Bridge.RIGHT)) {
            return LEFT;
        }

        if (isLast) {
            return DOWN;
        }

        if (isRight) {
            return RIGHT;
        }

        return DOWN;
    }

    public Point move(Point now) {
        return op.apply(now);
    }
}
