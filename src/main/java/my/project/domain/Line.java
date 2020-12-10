package my.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created : 2020-12-04 오전 10:26
 * Developer : Seo
 */
public class Line {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int EVEN = 2;
    private final List<Symbol> points;

    public Line(int countOfPerson) {
        points = new ArrayList<>();
        int end = countOfPerson + countOfPerson - ONE;

        IntStream.range(ZERO, end)
                .forEach(y -> {
                    if (isVertical(y)) {
                        this.points.add(Symbol.VERTICAL);
                        return;
                    }
                    if (isBridge(y)) {
                        this.points.add(Symbol.BRIDGE);
                        return;
                    }
                    this.points.add(Symbol.NONE);
                });
    }

    private boolean isVertical(int y) {
        return y % EVEN == ZERO;
    }

    private boolean isBridge(int y) {
        boolean isTarget = makeBridgeTarget();

        if (isExcept(isTarget, y)) {
            return true;
        }
        return isTarget && isValid(y);
    }

    private boolean makeBridgeTarget() {
        return new Random().nextInt(EVEN) % EVEN == ZERO;
    }

    private boolean isExcept(boolean isTarget, int y) {
        return isTarget && y < EVEN;
    }

    private boolean isValid(int y) {
        int previousBridgeTargetIndex = y - EVEN;
        return points.get(previousBridgeTargetIndex) != Symbol.BRIDGE;
    }

    public List<Symbol> getPoints() {
        return points;
    }
}
