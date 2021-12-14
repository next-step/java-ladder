package nextstep.ladder.model;

import java.util.List;

public class Line {

    public static final String BLANK_LINE = "     ";
    public static final String EXIST_LINE = "-----";
    private static final String LADDER_COLUMN = "|";

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
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
