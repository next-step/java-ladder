package nextstep.ladder.model;

import java.util.List;
import java.util.Optional;

public class Line {

    public static final String BLANK_LINE = "     ";
    public static final String EXIST_LINE = "-----";
    private static final String LADDER_COLUMN = "|";
    private static final int MIN_WIDTH = 2;
    private static final String MESSAGE_MIN_WIDTH = "너비가 최소 2는 되어야합니다.";

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = validationWidth(points);
    }

    private List<Boolean> validationWidth(List<Boolean> points) {
        return Optional.ofNullable(points)
                .filter(p -> p.size() >= MIN_WIDTH)
                .orElseThrow(() -> new IllegalArgumentException(MESSAGE_MIN_WIDTH));
    }

    private String isLine(boolean point) {
        return point ? EXIST_LINE : BLANK_LINE;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(BLANK_LINE + LADDER_COLUMN);
        points.forEach(point -> builder.append(isLine(point)).append(LADDER_COLUMN));
        return builder.toString();
    }
}
