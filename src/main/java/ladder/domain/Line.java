package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final String WIDTH_REQUIRED = "가로라인이 존재해야합니다.";
    private static final int MINIMUM_USERS = 2;
    private static final String USER_SHOULD_MORE_THAN_TWO = "사람수는 2명 이상 이어야 합니다.";
    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int CENTER = 0;
    private final List<Point> widthLines;

    public Line(final int userCounts) {
        this(userCounts, new WidthGenerator(userCounts));
    }

    public Line(final int userCounts, WidthGenerator subLineGenerator) {
        validateSize(userCounts);
        this.widthLines = new ArrayList<>(validateLines(subLineGenerator.getWidthLines()));
    }

    private void validateSize(int users) {
        if (users < MINIMUM_USERS) {
            throw new IllegalArgumentException(USER_SHOULD_MORE_THAN_TWO);
        }
    }

    private List<Point> validateLines(List<Point> widthLines) {
        if (widthLines.isEmpty()) {
            throw new IllegalArgumentException(WIDTH_REQUIRED);
        }
        return new ArrayList<>(widthLines);
    }

    public int move(int index) {
        if (isLeft(index)) {
            return LEFT;
        }
        if (isRight(index)) {
            return RIGHT;
        }
        return CENTER;
    }

    public List<Point> getWidthLines() {
        return widthLines;
    }

    private Boolean getPoint(int index) {
        Point point = widthLines.get(index);
        return point.getPoint();
    }

    private boolean isLeft(int index) {
        return index > 0 && getPoint(index - 1);
    }

    private boolean isRight(int index) {
        return index < widthLines.size() && getPoint(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(widthLines, line.widthLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(widthLines);
    }
}
