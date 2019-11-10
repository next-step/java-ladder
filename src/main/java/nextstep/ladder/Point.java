package nextstep.ladder;

import java.util.Optional;

import static nextstep.ladder.PointType.*;

public class Point {

    private final PointType pointType;

    public Point(PointType pointType) {
        this.pointType = pointType;
    }

    public static Point createRandomlyHorizontalLine(RandomBooleanProvider randomBooleanProvider) {
        return new Point(randomBooleanProvider.get() ? HORIZONTAL_LINE : EMPTY);
    }

    public static Point createHorizontalLine() {
        return new Point(HORIZONTAL_LINE);
    }

    public static Point createEmpty() {
        return new Point(EMPTY);
    }

    public static Point createVerticalLine() {
        return new Point(VERTICAL_LINE);
    }

    public boolean hasConnection() {
        return pointType == HORIZONTAL_LINE;
    }

    @Override
    public String toString() {
        return pointType.getText();
    }
}
