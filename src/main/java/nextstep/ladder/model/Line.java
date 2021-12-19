package nextstep.ladder.model;

import java.util.List;
import java.util.Optional;

public class Line {
    public static final String BLANK_LINE = "     ";
    public static final String EXIST_LINE = "-----";
    public static final String LADDER_COLUMN = "|";

    private static final int MIN_WIDTH = 2;
    private static final String MESSAGE_MIN_WIDTH = "너비가 최소 2는 되어야합니다.";

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = validationWidth(points);
    }

    public static String isLine(boolean point) {
        return point ? EXIST_LINE : BLANK_LINE;
    }

    private List<Point> validationWidth(List<Point> points) {
        return Optional.ofNullable(points)
                .filter(p -> p.size() >= MIN_WIDTH)
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE_MIN_WIDTH));
    }

    public List<Point> getPoints() {
        return points;
    }
}
