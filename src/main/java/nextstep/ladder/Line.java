package nextstep.ladder;

import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points;

    public Line(int countOfVerticalLine, LineStrategy lineStrategy) {
        this.points = lineStrategy.generate(countOfVerticalLine);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int moveLine(int verticalLine) {

        if (isNotFirstAndLastVertical(verticalLine)) {
            if (checkLeftLine(verticalLine)) {
                return goToLeft(verticalLine);
            }

            if (checkRightLine(verticalLine)) {
                return goToRight(verticalLine);
            }
            return verticalLine;
        }

        if (isFirstVertical(verticalLine)) {
            if (checkRightLine(verticalLine)) {
                return goToRight(verticalLine);
            }
            return verticalLine;
        }

        if (checkLeftLine(verticalLine)) {
            return goToLeft(verticalLine);
        }
        return verticalLine;
    }

    private int goToRight(int vertical) {
        return vertical + 1;
    }

    private int goToLeft(int vertical) {
        return vertical - 1;
    }

    private boolean checkLeftLine(int vertical) {
        return points.get(vertical - 1);
    }

    private boolean checkRightLine(int vertical) {
        return points.get(vertical);
    }

    private boolean isNotFirstAndLastVertical(int vertical) {
        return !isFirstVertical(vertical) && !isLastVertical(vertical);
    }

    private boolean isFirstVertical(int vertical) {
        return vertical == 0;
    }

    private boolean isLastVertical(int vertical) {
        return vertical == points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
